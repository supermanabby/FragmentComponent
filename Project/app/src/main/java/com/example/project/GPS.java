package com.example.project;

import android.Manifest;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class GPS extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_g_p_s);

        button = findViewById(R.id.button2);
        ActivityCompat.requestPermissions(GPS.this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},123);

        button.setOnClickListener(new View.OnClickListener() {
           // @RequiresApi(api = Build.VERSION_CODES.P)
            @RequiresApi(api = Build.VERSION_CODES.P)
            @Override
            public void onClick(View v) {
                GPStracker g = new GPStracker(GPS.this);
                Location l = g.getLocation();
                if (l != null){
                    double lat = l.getLatitude();
                    double lon = l.getLongitude();
                    Toast.makeText(GPS.this, "Lattitude: " +lat+ "\n" + "Longitude" +lon,Toast.LENGTH_LONG).show();
                }
            }
        });


    }
}
