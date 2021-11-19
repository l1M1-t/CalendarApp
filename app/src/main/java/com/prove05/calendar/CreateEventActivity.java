package com.prove05.calendar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CreateEventActivity extends AppCompatActivity {

    Button clear;
    Button save;
    EditText title;
    EditText startDate;
    EditText endDate;
    EditText alertDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);

        clear = (Button)findViewById(R.id.buttonClear);
        save = (Button)findViewById(R.id.buttonSave);
        title = (EditText)findViewById(R.id.title);
        startDate = (EditText)findViewById(R.id.startDateText);
        endDate = (EditText)findViewById(R.id.endDateText);
        alertDate = (EditText)findViewById(R.id.alertDateText);

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
                saveNotification(title, startDate, endDate, alertDate);
            }
        });

        //we need to save the event data to the arrayList
        //we need to store the event data to the storage device
    }

    public String saveNotification(EditText title, EditText startDate, EditText endDate, EditText alertDate) {
        return null;
    }

    public void clear() {
        //for unknown reason, the system crashes when the input for title is erased.
        //title.getText().clear();

        startDate.getText().clear();
        endDate.getText().clear();
        alertDate.getText().clear();
    }

}