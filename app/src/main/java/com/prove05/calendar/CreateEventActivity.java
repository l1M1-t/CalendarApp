package com.prove05.calendar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;

public class CreateEventActivity extends AppCompatActivity {

    Button save;
    DatePicker startDate;
    DatePicker endDate;
    TimePicker startTime;
    TimePicker endTime;
    EditText title;
    EventHolder event;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);

        // receiving data from the previous activity
        Intent intent = getIntent();

        save = (Button)findViewById(R.id.buttonSave);
        title = (EditText)findViewById(R.id.EventTitle);
        startDate = (DatePicker)findViewById(R.id.datePicker1);
        endDate = (DatePicker)findViewById(R.id.datePicker2);
        startTime = (TimePicker)findViewById(R.id.startTimePicker);
        endTime = (TimePicker)findViewById(R.id.endTimePicker);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //convert integers into string to store it in to an EventHolder to push it back to the main activity
                Integer temp1 = startDate.getDayOfMonth();
                Integer temp2 = startDate.getMonth() + 1;
                Integer temp3 = startDate.getYear();
                String finalStartDate = (temp2.toString() + "/" + temp1.toString() + "/" + temp3.toString());
                temp1 = endDate.getDayOfMonth();
                temp2 = endDate.getMonth() + 1;
                temp3 = endDate.getYear();
                String finalEndDate = (temp2.toString() + "/" + temp1.toString() + "/" + temp3.toString());
                temp1 = startTime.getHour();
                temp2 = startTime.getMinute();
                String finalStartTime = (temp1.toString() + ":" + temp2.toString());
                temp1 = endTime.getHour();
                temp2 = endTime.getMinute();
                String finalEndTime = (temp1.toString() + ":" + temp2.toString());

                event = new EventHolder(title.getText().toString(), finalStartDate, finalEndDate, finalStartTime, finalEndTime);

                //An event that is created is passed back to the main activity
                Intent resultIntent = new Intent();
                resultIntent.putExtra("EVENT", event);
                setResult(Activity.RESULT_OK, resultIntent);

                finish();
            }
        });
    }
}