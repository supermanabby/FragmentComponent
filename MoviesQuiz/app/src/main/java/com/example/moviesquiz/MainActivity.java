package com.example.moviesquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.content.Intent;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    ImageButton submit ;
    int  checkedbutton, bollywood,hollywood;
    RadioButton selected;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        radioGroup= (RadioGroup) findViewById(R.id.radioGroup);
        submit = (ImageButton) findViewById(R.id.submit);
        checkedbutton = radioGroup.getCheckedRadioButtonId() ;
        selected = (RadioButton)findViewById(checkedbutton);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkedbutton == 1){
                    Intent bollowoodIntent = new Intent(MainActivity.this, Main2Activity.class);
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Hello", Toast.LENGTH_SHORT);
                }
            }
        });



    }
}
