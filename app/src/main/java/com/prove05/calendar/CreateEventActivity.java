package com.prove05.calendar;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class CreateEventActivity extends AppCompatActivity {

    Button clear;
    Button save;
    EditText title;
    EditText startDate;
    EditText endDate;
    EditText alertDate;
    EventHolder event;
    String year;
    String month;
    String dayOfMonth;
    ArrayList<EventHolder> events = new ArrayList<EventHolder>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);

        // receiving data from the previous activity
        Intent intent = getIntent();
        events = (ArrayList<EventHolder>)getIntent().getSerializableExtra("EVENTS");
        year = intent.getStringExtra("YEAR");
        month = intent.getStringExtra("MONTH");
        dayOfMonth = intent.getStringExtra("DAYOFMONTH");


        clear = (Button)findViewById(R.id.buttonClear);
        save = (Button)findViewById(R.id.buttonSave);
        title = (EditText)findViewById(R.id.title);
        startDate = (EditText)findViewById(R.id.startDateText);
        endDate = (EditText)findViewById(R.id.endDateText);
        alertDate = (EditText)findViewById(R.id.alertDateText);

        // setting start date as the date that was selected by the user
        startDate.setText(month + "/" + dayOfMonth + "/" + year);
        endDate.setText(month + "/" + dayOfMonth + "/" + year);

        // clear all of user's input
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clear();
            }
        });

        // save the notification
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //date and time holders after casting
                int date;
                int time;

                // create String holders after slashes are extracted
                String finalStartDate;
                String finalEndDate;

                // separate the dates from the slashes '/'
                finalStartDate = extractSlash(startDate.getText().toString());
                finalEndDate = extractSlash(endDate.getText().toString());

                System.out.println(finalStartDate);
                System.out.println(finalEndDate);

                // cast the dates into string to construct a new EventHolder object
                date = Integer.parseInt(finalStartDate);
                time = Integer.parseInt(finalEndDate);

                event = new EventHolder(title.getText().toString(), date, time);

                // event added into the arrayList of events
                events.add(event);
                saveNotification(title, startDate, endDate, alertDate);

                // list of events object is passed back to the main activity
                Intent resultIntent = new Intent();
                resultIntent.putExtra("EVENTS", events);
                setResult(Activity.RESULT_OK, resultIntent);

                finish();
            }
        });
    }

    public void clear() {
        //for unknown reason, the system crashes when the input for title is erased.
        //title.getText().clear();

        startDate.getText().clear();
        endDate.getText().clear();
        alertDate.getText().clear();
    }

    public void saveEvent() {

    }

    public String saveNotification(EditText title, EditText startDate, EditText endDate, EditText alertDate) {
        return null;
    }

    public String extractSlash(String date) {
        String buffer = date;
        String finalDate = null;
/*
        System.out.println("date: " + buffer);

        buffer.

        System.out.println("After: date: " + buffer);

//        for (int i = 0; i < buffer.length(); i++) {
//            if (i < 2 && buffer. != "/") {
//                month += buffer.substring(i);
//            }
//            else if (i >= 3 && i < 5 && buffer.substring(i) != "/") {
//                dayOfMonth += buffer.substring(i);
//            }
//            else if (i >= 6 && i < 8) {
//                year += buffer.substring(i);
//            }
//        }
//        finalDate = month + dayOfMonth + year;
 */
        return finalDate;
    };
}