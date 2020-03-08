package com.example.firebaseauthdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {



    private Button signUp ;
    private EditText email;
    private EditText password;
    private TextView signIn ;
    ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;
    private Button nextPage;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        firebaseAuth = FirebaseAuth.getInstance() ;
        progressDialog = new ProgressDialog(this);
        signUp = (Button)(findViewById(R.id.signup)) ;
        email = (EditText)(findViewById(R.id.email));
        password = (EditText)(findViewById(R.id.password));
        signIn = (TextView) (findViewById(R.id.signin));
        nextPage = (Button)(findViewById(R.id.nextPage));
        signUp.setOnClickListener(this);
        signIn.setOnClickListener(this);
        nextPage.setOnClickListener(this);

        nextPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, googleAuth.class);
                startActivity(intent);
            }
        });
    }
    private void registerUser(){

        String getEmail = email.getText().toString();
        String getPassword = password.getText().toString();

        if(TextUtils.isEmpty(getEmail)){
            Toast.makeText(this, "Please enter email", Toast.LENGTH_SHORT).show();
            return;
        }

        if(TextUtils.isEmpty(getPassword)){
            Toast.makeText(this,"Please enter password", Toast.LENGTH_SHORT).show();
        }

            progressDialog.setMessage("Registering User ...");
            progressDialog.show();

            firebaseAuth.createUserWithEmailAndPassword(getEmail, getPassword).
                    addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(MainActivity.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                            } else{
                                Toast.makeText(MainActivity.this, "Could not registered. Please try again", Toast.LENGTH_SHORT).show();
                            }


                        }
                    }) ;

    }




    public void onClick(View view){
            if(view == signUp){
                registerUser();
            }
            if (view == signIn){

            }



    }


}
