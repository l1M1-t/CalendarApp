package com.prove05.calendar;

import android.app.Activity;
import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;

import com.prove05.calendar.EventHolder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class StoreEvents implements  Runnable{

    private ArrayList<EventHolder> listOfEvents;
    static private WeakReference<AppCompatActivity> activityRef;



    public StoreEvents(AppCompatActivity activity, ArrayList<EventHolder> newEvents) {
        listOfEvents = newEvents;
        this.activityRef = new WeakReference<AppCompatActivity>(activity);
    }

    public static ArrayList<EventHolder> readEventsFromFile(String fileName) throws FileNotFoundException {

        final Activity activity = activityRef.get();

        File file = new File(activity.getApplicationContext().getFilesDir(),fileName);
        Scanner s = new Scanner(file);

        ArrayList<EventHolder> eventHolderList = new ArrayList<EventHolder>();

        while(s.hasNextLine()){
            String line = s.nextLine();
            String[] items = line.split("\\|");

            String title = items[0];
            int date = Integer.parseInt(items[1]);
            int time = Integer.parseInt(items[2]);

            //EventHolder newEventHolder = new EventHolder(title, date, time, );
            //eventHolderList.add(newEventHolder);

        }
        return eventHolderList;

    }
    public static void listToFile(ArrayList<EventHolder> eventHolderList){
 /*
        for(Iterator it = eventHolderList.iterator(); it.hasNext();){
            EventHolder currentEventHolder = (EventHolder) it.next();
            String outputText = currentEventHolder.getTitle() + "|" + currentEventHolder.getDate() + "|" + currentEventHolder.getTime();
        }

*/
    }



    public static void saveToFileString(String fileName, String text, boolean append) throws IOException {
        File file = new File(fileName);
    }

    @Override
    public void run() {

    }

}
