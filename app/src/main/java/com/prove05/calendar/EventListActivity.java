package com.prove05.calendar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class EventListActivity extends AppCompatActivity{

    Button monthView;
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

        monthView = (Button)findViewById(R.id.monthViewButton);
        listView = (ListView)findViewById(R.id.list);

        //display events to the listView

        for (int i = 0; i < bufferList.size(); i++) {
            list.add(bufferList.get(i).getTitle());
        }

        listOfEvents = new ArrayAdapter(EventListActivity.this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(listOfEvents);

        monthView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                monthView(v);
            }
        });
    }

    public void monthView(View view) {
        Intent intent = new Intent(this, MainActivity.class);

        intent.putExtra("EVENTS", list);

        startActivity(intent);
    }
}
