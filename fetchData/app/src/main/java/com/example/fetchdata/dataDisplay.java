package com.example.fetchdata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class dataDisplay extends AppCompatActivity {

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_display);


        TextView nameDisplay = findViewById(R.id.displayName);
        TextView emailDisplay = findViewById(R.id.displayEmail);
        Intent intent = getIntent();
        String str = intent.getStringExtra("Name");
        String str2 = intent.getStringExtra("Email");
        nameDisplay.setText(str);
        emailDisplay.setText(str2);
    }
}
