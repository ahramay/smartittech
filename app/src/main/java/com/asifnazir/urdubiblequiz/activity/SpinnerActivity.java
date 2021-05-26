package com.asifnazir.urdubiblequiz.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.asifnazir.urdubiblequiz.Constant;
import com.asifnazir.urdubiblequiz.R;
import com.asifnazir.urdubiblequiz.Session_management;
import com.asifnazir.urdubiblequiz.helper.SettingsPreferences;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.asifnazir.urdubiblequiz.SpinWheel.LuckyWheelView;
import com.asifnazir.urdubiblequiz.SpinWheel.model.LuckyItem;
import com.asifnazir.urdubiblequiz.databinding.ActivitySpinnerBinding;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;

public class SpinnerActivity extends AppCompatActivity {

    ActivitySpinnerBinding binding;
    Session_management session_management;
    AlertDialog.Builder builder;
    AlertDialog alertDialog;
    ViewGroup viewGroup;
    View dialogView;
    TextView remainder;
    Date c;
    SimpleDateFormat df;
    String formattedDate;
    private InterstitialAd mInterstitialAd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySpinnerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3187400369534799/8836753165");

        final AdRequest adRequest = new  AdRequest.Builder().build();
        mInterstitialAd.loadAd(adRequest);

        mInterstitialAd.setAdListener(new AdListener(){
            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
                if (mInterstitialAd.isLoaded())
                    mInterstitialAd.show();
            }

            @Override
            public void onAdFailedToLoad(LoadAdError loadAdError) {
                super.onAdFailedToLoad(loadAdError);
                mInterstitialAd.loadAd(adRequest);
            }
        });
        List<LuckyItem> data = new ArrayList<>();
        session_management = new Session_management(this);
        remainder = (TextView) binding.getRoot().findViewById(R.id.remaning);
        c = Calendar.getInstance().getTime();
        System.out.println("Current time => " + c);

        df = new SimpleDateFormat("dd-MMM-yyyy", Locale.getDefault());
        formattedDate = df.format(c);

        if (formattedDate.equals(session_management.getSpinDate()))
        {
            remainder.setText(String.valueOf(0));
        }
        else
        {
            remainder.setText(String.valueOf(1));
        }

        LuckyItem luckyItem1 = new LuckyItem();
        luckyItem1.topText = "5";
        luckyItem1.secondaryText = "COINS";
        luckyItem1.textColor = Color.parseColor("#212121");
        luckyItem1.color = Color.parseColor("#eceff1");
        data.add(luckyItem1);

        LuckyItem luckyItem2 = new LuckyItem();
        luckyItem2.topText = "10";
        luckyItem2.secondaryText = "COINS";
        luckyItem2.color = Color.parseColor("#00cf00");
        luckyItem2.textColor = Color.parseColor("#ffffff");
        data.add(luckyItem2);

        LuckyItem luckyItem3 = new LuckyItem();
        luckyItem3.topText = "15";
        luckyItem3.secondaryText = "COINS";
        luckyItem3.textColor = Color.parseColor("#212121");
        luckyItem3.color = Color.parseColor("#eceff1");
        data.add(luckyItem3);

        LuckyItem luckyItem4 = new LuckyItem();
        luckyItem4.topText = "20";
        luckyItem4.secondaryText = "COINS";
        luckyItem4.color = Color.parseColor("#7f00d9");
        luckyItem4.textColor = Color.parseColor("#ffffff");
        data.add(luckyItem4);

        LuckyItem luckyItem5 = new LuckyItem();
        luckyItem5.topText = "25";
        luckyItem5.secondaryText = "COINS";
        luckyItem5.textColor = Color.parseColor("#212121");
        luckyItem5.color = Color.parseColor("#eceff1");
        data.add(luckyItem5);

        LuckyItem luckyItem6 = new LuckyItem();
        luckyItem6.topText = "30";
        luckyItem6.secondaryText = "COINS";
        luckyItem6.color = Color.parseColor("#dc0000");
        luckyItem6.textColor = Color.parseColor("#ffffff");
        data.add(luckyItem6);

        LuckyItem luckyItem7 = new LuckyItem();
        luckyItem7.topText = "35";
        luckyItem7.secondaryText = "COINS";
        luckyItem7.textColor = Color.parseColor("#212121");
        luckyItem7.color = Color.parseColor("#eceff1");
        data.add(luckyItem7);

        LuckyItem luckyItem8 = new LuckyItem();
        luckyItem8.topText = "0";
        luckyItem8.secondaryText = "COINS";
        luckyItem8.color = Color.parseColor("#008bff");
        luckyItem8.textColor = Color.parseColor("#ffffff");
        data.add(luckyItem8);


        binding.wheelview.setData(data);
        binding.wheelview.setRound(5);


        binding.spinBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (formattedDate.equals(session_management.getSpinDate()))
                {
                    showAlertDialog();
                }
                else {
                    Random r = new Random();
                    int randomNumber = r.nextInt(8);

                    binding.wheelview.startLuckyWheelWithTargetIndex(randomNumber);
                    session_management.setSpinDate(formattedDate);
                }
            }
        });

        binding.wheelview.setLuckyRoundItemSelectedListener(new LuckyWheelView.LuckyRoundItemSelectedListener() {
            @Override
            public void LuckyRoundItemSelected(int index) {
                updateCash(index);
            }
        });
    }

    void updateCash(int index) {
        long cash = 0;
        switch (index) {
            case 0:
                cash = 5;
                break;
            case 1:
                cash = 10;
                break;
            case 2:
                cash = 15;
                break;
            case 3:
                cash = 20;
                break;
            case 4:
                cash = 25;
                break;
            case 5:
                cash = 30;
                break;
            case 6:
                cash = 35;
                break;
            case 7:
                cash = 0;
                break;
        }
        long coin = cash;
        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference("Users").child(FirebaseAuth.getInstance().getUid())
                .child("coins");
        mDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                long totalLikes =(long) dataSnapshot.getValue();
                mDatabase.setValue(totalLikes + coin);
                showCongratsDialog(coin);
                remainder.setText(String.valueOf(0));
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
    private void showCongratsDialog(long coin)
    {
        builder = new AlertDialog.Builder(SpinnerActivity.this);
        viewGroup = findViewById(android.R.id.content);
        dialogView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.dialog_congrats_layout, viewGroup, false);
        builder.setView(dialogView);
        alertDialog = builder.create();
        alertDialog.setCancelable(false);
        alertDialog.show();

        TextView coin_wins, ok;

        ok = (TextView) dialogView.findViewById(R.id.ok);
        coin_wins = (TextView) dialogView.findViewById(R.id.coin_wins);

        coin_wins.setText( coin + " coins");

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
            }
        });
    }
    private void showAlertDialog()
    {
        builder = new AlertDialog.Builder(SpinnerActivity.this);
        viewGroup = findViewById(android.R.id.content);
        dialogView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.dialog_alert_layout, viewGroup, false);
        builder.setView(dialogView);
        alertDialog = builder.create();
        alertDialog.setCancelable(false);
        alertDialog.show();

        GifImageView gifImageView;
        TextView ok;

        gifImageView = (GifImageView) dialogView.findViewById(R.id.gif);
        pl.droidsonroids.gif.GifDrawable gifDrawable = null;
        try {
            gifDrawable = new GifDrawable(getResources(), R.drawable.empty);
            gifDrawable.setLoopCount(1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        gifImageView.setImageDrawable(gifDrawable);
        ok = (TextView) dialogView.findViewById(R.id.ok);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
            }
        });
    }
}