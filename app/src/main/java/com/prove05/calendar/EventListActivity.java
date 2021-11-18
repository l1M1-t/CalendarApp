package com.prove05.calendar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class EventListActivity extends AppCompatActivity{

    Button monthView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_list);

        monthView = (Button)findViewById(R.id.monthViewButton);

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
