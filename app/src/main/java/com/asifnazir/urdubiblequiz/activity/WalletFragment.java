package com.asifnazir.urdubiblequiz.activity;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.asifnazir.urdubiblequiz.databinding.FragmentWalletBinding;

public class WalletFragment extends Fragment {

    public WalletFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    FragmentWalletBinding binding;
    FirebaseAuth auth;
    FirebaseDatabase database;
    User user;
    ProgressDialog progress;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        binding = FragmentWalletBinding.inflate(inflater, container, false);
        auth  = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        progress = new ProgressDialog(getContext());
        progress.setTitle("Loading");
        progress.setMessage("Please Wait Wallet is loading...");
        progress.setCancelable(false); // disable dismiss by tapping outside of the dialog
        progress.show();


        AdRequest adRequest = new  AdRequest.Builder().build();
        binding.adView3.loadAd(adRequest);

        database.getReference().child("Users").child(FirebaseAuth.getInstance().getUid())
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        user = snapshot.getValue(User.class);
                        binding.currentCoin.setText(String.valueOf(user.getCoins()));
                        progress.dismiss();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        progress.dismiss();
                    }
                });
        binding.sendRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(user.getCoins() > 50000) {
                    String uid = FirebaseAuth.getInstance().getUid();
                    String payPal = binding.emailBox.getText().toString();
                    WithdrawRequest request = new WithdrawRequest(uid, payPal, user.getName());

                    progress.show();

                    database.getReference().child("Withdraws").child(FirebaseAuth.getInstance().getUid())
                            .setValue(request)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()){
                                        progress.dismiss();
                                        Toast.makeText(getContext(), "Request sent successfully.", Toast.LENGTH_SHORT).show();
                                    }
                                    else {
                                        progress.dismiss();
                                        Toast.makeText(getContext(), "Error :"+ task.getException().getMessage() , Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                } else {
                    Toast.makeText(getContext(), "You need more coins to get withdraw.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return binding.getRoot();
    }
}