package com.asifnazir.urdubiblequiz.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.asifnazir.urdubiblequiz.R;
import com.asifnazir.urdubiblequiz.Session_management;
import com.asifnazir.urdubiblequiz.model.ProfileModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class InviteActivity extends AppCompatActivity {

    private FirebaseUser user;
    private  String oppositeUID;

    private TextView referCodeTv;
    private Button shareBtn, redeemBtn;

    FirebaseDatabase database;
    boolean status = false;

    Session_management session_management;

    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invite);

        init();

        session_management = new Session_management(this);

        if (!session_management.getRedeem().isEmpty())
            redeemBtn.setEnabled(false);

        database = FirebaseDatabase.getInstance();

        reference = FirebaseDatabase.getInstance().getReference().child("Users");

        loadData();
        redeemAvailability();
        clickListener();

    }

    private  void  redeemAvailability(){
        reference.child(user.getUid())
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (snapshot.exists() && snapshot.hasChild("redeemed")) {

                            boolean isAvailable = snapshot.child("redeemed").getValue(Boolean.class);

                            if (isAvailable) {
                                redeemBtn.setVisibility(View.GONE);
                                redeemBtn.setEnabled(false);
                            } else {
                                redeemBtn.setEnabled(true);
                                redeemBtn.setVisibility(View.VISIBLE);
                            }

                        }
                    }


                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
    }

    private void init(){



        referCodeTv = findViewById(R.id.referCodeTv);
        shareBtn = findViewById(R.id.shareBtn);
        redeemBtn = findViewById(R.id.redeemBtn);

        FirebaseAuth auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();
    }



    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    private void loadData(){

        reference.child(user.getUid())
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        String referCode = snapshot.child("referCode").getValue(String.class);
                        referCodeTv.setText(referCode);

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(InviteActivity.this, "Error:"+error.getMessage(), Toast.LENGTH_SHORT).show();

                        finish();
                    }
                });

    }
    private void clickListener(){
        shareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String referCode = referCodeTv.getText().toString();

                String shareBody = "Hey, i'm using the best earning app, Join using my invite code to instantly get 100 " +
                        "+ coins. My invite code is "+referCode+"\n"+
                        "Download from Play Store\n"+
                        "https://play.google.com/store/apps/details?id="+
                        getPackageName();

                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT, shareBody);
                startActivity(intent);
            }
        });

        redeemBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText editText = new EditText(InviteActivity.this);
                editText.setHint("abc123");

                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT);
                editText.setLayoutParams(layoutParams);

                AlertDialog.Builder alertDialog = new AlertDialog.Builder(InviteActivity.this);

                alertDialog.setTitle("Redeem Code");

                alertDialog.setView(editText);

                alertDialog.setPositiveButton("Redeem", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        String inputCode = editText.getText().toString();

                        if (TextUtils.isEmpty(inputCode)){
                            Toast.makeText(InviteActivity.this, "Input valid Code", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        if (inputCode.equals(referCodeTv.getText().toString())){
                            Toast.makeText(InviteActivity.this, "You can noy=t input your own code", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        redeemQuery(inputCode, dialog);

                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                alertDialog.show();
            }
        });

    }

    private void redeemQuery(String inputCode, final DialogInterface dialog){
        database.getReference().child("Users")
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        for (DataSnapshot children : snapshot.getChildren()){
                            User user = children.getValue(User.class);
                            if (user.getReferCode().equals(inputCode))
                                status = true;
                            Log.e("value", String.valueOf(user.getReferCode()));
                            Log.e("status", String.valueOf(status));
                        }
                        if (status)
                        {
                            DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference("Users").child(FirebaseAuth.getInstance().getUid())
                                    .child("coins");
                            mDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
                                @Override
                                public void onDataChange(DataSnapshot dataSnapshot) {
                                    long totalLikes =(long) dataSnapshot.getValue();
                                    mDatabase.setValue(totalLikes + 100);
                                    dialog.dismiss();
                                    session_management.setRedeem("true");
                                    redeemBtn.setEnabled(false);
                                    Toast.makeText(InviteActivity.this, "Congrats", Toast.LENGTH_SHORT).show();
                                }

                                @Override
                                public void onCancelled(DatabaseError databaseError) {

                                }
                            });
                        }
                        else
                            Toast.makeText(InviteActivity.this, "Invalid Refer Code", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

//        Query query = reference.orderByChild("referCode").equalTo(inputCode);
//
//        query.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
//
//                    oppositeUID = dataSnapshot.getKey();
//
//                    reference.child(oppositeUID)
//                            .addListenerForSingleValueEvent(new ValueEventListener() {
//                                @Override
//                                public void onDataChange(@NonNull DataSnapshot snapshot) {
//                                    ProfileModel model = snapshot.child(oppositeUID).getValue(ProfileModel.class);
//                                    ProfileModel myModel = snapshot.child(user.getUid()).getValue(ProfileModel.class);
//
//                                    int coins = model.getCoins();
//                                    int updateCoins = coins + 100;
//
//                                    int myCoins = myModel.getCoins();
//                                    int myUpdate = myCoins + 100;
//
//                                    HashMap<String, Object> map = new HashMap<>();
//                                    map.put("coins" , updateCoins);
//
//                                    HashMap<String, Object> myMap = new HashMap<>();
//                                    myMap.put("coins" , myUpdate);
//                                    myMap.put("redeemed" , true);
//
//                                    reference.child(oppositeUID).updateChildren(map);
//                                    reference.child(user.getUid()).updateChildren(myMap)
//                                            .addOnCompleteListener(new OnCompleteListener<Void>() {
//                                                @Override
//                                                public void onComplete(@NonNull Task<Void> task) {
//                                                     dialog.dismiss();
//                                                    Toast.makeText(InviteActivity.this, "Congrats", Toast.LENGTH_SHORT).show();
//                                                }
//                                            });
//
//                                }
//
//                                @Override
//                                public void onCancelled(@NonNull DatabaseError error) {
//
//                                }
//                            });
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//                Toast.makeText(InviteActivity.this, "Error: "+error.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });

    }

}