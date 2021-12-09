package com.prove05.calendar;

import android.content.Context;

import com.prove05.calendar.EventHolder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class StoreEvents {

    public static ArrayList<EventHolder> readEventsFromFile(String fileName, Context context) throws FileNotFoundException {
        File file = new File(context.getFilesDir(),fileName);
        Scanner s = new Scanner(file);

        ArrayList<EventHolder> eventHolderList = new ArrayList<EventHolder>();

        while(s.hasNextLine()){
            String line = s.nextLine();
            String[] items = line.split("|");

            String title = items[0];
            int date = Integer.parseInt(items[1]);
            int time = Integer.parseInt(items[2]);

            EventHolder newEventHolder = new EventHolder(title, date, time);
            eventHolderList.add(newEventHolder);

        }
        return eventHolderList;

    }
    public static void listToFile(ArrayList<EventHolder> eventHolderList){

        for(Iterator it = eventHolderList.iterator(); it.hasNext();){
            EventHolder currentEventHolder = (EventHolder) it.next();
            String outputText = currentEventHolder.getTitle() + "|" + currentEventHolder.getDate() + "|" + currentEventHolder.getTime();
        }


    }



    public static void saveToFileString(String fileName, String text, boolean append) throws IOException {
        File file = new File(fileName);
    }




}
