package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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

                Log.d("book","enter");

                Log.d("book"," enter "+User.getInstance().getEvent_id());

                if(User.getInstance().getEvent_id().equals("none")){
                    Log.d("book","inside");

                    int total_slots = Integer.parseInt(Total_slots.getText().toString())-1;

                    if(total_slots>=0){
                        Total_slots.setText(Integer.toString(total_slots));
                        Map<String, Object> mapper = new HashMap<>();
                        mapper.put("slots", Integer.toString(total_slots));
                        FirebaseFirestore db= FirebaseFirestore.getInstance();
                        db.collection("event").document(id).update(mapper);

                        User.getInstance().setEvent_id(id);
                        Map<String, Object> mapper1 = new HashMap<>();
                        mapper1.put("event_id", id);
                        FirebaseFirestore db1= FirebaseFirestore.getInstance();
                        db.collection("user").document(User.getInstance().getUser_id()).update(mapper);
                        Intent intent = new Intent(getActivity(), Participant_progress.class);
                        intent.putExtra("event_id",id);
                        startActivity(intent);
                    }else{
                        Toast.makeText(getActivity(),"No slots left for the event",Toast.LENGTH_SHORT).show();
                    }

                }else{
                    Toast.makeText(getActivity(),"You have already Booked a slot",Toast.LENGTH_SHORT).show();
                }
            }
        });


        return view;
    }
}