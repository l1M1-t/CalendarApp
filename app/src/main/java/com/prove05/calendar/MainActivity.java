package com.prove05.calendar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    TextView textView;
    CalendarView calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calendar = (CalendarView)findViewById(R.id.calendar);
        textView = (TextView)findViewById(R.id.textView);

        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(
                    @NonNull CalendarView view, int year, int month, int dayofMonth) {
                String date = month + "-" + dayofMonth + "-" + year;

                textView.setText(date);
            }
        });
    }
    public void dayAction(View view) {
        startActivity(new Intent(this, EventViewActivity.class));
    }
}