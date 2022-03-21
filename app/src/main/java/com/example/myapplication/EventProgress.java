package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.firestore.FirebaseFirestore;

public class EventProgress extends AppCompatActivity {

    private Button Reached;
    private Button Cancel;
    private TextView Event_name;
    private TextView Event_Location;
    private TextView Event_Zone;
    private TextView Event_Total_slots;
    private TextView Event_Slots_left;
    private EventData eventData;
    private boolean flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_progress);
        flag=true;
        eventData = (EventData)getIntent().getSerializableExtra("EventData");
        Reached = findViewById(R.id.create_reached);
        Cancel = findViewById(R.id.create_cancel);
        Event_name = findViewById(R.id.create_event_name);
        Event_Location = findViewById(R.id.create_location);
        Event_Zone = findViewById(R.id.create_zone);
        Event_Total_slots = findViewById(R.id.create_total_slots);
        Event_Slots_left = findViewById(R.id.create_rest_slots);


        Event_name.setText(eventData.getName());
        Event_Zone.setText(eventData.getZone());
        Event_Location.setText(eventData.getLocation());
        Event_Total_slots.setText(Integer.toString(eventData.getTotal_slots()));
        Event_Slots_left.setText(Integer.toString(eventData.getTotal_slots()));

        start_download();
        Log.d("EventProgress","Working");



    }


    public void start_download(){

        Runnable runnable = new Runnable(){
            public void run() {
                while (flag) {
                    Log.d("Event Thread", "in run");

                    FirebaseFirestore db= FirebaseFirestore.getInstance();
                    Log.d("thread","data = "+db.collection("event").document(eventData.getId()).get());
                    //db.collection("event").document(eventData.getId())
                    //EventList.getInstance().Delete_from_set(id);

                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }
}