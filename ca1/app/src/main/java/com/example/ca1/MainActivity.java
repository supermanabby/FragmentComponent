package com.example.ca1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    EditText num1 ;
    EditText num2  ;
    TextView output;
    Double numm1, numm2, result;
    int number1, number2 ;
    ImageButton multiplication, addtion, substraction ;
   // int result ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        num1 = (EditText)findViewById(R.id.num1);
        num2 =  (EditText)findViewById(R.id.num2);
        multiplication = (ImageButton)findViewById(R.id.multiplication);
        addtion = (ImageButton) findViewById(R.id.addtion);
        substraction = (ImageButton) findViewById(R.id.sub);
        output = (TextView)findViewById(R.id.output);



        multiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                numm1  = Double.parseDouble(num1.getText().toString());;
                numm2 = Double.parseDouble((num2.getText().toString()));
              result = numm1 * numm2 ;
              output.setText(Double.toString(result));
            }
        });


        addtion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                numm1  = Double.parseDouble(num1.getText().toString());;
                numm2 = Double.parseDouble((num2.getText().toString()));
                result = numm1 + numm2 ;
                output.setText(Double.toString(result));
            }
        });

        substraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                numm1  = Double.parseDouble(num1.getText().toString());;
                numm2 = Double.parseDouble((num2.getText().toString()));
                result = numm1 - numm2 ;
                output.setText(Double.toString(result));

            }
        });

    }
}
