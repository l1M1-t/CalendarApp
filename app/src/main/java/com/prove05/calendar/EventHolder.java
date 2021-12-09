package com.prove05.calendar;

import java.io.Serializable;

public class EventHolder implements Serializable {


    private String title;
    private int date;
    private int time;

    public EventHolder(String title, int date, int time) {
        this.title = title;
        this.date = date;
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }


}
