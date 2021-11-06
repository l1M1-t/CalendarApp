package com.prove05.calendar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class EventViewActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_view);
    }

    public void monthAction(View view) {
        startActivity(new Intent(this, MainActivity.class));
    }

    public void createEvent(View view) {

    }
}
