package com.example.haruna.freebee3;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.view.View.OnClickListener;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.TimePicker;
import android.app.TimePickerDialog;

import java.util.Calendar;


public class Schedule extends AppCompatActivity {
    private static Button time;
  //  private static TextView set_time;
    private static final int Time_id = 1;

    @Override

        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(new TableMainLayout(this));
        time = (Button) findViewById(R.id.selecttime);

            showAlertDialog();
        }

        public void showAlertDialog (){
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
                alert.setTitle("Daily Start and End Time");
                alert.setMessage("Set the time for when your day starts and ends:");

            // Set click listener for alert dialog buttons
            DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    switch(which){
                        case DialogInterface.BUTTON_POSITIVE:

                            //Calling the time Spinner function
                            onCreateDialog().show();
                            break;

                        case DialogInterface.BUTTON_NEGATIVE:

                            break;
                    }
                }
            };

        alert.setPositiveButton("Select Time", dialogClickListener);
        alert.setNegativeButton("Cancel",dialogClickListener );

        alert.create().show();

    }

        protected Dialog onCreateDialog (){
            // Get the calander
            Calendar c = Calendar.getInstance();

            // From calender get the hour, minute
            int hour = c.get(Calendar.HOUR_OF_DAY);
            int minute = c.get(Calendar.MINUTE);

            return new TimePickerDialog(Schedule.this, time_listener, hour,
                    minute, false);

            // return null;
        }

        // Time picker dialog
        TimePickerDialog.OnTimeSetListener time_listener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hour, int minute) {
                // store the data in one string and set it to text
                String time1 = String.valueOf(hour) + ":" + String.valueOf(minute);
            //    set_time.setText(time1);
            }
        };

    }



