package com.example.fetchdata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.webkit.*;

import java.net.Inet4Address;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText name = findViewById(R.id.Name);
        final EditText email = findViewById(R.id.Email) ;
        Button submit = findViewById(R.id.button);
        Button linkedin = findViewById(R.id.linkedin);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),dataDisplay.class);
                intent.putExtra("Name" , name.getText().toString());
                intent.putExtra("Email" , email.getText().toString());
                startActivity(intent);
            }
        });


        linkedin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),web.class);
                startActivity(intent);
            }
        });

    }
}
