package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;


public class DetailsFragment extends Fragment {
    private TextView Name;
    private TextView Location;
    private TextView Total_slots;
    private EventData Data;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_details, container, false);


        Bundle bundle = getArguments();
        Data = (EventData) bundle.getSerializable("newsdata");

        Name = view.findViewById(R.id.fragment_name);
        Location = view.findViewById(R.id.fragment_location);
        Total_slots = view.findViewById(R.id.fragment_total_slots);

        Name.setText(Data.getName());
        Location.setText(Data.getLocation());
        Total_slots.setText(Integer.toString(Data.getTotal_slots()));
        return view;
    }
}