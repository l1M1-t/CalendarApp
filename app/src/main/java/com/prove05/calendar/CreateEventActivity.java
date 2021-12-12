package com.prove05.calendar;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.ArrayList;

public class CreateEventActivity extends AppCompatActivity {

    Button clear;
    Button save;
    DatePicker startDate;
    EditText title;
    //EditText startDate;
    ///EditText endDate;
    //EditText alertDate;
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
        //year = intent.getStringExtra("YEAR");
        //month = intent.getStringExtra("MONTH");
        //dayOfMonth = intent.getStringExtra("DAYOFMONTH");


        clear = (Button)findViewById(R.id.buttonClear);
        save = (Button)findViewById(R.id.buttonSave);
        title = (EditText)findViewById(R.id.EventTitle);
        startDate = (DatePicker)findViewById(R.id.datePicker1);
        //startDate = (EditText)findViewById(R.id.startDateText);
        //endDate = (EditText)findViewById(R.id.endDateText);
        //alertDate = (EditText)findViewById(R.id.alertDateText);

        // setting start date as the date that was selected by the user
        //startDate.setText(month + "/" + dayOfMonth + "/" + year);
        //endDate.setText(month + "/" + dayOfMonth + "/" + year);

        // clear all of user's input
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //clear();
            }
        });

        // save the notification
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                // create String holders after slashes are extracted

                Integer temp1 = startDate.getDayOfMonth();
                Integer temp2 = startDate.getMonth();
                Integer temp3 = startDate.getYear();
                Integer finalStartDate = Integer.parseInt(temp1.toString()+ temp2.toString()+ temp3.toString());
                Integer finalEndDate = 0;
                Integer finalStartTime = 0;
                Integer finalEndTime = 0;

                // separate the dates from the slashes '/'
                //finalStartDate = extractSlash(startDate.getText().toString());
                //finalEndDate = extractSlash(endDate.getText().toString());


                System.out.println(title.getText().toString());

                // cast the dates into string to construct a new EventHolder object
                //date = Integer.parseInt(finalStartDate);
                //time = Integer.parseInt(finalEndDate);



                event = new EventHolder(title.getText().toString(), finalStartDate, finalEndDate, finalStartTime, finalEndTime);

                // event added into the arrayList of events

                //saveNotification(title, startDate, endDate, alertDate);


                // list of events object is passed back to the main activity
                Intent resultIntent = new Intent();
                resultIntent.putExtra("EVENT", event);
                setResult(Activity.RESULT_OK, resultIntent);

                finish();
            }
        });
    }
    /*
    public void clear() {
        //for unknown reason, the system crashes when the input for title is erased.
        //title.getText().clear();

        startDate.getText().clear();
        endDate.getText().clear();
        alertDate.getText().clear();
    }
*/
    public void saveEvent() {

    }

    public String saveNotification(EditText title, EditText startDate, EditText endDate, EditText alertDate) {
        return null;
    }

    public String extractSlash(String date) {
        String buffer = date;
        String finalDate = null;

        return finalDate;
    };
}