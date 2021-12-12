package com.prove05.calendar;

import android.app.Activity;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class CreateEventActivity extends AppCompatActivity {

    Button save;
    DatePicker startDate;
    DatePicker endDate;
    TimePicker startTime;
    TimePicker endTime;
    EditText title;
    EventHolder event;
    int t1Hour;
    int t1Minute;
    int t2Hour;
    int t2Minute;
    Button setTime1;
    ArrayList<EventHolder> events = new ArrayList<EventHolder>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);

        // receiving data from the previous activity
        Intent intent = getIntent();
        events = (ArrayList<EventHolder>)getIntent().getSerializableExtra("EVENTS");

        save = (Button)findViewById(R.id.buttonSave);
        title = (EditText)findViewById(R.id.EventTitle);
        startDate = (DatePicker)findViewById(R.id.datePicker1);
        endDate = (DatePicker)findViewById(R.id.datePicker2);
        startTime = (TimePicker)findViewById(R.id.startTimePicker);
        endTime = (TimePicker)findViewById(R.id.endTimePicker);

/*        startTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timepickerDialog = new TimePickerDialog(
                        CreateEventActivity.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                //Initializing hour and minute
                                t1Hour = hourOfDay;
                                t1Minute = minute;
                                // Initializing calendar
                                Calendar calendar = Calendar.getInstance();
                                // set hour and minute
                                calendar.set(0, 0, 0, t1Hour, t1Minute);
                                // set selected time on textview

                                startTime.setText(DateFormat.format("hh:mm aa", calendar));
                            }
                        }, 12, 0, false
                );
                //Display previous selected time
                timepickerDialog.updateTime(t1Hour, t1Minute);
                //show dialog
                timepickerDialog.show();
            }
        });

        endTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timepickerDialog = new TimePickerDialog(
                        CreateEventActivity.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                //Initializing hour and minute
                                t2Hour = hourOfDay;
                                t2Minute = minute;
                                //Store hour and minute in String
                                String time = t2Hour + ":" + t2Minute;

                                SimpleDateFormat f24Hours = new SimpleDateFormat(
                                        "HH:mm"
                                );
                                try {
                                    Date date = f24Hours.parse(time);
                                    SimpleDateFormat f12Hours = new SimpleDateFormat(
                                            "hh:mm aa"
                                    );

                                    endTime.setText(f12Hours.format(date));
                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }
                            }
                        }, 12, 0, false
                );
                //Display previous selected time
                timepickerDialog.updateTime(t2Hour, t2Minute);
                //show dialog
                timepickerDialog.show();
            }
        });*/

        // save the notification
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                // create String holders after slashes are extracted

                Integer temp1 = startDate.getDayOfMonth();
                Integer temp2 = startDate.getMonth();
                Integer temp3 = startDate.getYear();
                String finalStartDate = (temp1.toString() + temp2.toString() + temp3.toString());
                temp1 = endDate.getDayOfMonth();
                temp2 = endDate.getMonth();
                temp3 = endDate.getYear();
                String finalEndDate = (temp1.toString() + temp2.toString() + temp3.toString());
                String finalStartTime = startTime.toString();
                String finalEndTime = endTime.toString();

                // separate the dates from the slashes '/'
                //finalStartDate = extractSlash(startDate.getText().toString());
                //finalEndDate = extractSlash(endDate.getText().toString());


                System.out.println(title.getText().toString());

                // cast the dates into string to construct a new EventHolder object
                //date = Integer.parseInt(finalStartDate);
                //time = Integer.parseInt(finalEndDate);

                event = new EventHolder(title.getText().toString(), finalStartDate, finalEndDate, finalStartTime, finalEndTime);

                // event added into the arrayList of events

                //saveNotification(title, startDate, endDate, alertDate);


                // list of events object is passed back to the main activity
                Intent resultIntent = new Intent();
                resultIntent.putExtra("EVENT", event);
                setResult(Activity.RESULT_OK, resultIntent);

                finish();
            }
        });
    }
    /*
    public void clear() {
        //for unknown reason, the system crashes when the input for title is erased.
        //title.getText().clear();

        startDate.getText().clear();
        endDate.getText().clear();
        alertDate.getText().clear();
    }
*/
    public void saveEvent() {

    }
}