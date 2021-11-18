package com.prove05.calendar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class EventViewActivity extends AppCompatActivity{

    Button monthView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_view);

        monthView = (Button)findViewById(R.id.monthViewButton);
    }

    public void monthView(View view) {
        startActivity(new Intent(this, MainActivity.class));
    }
}
