package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class login extends AppCompatActivity {

     FirebaseAuth mfirebaseAuth;

    FirebaseUser user;
    EditText email;
    EditText password;
    Button login_Button;
    TextView forget_password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        email = findViewById(R.id.email);
        password  =findViewById(R.id.password);
        login_Button = findViewById(R.id.login_button);



        login_Button.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                String user_email = email.getText().toString();
                String user_password = password.getText().toString();
                mfirebaseAuth = FirebaseAuth.getInstance();
                mfirebaseAuth.signInWithEmailAndPassword(user_email, user_password)
                        .addOnCompleteListener(login.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()){
                                    FirebaseUser user = mfirebaseAuth.getCurrentUser();
                                    // startActivity(new Intent(login.this,afterLogin.class));
                                    Toast.makeText(login.this,"Login Successfull",Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(login.this, afterLogin.class));
                                }
                                else{
                                    Toast.makeText(login.this,"Authentication failed",Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
            });
    }

    public void onClick(View v){
        Toast.makeText(login.this,"", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(login.this,forgetPassword.class));


    }

}
