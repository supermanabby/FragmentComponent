package com.example.project;

import android.app.DatePickerDialog.OnDateSetListener;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import com.example.project.R.id;
import com.example.project.R.layout;
import com.google.firebase.auth.FirebaseUser;

import java.text.DateFormat;
import java.util.Calendar;

import static java.util.Calendar.DAY_OF_MONTH;
import static java.util.Calendar.MONTH;
import static java.util.Calendar.getInstance;

public class afterLogin extends AppCompatActivity implements OnDateSetListener {


    TextView username ;
    TextView timeView;
    Button signout;
    FirebaseUser firebaseUser;
    Button datePicker;
    Button timePicker;
    TextView heading,heading2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_after_login);
        //username =findViewById(R.id.forEmail);
        datePicker = findViewById(id.pick_a_date);
        timeView = findViewById(id.time);
        signout = findViewById(id.signOut);
        timePicker = findViewById(id.pick_a_time);
        heading = findViewById(id.heading);
        heading2 = findViewById(id.heading2);

     //   firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
     //   String user = firebaseUser.getEmail();
        //   username.setText(user);

     /*   signout.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                //     startActivity(new Intent(afterLogin.this,login.class));
            }
        }); */

            heading.setVisibility(View.INVISIBLE);
            heading2.setVisibility(View.INVISIBLE);

        datePicker.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment datepicker = new DatePickerFragment();
                datepicker.show(getSupportFragmentManager(), "date picker");

            }
        });

        timePicker.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                final int mHour = c.get(Calendar.HOUR_OF_DAY);
                int mMinute = c.get(Calendar.MINUTE);
                TimePickerDialog timePickerDialog = new TimePickerDialog(afterLogin.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        timeView.setText(mHour + ":" + minute);
                    }
                },mHour,mMinute,true);
                timePickerDialog.show();
            }
        });
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar c = getInstance();
        c.set(Calendar.YEAR,year);
        c.set(MONTH,month);
        c.set(DAY_OF_MONTH,dayOfMonth);
        String currentDateString = DateFormat.getDateInstance().format(c.getTime());
        TextView textView = (TextView) findViewById(R.id.date);
        textView.setText(currentDateString);
        if (textView != null){

        }

    }
}
