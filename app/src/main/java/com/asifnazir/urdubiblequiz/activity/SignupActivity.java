package com.asifnazir.urdubiblequiz.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.asifnazir.urdubiblequiz.Session_management;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.asifnazir.urdubiblequiz.R;
import com.asifnazir.urdubiblequiz.databinding.ActivitySignupBinding;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;

public class SignupActivity extends AppCompatActivity {

    ActivitySignupBinding binding;
    FirebaseAuth auth;
    FirebaseDatabase database;
    ProgressDialog dialog;
    GoogleSignInClient mGoogleSignInClient;

    private Button createNewBtn;
    private EditText nameBox, emailBox, passwordBox, refCode;
    private ProgressBar progressBar;
    boolean status = false;


    Session_management session_management;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignupBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        session_management = new Session_management(this);

        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        dialog = new ProgressDialog(this);
        dialog.setMessage("WE're Creating new account...");

        init();
        clickListener();
        // Configure Google Sign In
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
        binding.tvClickSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignupActivity.this,LoginActivity.class ));
            }
        });

        binding.googleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
            }
        });
    }
    private void init(){
        emailBox  = findViewById(R.id.emailBox);
        nameBox   = findViewById(R.id.nameBox);
        refCode   = findViewById(R.id.referCode);
        passwordBox = findViewById(R.id.passwordBox);
        createNewBtn = findViewById(R.id.createNewBtn);
        progressBar = findViewById(R.id.progressBar);
    }
    private void clickListener(){
        createNewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameBox.getText().toString();
                String email = emailBox.getText().toString();
                String pass  = passwordBox.getText().toString();
                String code = refCode.getText().toString();

                if (name.isEmpty()){
                    nameBox.setError("Required name");
                    return;
                }
                if (email.isEmpty()){
                    emailBox.setError("Required email");
                    return;
                }
                if (pass.isEmpty()){
                    passwordBox.setError("Required password");
                    return;
                }

                if (code.length() > 0)
                {
                    createAccount(email, pass,true);
                }
                else
                {
                    createAccount(email, pass,false);
                }
            }
        });
    }

    private void createAccount(String email, String password, boolean ref){
        progressBar.setVisibility(View.VISIBLE);
        auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            FirebaseUser user = auth.getCurrentUser();
                            assert user != null;
                            session_management.setRedeem("");
                            updateUi(user, email, ref);
                        }else{
                            progressBar.setVisibility(View.GONE);
                            Toast.makeText(SignupActivity.this, "Error :" + task.getException().getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }


    private void updateUi(FirebaseUser user , String email, boolean ref){
        String refer = email.substring(0, email.lastIndexOf("@"));
        String referCode = refer.replace(".", "");

        HashMap<String, Object > map = new HashMap<>();
        map.put("name", nameBox.getText().toString());
        map.put("pass", passwordBox.getText().toString());
        map.put("email", email);
        map.put("uid", user.getUid());
        if (ref)
            map.put("coins", 25);
        else
            map.put("coins", 0);
        map.put("referCode", referCode);

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("Users");

        reference.child(user.getUid())
                .setValue(map)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(SignupActivity.this, "Welcome here", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(SignupActivity.this, MainActivity.class));
                            finish();
                        }
                        else {
                            Toast.makeText(SignupActivity.this, "Error :"+
                                            task.getException().getMessage() ,
                                    Toast.LENGTH_SHORT).show();
                        }

                        progressBar.setVisibility(View.GONE);
                    }
                });
    }

    int RC_SIGN_IN = 65;
    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                // Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = task.getResult(ApiException.class);
                Log.d("TAG", "firebaseAuthWithGoogle:" + account.getId());
                firebaseAuthWithGoogle(account.getIdToken());
            } catch (ApiException e) {
                // Google Sign In failed, update UI appropriately
                Log.w("TAG", "Google sign in failed", e);
                // ...
            }
        }
    }
    private void firebaseAuthWithGoogle(String idToken) {
        AuthCredential credential = GoogleAuthProvider.getCredential(idToken, null);
        auth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("TAG", "signInWithCredential:success");
                            FirebaseUser user = auth.getCurrentUser();

                            User users = new User();
                            users.setUserId(user.getUid());
                            users.setName(user.getDisplayName());
                            users.setProfile(user.getPhotoUrl().toString());
                            database.getReference().child("Users").child(user.getUid()).setValue(user);
                            Intent intent = new Intent(SignupActivity.this ,MainActivity.class);
                            startActivity(intent);
                            Toast.makeText(SignupActivity.this, "Sign in With Google", Toast.LENGTH_SHORT).show();

                            // updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("TAG", "signInWithCredential:failure", task.getException());
                            // Snackbar.make(mBinding.mainLayout, "Authentication Failed.", Snackbar.LENGTH_SHORT).show();
                            // updateUI(null);
                        }

                        // ...
                    }
                });
    }
}