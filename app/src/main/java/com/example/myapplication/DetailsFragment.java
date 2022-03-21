package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;


public class DetailsFragment extends Fragment {
    private TextView Name;
    private TextView Location;
    private TextView Total_slots;
    private EventData Data;
    private Button Book_slots;
    private TextView Zone;
    private String id;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_details, container, false);


        Bundle bundle = getArguments();
        Data = (EventData) bundle.getSerializable("newsdata");

        Name = view.findViewById(R.id.fragment_name);
        Location = view.findViewById(R.id.fragment_location);
        Total_slots = view.findViewById(R.id.fragment_total_slots);
        Zone = view.findViewById(R.id.fragment_zone);
        Book_slots = view.findViewById(R.id.fragment_button);


        Name.setText(Data.getName());
        Location.setText(Data.getLocation());
        Total_slots.setText(Integer.toString(Data.getTotal_slots()));
        Zone.setText(Data.getZone());
        id = Data.getId();


        Book_slots.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int total_slots = Integer.parseInt(Total_slots.getText().toString())-1;
                Total_slots.setText(Integer.toString(total_slots));
                Map<String, Object> mapper = new HashMap<>();
                mapper.put("slots", Integer.toString(total_slots));
                FirebaseFirestore db= FirebaseFirestore.getInstance();
                db.collection("event").document(id).update(mapper);
                EventList.getInstance().Delete_from_set(id);


            }
        });


        return view;
    }
}