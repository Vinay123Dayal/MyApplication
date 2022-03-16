package com.example.myapplication;

import java.util.ArrayList;

public class EventList {

    private static EventList newslist=null;

    private ArrayList<EventData> NewsArrayList;
    private EventList(){
        NewsArrayList = new ArrayList<>();
    }

    public void add_data(EventData nd){
        NewsArrayList.add(nd);
    }

    public EventData get_data(int pos){
        return NewsArrayList.get(pos);
    }

    public int get_list_size(){
        return NewsArrayList.size();
    }

    public ArrayList<EventData> get_list(){
        return NewsArrayList;
    }


    public static EventList getInstance(){
        if(newslist==null){
            newslist = new EventList();
        }
        return newslist;
    }


}


