package com.prove05.calendar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;
import android.view.View;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

public class MainActivity extends AppCompatActivity {

    CalendarView calendar;
    TextView textView;
    Button createEventButton;
    Button eventListButton;
    String y;
    String m;
    String dom;
    static ArrayList<EventHolder> events;

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

        readFile();


        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(
                    @NonNull CalendarView view, int year, int month, int dayofMonth) {
                y = String.valueOf(year);
                m = String.valueOf(month + 1);
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
                    EventHolder ev = (EventHolder)data.getSerializableExtra("EVENT");
                    events.add(ev);
                    Toast.makeText(MainActivity.this, "Created event: " + events.get(events.size() - 1).getTitle(), Toast.LENGTH_SHORT).show();
                }
                if (resultCode == RESULT_CANCELED) {
                    //Toast.makeText(MainActivity.this, "Extracting data failed!", Toast.LENGTH_SHORT).show();
                }
            }
        } catch (Exception ex) {
            Toast.makeText(MainActivity.this, ex.toString(), Toast.LENGTH_SHORT).show();
        }
    }

    public void readFile(){
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = openFileInput("savedData.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);


            String lines;
            while((lines = bufferedReader.readLine()) != null){
                String[] items = lines.split("\\|");

                String title = items[0];
                String  startDate = items[1];
                String endDate = items[2];
                String startTime = items[3];
                String endTime = items[4];
                EventHolder newEventHolder = new EventHolder(title, startDate, endDate, startTime, endTime );
                events.add(newEventHolder);
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String listToFile(ArrayList<EventHolder> eventHolderList){

        String outputText = new String();
        for(Iterator it = eventHolderList.iterator(); it.hasNext();){
            EventHolder currentEventHolder = (EventHolder) it.next();
            outputText += currentEventHolder.getTitle() + "|" + currentEventHolder.getStartDate() + "|" + currentEventHolder.getEndDate() +  "|" + currentEventHolder.getStartTime() + "|" + currentEventHolder.getEndTime() + "\n";
        }
        System.out.println(outputText);
        return outputText;


    }

    public void saveFile(String input){


        listToFile(events);
        try{
            FileOutputStream fileOutputStream = openFileOutput("savedData.txt", MODE_PRIVATE);
            fileOutputStream.write(input.getBytes());
            fileOutputStream.close();

            Toast.makeText(getApplicationContext(), "Saved!", Toast.LENGTH_SHORT).show();



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        saveFile(listToFile(events));

    }
}

