package com.example.classapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.classapp2.R.string.whenMaleIsChecked;

public class MainActivity extends AppCompatActivity {

    private RadioButton male;
    private RadioButton female ;
    private Button submit ;
    private Button nextPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        male = (RadioButton) findViewById(R.id.male);
        female = (RadioButton) findViewById(R.id.female);
        submit  = (Button) findViewById(R.id.button);
        nextPage = (Button) findViewById(R.id.nextPage);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(male.isChecked()){
                    Toast.makeText(getApplicationContext(),"Male is checked",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Female is checked",Toast.LENGTH_SHORT).show();
                }
            }
        });


        nextPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent myintent = new Intent(MainActivity.this, checked.class);
                    startActivity(myintent);
            }
        });


    }
}
