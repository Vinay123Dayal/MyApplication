package com.example.myapplication;

import java.io.Serializable;

public class EventData implements Serializable {
    private String Name;
   private String Location;
   private int Total_slots;
    private String Zone;
    private int index;

    public String getZone() {
        return Zone;
    }

    public void setZone(String zone) {
        Zone = zone;
    }



    public EventData(String Name, String Location, String Zone,int Total_slots,int index){
        this.Location =Location;
        this.Name = Name;
        this.Total_slots = Total_slots;
        this.Zone = Zone;
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
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
