package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class forgetPassword extends AppCompatActivity {

    TextView email ;
    Button verifyButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
        verifyButton = findViewById(R.id.verify);
        email = findViewById(R.id.femail);
        verifyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user_name = email.getText().toString();
                FirebaseAuth mAuth = FirebaseAuth.getInstance();
                mAuth.sendPasswordResetEmail(String.valueOf(user_name))
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()){
                                    Toast.makeText(forgetPassword.this,"Email verification send ! Please check your mail", Toast.LENGTH_LONG).show();
                                    startActivity(new Intent(forgetPassword.this,login.class));
                                }
                                else{
                                    Toast.makeText(forgetPassword.this,"Failed", Toast.LENGTH_LONG).show();
                                }

                            }
                        });

            }
        });


    }
}
