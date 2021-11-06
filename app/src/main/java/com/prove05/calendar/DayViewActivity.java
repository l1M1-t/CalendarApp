package com.prove05.calendar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DayViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_view);
    }

    public void monthAction(View view) {
        startActivity(new Intent(this, MainActivity.class));
    }

    public void createEvent(View view) {

    }
}