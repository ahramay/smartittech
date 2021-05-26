package com.asifnazir.urdubiblequiz.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.asifnazir.urdubiblequiz.AppController;
import com.asifnazir.urdubiblequiz.Session_management;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.asifnazir.urdubiblequiz.Constant;
import com.asifnazir.urdubiblequiz.R;
import com.asifnazir.urdubiblequiz.databinding.ActivityQuizBinding;
import com.asifnazir.urdubiblequiz.helper.SettingsPreferences;

import java.util.ArrayList;
import java.util.Random;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class QuizActivity extends AppCompatActivity {

    ActivityQuizBinding binding;
    SharedPreferences settings;
    ArrayList<Question> questions;
    int index = 0;
    Question question;
    CountDownTimer timer;
    FirebaseFirestore database;
    int correctAnswers = 0;
    int wrongAnswers = 0;
    public String catId;
    ProgressDialog progress;
    Session_management session_management;
    int queue_number;
    public static Context context;
    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityQuizBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3187400369534799/8301227237");

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

        binding.adView2.loadAd(adRequest);

        binding.adView2.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
                Toast.makeText(QuizActivity.this, "Add is Loaded.", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdClicked() {
                super.onAdClicked();
            }

            @Override
            public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                super.onAdFailedToLoad(loadAdError);
                binding.adView2.loadAd(adRequest);
            }
        });


        questions = new ArrayList<>();
        database = FirebaseFirestore.getInstance();
        session_management = new Session_management(this);
        settings = getSharedPreferences(SettingsPreferences.SETTING_Quiz_PREF, 0);

        catId = getIntent().getStringExtra("catId");

        progress = new ProgressDialog(this);
        progress.setTitle("Loading");
        progress.setMessage("Please Wait while quiz loading...");
        progress.setCancelable(false); // disable dismiss by tapping outside of the dialog
        progress.show();

        queue_number = session_management.getIndex();

        Random random = new Random();
        final int rand = random.nextInt(50);

        Log.e("Rand", String.valueOf(rand));

        database.collection("categories")
                .document(catId)
                .collection("questions")
                .whereGreaterThanOrEqualTo("index", (queue_number+1))
                .orderBy("index")
                .limit(5).get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                if(queryDocumentSnapshots.getDocuments().size() < 5) {
                    database.collection("categories")
                            .document(catId)
                            .collection("questions")
                            .whereLessThanOrEqualTo("index", (queue_number+1))
                            .orderBy("index")
                            .limit(5).get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                        @Override
                        public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                            for(DocumentSnapshot snapshot : queryDocumentSnapshots) {
                                Question question = snapshot.toObject(Question.class);
                                questions.add(question);
                                progress.dismiss();
                            }
                            progress.dismiss();
                            setNextQuestion();
                        }
                    });
                    queue_number = 0;
                    queue_number = queue_number + 5;
                    Log.e("IfCondition"," d sd sd ");
                    Log.e("IF_Rand", String.valueOf((queue_number+1)));
                } else {
                    for(DocumentSnapshot snapshot : queryDocumentSnapshots) {
                        Question question = snapshot.toObject(Question.class);
                        questions.add(question);
                        progress.dismiss();
                    }
                    setNextQuestion();
                    Log.e("ElseCondition"," d sd sd ");
                    Log.e("Else_Rand", String.valueOf((queue_number+1)));
                    queue_number = queue_number + 5;
                }
                session_management.setIndex(queue_number);
            }
        });

        resetTimer();
        context = getApplicationContext();




    }


    void resetTimer() {
        timer = new CountDownTimer(15000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                binding.timer.setText(String.valueOf(millisUntilFinished/1000));
            }

            @Override
            public void onFinish() {
                changeQuestion();
            }
        };
    }


    void showAnswer() {
        if(question.getAnswer().equals(binding.option1.getText().toString()))
            binding.option1.setBackground(getResources().getDrawable(R.drawable.option_right));
        else if(question.getAnswer().equals(binding.option2.getText().toString()))
            binding.option2.setBackground(getResources().getDrawable(R.drawable.option_right));
        else if(question.getAnswer().equals(binding.option3.getText().toString()))
            binding.option3.setBackground(getResources().getDrawable(R.drawable.option_right));
        else if(question.getAnswer().equals(binding.option4.getText().toString()))
            binding.option4.setBackground(getResources().getDrawable(R.drawable.option_right));
    }

    void setNextQuestion() {

        if(timer != null)
            timer.cancel();

        timer.start();
        if(index < questions.size()) {
            binding.questionCounter.setText(String.format("%d/%d", (index+1), questions.size()));
            question = questions.get(index);
            binding.question.setText(question.getQuestion());
            binding.option1.setText(question.getOption1());
            binding.option2.setText(question.getOption2());
            binding.option3.setText(question.getOption3());
            binding.option4.setText(question.getOption4());
        }
    }

    void checkAnswer(TextView textView) {
        String selectedAnswer = textView.getText().toString();
        if (SettingsPreferences.getVibration(getApplicationContext())) {
            Constant.vibrate(getApplicationContext(), Constant.VIBRATION_DURATION);
        }
        if(selectedAnswer.equals(question.getAnswer())) {
            correctAnswers++;
            textView.setBackground(getResources().getDrawable(R.drawable.option_right));
            if (SettingsPreferences.getSoundEnableDisable(getApplicationContext())) {
                Constant.setrightAnssound(getApplicationContext());
            }
        } else {
            wrongAnswers++;
            showAnswer();
            textView.setBackground(getResources().getDrawable(R.drawable.option_wrong));
            if (SettingsPreferences.getSoundEnableDisable(getApplicationContext())) {
                Constant.setwronAnssound(getApplicationContext());
            }
//            changeQuestion();
        }
    }

    void reset() {
        binding.option1.setBackground(getResources().getDrawable(R.drawable.background_splash_button));
        binding.option2.setBackground(getResources().getDrawable(R.drawable.background_splash_button));
        binding.option3.setBackground(getResources().getDrawable(R.drawable.background_splash_button));
        binding.option4.setBackground(getResources().getDrawable(R.drawable.background_splash_button));
    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.option_1:
            case R.id.option_2:
            case R.id.option_3:
            case R.id.option_4:
                if(timer!=null)
                    timer.cancel();
                TextView selected = (TextView) view;
                checkAnswer(selected);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        index++;
                        reset();
                        if(index < questions.size()) {
                            setNextQuestion();
                            Log.e("QuestionSize",""+questions.size());
                            Log.e("index",""+index);
                        } else {
                            Intent intent = new Intent(QuizActivity.this, ResultActivity.class);
                            intent.putExtra("correct", correctAnswers);
                            intent.putExtra("wrong", wrongAnswers);
                            intent.putExtra("total", questions.size());
                            intent.putExtra("catId", catId);
                            startActivity(intent);
                            finishAffinity();
                            //Toast.makeText(this, "Quiz Finished.", Toast.LENGTH_SHORT).show();
                        }
                    }
                },1500);
                break;
            case R.id.nextBtn:
                index++;
                reset();
                if(index < questions.size()) {
                    setNextQuestion();
                } else {
                    Intent intent = new Intent(QuizActivity.this, ResultActivity.class);
                    intent.putExtra("correct", correctAnswers);
                    intent.putExtra("total", questions.size());
                    intent.putExtra("wrong", wrongAnswers);
                    startActivity(intent);
                    //Toast.makeText(this, "Quiz Finished.", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    private void changeQuestion(){
        if(index < questions.size()) {
            index++;
            setNextQuestion();
        } else {
            Intent intent = new Intent(QuizActivity.this, ResultActivity.class);
            intent.putExtra("correct", correctAnswers);
            intent.putExtra("total", questions.size());
            intent.putExtra("wrong", wrongAnswers);
            intent.putExtra("catId", catId);
            startActivity(intent);
            finishAffinity();
            //Toast.makeText(this, "Quiz Finished.", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onBackPressed() {

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
        new AlertDialog.Builder(this)
                .setTitle("EXIT")
                .setMessage("Are you sure you want to exit?")
                // Specifying a listener allows you to take an action before dismissing the dialog.
                // The dialog is automatically dismissed when a dialog button is clicked.
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Continue with delete operation
                        timer.cancel();
                        QuizActivity.super.onBackPressed();
                        startActivity(new Intent(QuizActivity.this,MainActivity.class));
                        finishAffinity();
                    }
                })
                // A null listener allows the button to dismiss the dialog and take no further action.
                .setNegativeButton(android.R.string.no, null)
//                        .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }

}