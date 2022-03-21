package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class Participant_progress extends AppCompatActivity {

    private boolean flag;
    private String event_id;

    private TextView Name;
    private TextView Location;
    private TextView Total_slots;
    private TextView Slots_left;
    private TextView Zone;
    private Button Cancel;
    private String

    private String id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.participant_progress);

        event_id = getIntent().getStringExtra("event_id");
        Name = findViewById(R.id.search_event_name);
        Location = findViewById(R.id.search_location);
        Total_slots = findViewById(R.id.search_total_slots);
        Zone = findViewById(R.id.search_zone);
        Cancel = findViewById(R.id.search_cancel);
        Slots_left = findViewById(R.id.search_rest_slots);

        start_download();

    }


    public void show_data(){
        FirebaseFirestore db= FirebaseFirestore.getInstance();

        DocumentReference docRef = db.collection("event").document(event_id);
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        Log.d("fetch data", "Name = " + document.getData().get("Name"));
                        Log.d("fetch data", "location = " + document.getData().get("location"));
                        Log.d("fetch data", "slots = " + document.getData().get("slots"));
                        Log.d("fetch data", "zone = " + document.getData().get("zone"));

                        Name.setText(document.getData().get("Name").toString());
                        Location.setText(document.getData().get("location").toString());
                        Zone.setText(document.getData().get("zone").toString());
                        Total_slots.setText(document.getData().get("slots").toString());


                        Location = findViewById(R.id.search_location);
                        Total_slots = findViewById(R.id.search_total_slots);
                        Zone = findViewById(R.id.search_zone);
                        Cancel = findViewById(R.id.search_cancel);
                        Slots_left = findViewById(R.id.search_rest_slots);




                    } else {
                        Log.d("fetch data", "No such document");
                    }
                } else {
                    Log.d("fetch data", "get failed with ", task.getException());
                }
            }
        });
    }

    public void start_download(){
        flag=true;
        Runnable runnable = new Runnable(){
            public void run() {
                while (flag) {
                    Log.d("Download Thread", "in run");
                    fetch_data();

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

    public void fetch_data() {

        FirebaseFirestore db= FirebaseFirestore.getInstance();

        DocumentReference docRef = db.collection("event").document(event_id);
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        Log.d("fetch data", "Name = " + document.getData().get("Name"));
                        Log.d("fetch data", "location = " + document.getData().get("location"));
                        Log.d("fetch data", "slots = " + document.getData().get("slots"));
                        Log.d("fetch data", "zone = " + document.getData().get("zone"));

                        Name.setText(document.getData().get("Name").toString());
                        Location.setText(document.getData().get("location").toString());
                        Slots_left.setText(document.getData().get("slots").toString());
                        Zone.setText(document.getData().get("zone").toString());
                        Total_slots.setText(document.getData().get("location").toString());


                        Location = findViewById(R.id.search_location);
                        Total_slots = findViewById(R.id.search_total_slots);
                        Zone = findViewById(R.id.search_zone);
                        Cancel = findViewById(R.id.search_cancel);
                        Slots_left = findViewById(R.id.search_rest_slots);




                    } else {
                        Log.d("fetch data", "No such document");
                    }
                } else {
                    Log.d("fetch data", "get failed with ", task.getException());
                }
            }
        });

    }





}