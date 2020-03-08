package com.example.list;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class fetching extends AppCompatActivity  {


    String[] data = new String[]{"abhay"};
    String value;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fetching);

        button = (Button) (findViewById(R.id.button2));
        // EditText et = (EditText) findViewById(R.id.editText);


        final EditText editText = (EditText) findViewById(R.id.editText);
       // value = ;
       // editText.setText(value);
        final List<String> newArrayLists = new ArrayList<String>(Arrays.asList(data));
        //Toast.makeText(this, value, Toast.LENGTH_SHORT).show();
        ArrayAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.activity_list_item, android.R.id.text1,newArrayLists);
        ListView lv = (ListView) findViewById(R.id.listt);
        lv.setAdapter(adapter);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newArrayLists.add(editText.getText().toString());
            }
        });

}
}





