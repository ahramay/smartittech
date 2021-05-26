package com.asifnazir.urdubiblequiz.activity;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;
import android.widget.Toolbar;


import com.asifnazir.urdubiblequiz.AppController;
import com.asifnazir.urdubiblequiz.SharedPreferenceUtil;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.asifnazir.urdubiblequiz.R;

import com.asifnazir.urdubiblequiz.databinding.ActivityMainBinding;
import com.asifnazir.urdubiblequiz.helper.SettingsPreferences;
import com.asifnazir.urdubiblequiz.Constant;

import me.ibrahimsn.lib.OnItemSelectedListener;

public class MainActivity<onCreate> extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    SharedPreferences settings;
    ActivityMainBinding binding;
    FirebaseAuth auth;

    NavigationView nav;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;
    androidx.appcompat.widget.Toolbar toolbar;
    private InterstitialAd mInterstitialAd;

    public static Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        auth = FirebaseAuth.getInstance();
        settings = getSharedPreferences(SettingsPreferences.SETTING_Quiz_PREF, 0);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3187400369534799/4614985861");



        nav=(NavigationView)findViewById(R.id.navmenu);
        nav.setNavigationItemSelectedListener(this);
        drawerLayout=(DrawerLayout) findViewById(R.id.drawer);

        toggle = new ActionBarDrawerToggle(
                this,drawerLayout,toolbar,R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        context = getApplicationContext();
        HomeFragment fragment = new HomeFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout,fragment,"Home");
        transaction.commit();
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();

        if (id == R.id.home){
            if (SettingsPreferences.getSoundEnableDisable(context)) {
                Constant.backSoundonclick(context);
            }
            if (SettingsPreferences.getVibration(context)) {
                Constant.vibrate(context, Constant.VIBRATION_DURATION);
            }

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
            HomeFragment fragment = new HomeFragment();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.frame_layout,fragment,"Home");
            transaction.commit();
        }
        else if (id == R.id.wallet){
            if (SettingsPreferences.getSoundEnableDisable(context)) {
                Constant.backSoundonclick(context);
            }
            if (SettingsPreferences.getVibration(context)) {
                Constant.vibrate(context, Constant.VIBRATION_DURATION);
            }
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
            WalletFragment fragment = new WalletFragment();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.frame_layout, fragment, "Wallet");
            transaction.commit();
        }
        else if (id == R.id.profile){
            if (SettingsPreferences.getSoundEnableDisable(context)) {
                Constant.backSoundonclick(context);
            }
            if (SettingsPreferences.getVibration(context)) {
                Constant.vibrate(context, Constant.VIBRATION_DURATION);
            }
            ProfileFragment fragment = new ProfileFragment();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.frame_layout, fragment, "Profile");
            transaction.commit();
        }
        else if (id == R.id.logout) {
                if (SettingsPreferences.getSoundEnableDisable(context)) {
                Constant.backSoundonclick(context);
                }
                if (SettingsPreferences.getVibration(context)) {
                Constant.vibrate(context, Constant.VIBRATION_DURATION);
                }
                auth.signOut();
                 Intent intent = new Intent (MainActivity.this, LoginActivity.class);
                 startActivity(intent);
                 finish();
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {

        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }
    }
    @Override
    protected void onPause() {
        AppController.StopSound();
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        AppController.playSound();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.home_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
            case R.id.setting:
                if (SettingsPreferences.getSoundEnableDisable(context)) {
                    Constant.backSoundonclick(context);
                }
                if (SettingsPreferences.getVibration(context)) {
                    Constant.vibrate(context, Constant.VIBRATION_DURATION);
                }
                Intent intent = new Intent(this, SettingActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.open_next, R.anim.close_next);
                return true;


            default:
                return super.onOptionsItemSelected(item);
        }


    }
}