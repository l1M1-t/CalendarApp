package com.prove05.calendar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    CalendarView calendar;
    TextView textView;
    Button createEvent;
    Button eventList;
    String date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calendar = (CalendarView)findViewById(R.id.calendar);
        textView = (TextView)findViewById(R.id.textView);
        createEvent = (Button)findViewById(R.id.createEventButton);
        eventList = (Button)findViewById(R.id.eventListViewButton);

        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(
                    @NonNull CalendarView view, int year, int month, int dayofMonth) {
                date = month + "-" + dayofMonth + "-" + year;
            }
        });

        createEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createEventAction(v);
            }
        });

        eventList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eventListAction(v);
            }
        });
    }

    public void eventListAction(View view) {
        Intent intent = new Intent(MainActivity.this, EventViewActivity.class);

        startActivity(intent);
    }

    public void createEventAction(View view) {
        Intent intent = new Intent(MainActivity.this, CreateEventActivity.class);

        //pass the date data to the next activity
        intent.putExtra("DATE", date);

        startActivity(intent);
    }
}