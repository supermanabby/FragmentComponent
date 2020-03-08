package com.example.gridviewcal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    GridView simpleGrid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //logos[0] = (ImageButton)findViewById(R.drawable.plus);
        ArrayList<ImageButton> logos = new ArrayList<ImageButton>();
        ImageButton ig = (ImageButton)findViewById(R.drawable.plus);
        logos.add();
        simpleGrid = (GridView) findViewById(R.id.grid);
      //  CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(), logos);
      //  simpleGrid.setAdapter(customAdapter);

        ArrayAdapter arrayadapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, logos);
        simpleGrid.setAdapter(arrayadapter);




    }
}
