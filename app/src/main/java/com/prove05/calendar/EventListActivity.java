package com.prove05.calendar;

import android.content.Intent;
import android.os.Bundle;
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
    List list = new ArrayList();
    ArrayAdapter listOfEvents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_list);

        monthView = (Button)findViewById(R.id.monthViewButton);
        listView = (ListView)findViewById(R.id.list);

        // Testing 1
        list.add("Orange");
        list.add("Apple");
        list.add("Pear");
        list.add("Grapes");
        list.add("Watermelon");
        list.add("Pineapple");
        list.add("Strawberries");
        list.add("Blueberries");
        list.add("Melon");
        list.add("Cantaloupe");
        list.add("Lemon");
        list.add("Lime");
        list.add("Tomato");
        list.add("Banana");
        list.add("Mango");

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
        startActivity(new Intent(this, MainActivity.class));
    }
}
