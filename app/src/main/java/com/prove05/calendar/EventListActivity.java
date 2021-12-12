package com.prove05.calendar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class EventListActivity extends AppCompatActivity{

    ListView listView;
    ArrayList list = new ArrayList();
    ArrayList<EventHolder> bufferList = new ArrayList<EventHolder>();
    ArrayAdapter listOfEvents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_list);

        Intent intent = getIntent();
        bufferList = (ArrayList<EventHolder>)getIntent().getSerializableExtra("EVENTS");

        listView = (ListView)findViewById(R.id.list);

        //display events to the listView

        for (int i = 0; i < bufferList.size(); i++) {
            list.add(bufferList.get(i).getTitle());
        }

        listOfEvents = new ArrayAdapter(EventListActivity.this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(listOfEvents);

        System.out.print("Start Time: " + bufferList.get(0).getStartTime());

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(EventListActivity.this,
                        "Date: " + bufferList.get(position).getStartDate() + " ~ " + bufferList.get(position).getEndDate() + "\n"
                                + "Time: " + bufferList.get(position).getStartTime() + " ~ " + bufferList.get(position).getEndTime(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
