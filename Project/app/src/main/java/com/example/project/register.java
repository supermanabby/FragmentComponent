package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import static android.widget.Toast.LENGTH_SHORT;

public class register extends AppCompatActivity {

    EditText email;
    EditText password;
    Button registerr;
    FirebaseAuth firebaseAuth;
    ProgressBar progressBar;
    //ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        firebaseAuth = FirebaseAuth.getInstance();
        registerr = findViewById(R.id.button);
        email = findViewById(R.id.Email);
        password   = findViewById(R.id.password);

        registerr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getEmail =email.getText().toString();
                String getPassword = password.getText().toString();

                if (TextUtils.isEmpty(getEmail)){
                    Toast.makeText(register.this, "Please enter email", LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(getPassword)){
                    Toast.makeText(register.this,"Enter valid password", LENGTH_SHORT).show();
                    return;
                }


                firebaseAuth.createUserWithEmailAndPassword(getEmail, getPassword).
                        addOnCompleteListener(register.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(register.this, "Login Successfull", LENGTH_SHORT).show();
                                    startActivity(new Intent(register.this, afterLogin.class));
                                } else {
                                    Toast.makeText(register.this, "Registration Failed", LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });
    }
}
