package com.example.tester;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;



import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;


import android.widget.Button;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.time.Duration;


public class MainActivity extends AppCompatActivity {


    Calendar firstTimestamp = Calendar.getInstance();
    Calendar secondTimestamp = Calendar.getInstance();
    SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");

    // Define a button and add an OnClickListener to it
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Define a button and add an OnClickListener to it
        Button button = findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (firstTimestamp == null) {
                    // If the firstTimestamp has not been set, set it to the current time
                    firstTimestamp = Calendar.getInstance();
                    // Format the timestamp as a string in the "HH:mm:ss" format
                    String timestampString = timeFormat.format(firstTimestamp.getTime());

                } else {

                    String timestampString = timeFormat.format(firstTimestamp.getTime());

                    // Set the secondTimestamp to the current time
                    secondTimestamp = Calendar.getInstance();
                    String secondTimestampString = timeFormat.format(secondTimestamp.getTimeInMillis());


                    // Calculate the difference between the two timestamps in milliseconds

                    int hourDifference = secondTimestamp.get(Calendar.HOUR_OF_DAY) - firstTimestamp.get(Calendar.HOUR_OF_DAY);
                    int minuteDifference = secondTimestamp.get(Calendar.MINUTE) - firstTimestamp.get(Calendar.MINUTE);
                    int secondDifference = secondTimestamp.get(Calendar.SECOND) - firstTimestamp.get(Calendar.SECOND);


                    long timeDifference = secondTimestamp.getTimeInMillis() - firstTimestamp.getTimeInMillis();
                    // Format the time difference as a string in the "HH:mm:ss" format
                    String timeDifferenceString = String.format("%02d:%02d:%02d", hourDifference, minuteDifference, secondDifference);



                    Log.d("Time Difference", "Time difference: " + timeDifferenceString);
                    Toast.makeText(MainActivity.this, "Start Time: " + timestampString, Toast.LENGTH_SHORT).show();
                    Toast.makeText(MainActivity.this, "End Time" + secondTimestampString, Toast.LENGTH_SHORT).show();
                    Toast.makeText(MainActivity.this, "Total Time" + timeDifferenceString, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}