package com.example.firebaseauthdemo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;


public class googleAuth extends AppCompatActivity implements View.OnClickListener {


    private final static int RC_SIGN_IN = 2;
    GoogleSignInClient mGoogleSignInClient;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_auth);
        findViewById(R.id.sign_in_button).setOnClickListener(this);
        findViewById(R.id.signOut).setOnClickListener(this);
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
         mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
        ;// Build a GoogleSignInClient with the options specified by gso.
    }


    private void signIn() {

        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);

    }


        @Override
        protected void onStart () {
            super.onStart();
            GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
            Toast toast = Toast.makeText(this, "You are already a user ", Toast.LENGTH_SHORT);
            //updateUI(account);
        }


        @Override
        public void onClick (View v){
            switch (v.getId()) {
                case R.id.sign_in_button:
                    signIn();
                    break;
                case R.id.signOut:
                    mGoogleSignInClient.signOut();
                    Toast.makeText(this,"Successfully logged Out",Toast.LENGTH_SHORT);
            }
        }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==RC_SIGN_IN){
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
    }

        private void handleSignInResult(Task<GoogleSignInAccount> completedTask){
        try{
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);
            }
        catch (ApiException e){
             final String TAG = googleAuth.class.getSimpleName();
             Log.w(TAG, "SignInResult:failed code" + e.getStatusCode());
        }
        }
    }




