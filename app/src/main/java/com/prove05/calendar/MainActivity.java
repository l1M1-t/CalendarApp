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
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    CalendarView calendar;
    TextView textView;
    Button createEventButton;
    Button eventListButton;
    String y;
    String m;
    String dom;
    StoreEvents storage;
    ArrayList<EventHolder> events;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("OrganizeMe");

        calendar = (CalendarView)findViewById(R.id.calendar);
        textView = (TextView)findViewById(R.id.textView);
        createEventButton = (Button)findViewById(R.id.createEventButton);
        eventListButton = (Button)findViewById(R.id.eventListViewButton);
        events = new ArrayList<EventHolder>();

        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(
                    @NonNull CalendarView view, int year, int month, int dayofMonth) {
                y = String.valueOf(year);
                m = String.valueOf(month);
                dom = String.valueOf(dayofMonth);
            }
        });

        createEventButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createEventAction(v);
            }
        });

        eventListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eventListAction(v);
            }
        });
    }

    public void eventListAction(View view) {
        Intent intent = new Intent(MainActivity.this, EventListActivity.class);

        //pass the events data to the next activity
        intent.putExtra("EVENTS", events);

        startActivity(intent);
    }

    public void createEventAction(View view) {
        Intent intent = new Intent(MainActivity.this, CreateEventActivity.class);

        //pass the date data to the next activity
        intent.putExtra("YEAR", y);
        intent.putExtra("MONTH", m);
        intent.putExtra("DAYOFMONTH", dom);
        intent.putExtra("EVENTS", events);

        super.startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        try {
            super.onActivityResult(requestCode, resultCode, data);
            if (requestCode == 1) {

                System.out.println(resultCode);

                if (resultCode == RESULT_OK) {
                    events = (ArrayList<EventHolder>)data.getSerializableExtra("EVENTS");
                    Toast.makeText(MainActivity.this, events.get(0).getTitle(), Toast.LENGTH_SHORT).show();
                }
                if (resultCode == RESULT_CANCELED) {
                    Toast.makeText(MainActivity.this, "Extracting data failed!", Toast.LENGTH_SHORT).show();
                }
            }
        } catch (Exception ex) {
            Toast.makeText(MainActivity.this, ex.toString(), Toast.LENGTH_SHORT).show();
        }
    }
}