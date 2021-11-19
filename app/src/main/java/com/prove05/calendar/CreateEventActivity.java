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
    EditText startDate;
    EditText endDate;
    EditText alertDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);

        clear = (Button)findViewById(R.id.buttonClear);
        save = (Button)findViewById(R.id.buttonSave);
        startDate = (EditText)findViewById(R.id.startDateText);
        endDate = (EditText)findViewById(R.id.endDateText);
        alertDate = (EditText)findViewById(R.id.alertDateText);

        
    }

    public String saveNotification(EditText startDate, EditText endDate, EditText alertDate) {
        return null;
    }

    public void clear() {
        startDate.setText("");
        endDate.setText("");
        alertDate.setText("");
        startDate.clearComposingText();
    }

}