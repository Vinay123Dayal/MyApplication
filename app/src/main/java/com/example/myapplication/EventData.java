package com.example.myapplication;

import android.graphics.Bitmap;

import java.io.Serializable;

public class EventData implements Serializable {
    private String Name;
   private String Location;
   private int Total_slots;

    public EventData(String Name,String Location, int Total_slots){
        this.Location =Location;
        this.Name = Name;
        this.Total_slots = Total_slots;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public int getTotal_slots() {
        return Total_slots;
    }

    public void setTotal_slots(int total_slots) {
        Total_slots = total_slots;
    }
}
