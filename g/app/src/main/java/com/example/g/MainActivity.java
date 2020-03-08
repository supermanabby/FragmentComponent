package com.example.g;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.common.SignInButton;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {


    private final static int RC_SIGN_IN = 2;
    GoogleSignInClient mGoogleSignInClient;
    private FirebaseAuth mAuth;
    SignInButton signInButton;
    private Button btnSignOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         signInButton =findViewById(R.id.signInButton);
         mAuth =  FirebaseAuth.getInstance();
         btnSignOut = findViewById(R.id.sign_out);
    }
}
