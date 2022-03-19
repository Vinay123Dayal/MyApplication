package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Form_for_host extends Fragment {
    private String zone;
    Button host_submit;
    TextView slot;
    TextView sport_name;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_form_for_host, container, false);
        final String[] zone = new String[1];
        final String[] location = new String[1];
        slot = v.findViewById(R.id.slots);
        sport_name = v.findViewById(R.id.eventname);
        String[] value = new String[]{"North","East","West","South"};


        Spinner sp = v.findViewById(R.id.zone_spinner);
        sp.setAdapter(new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_item,value));
        HashMap<String, String[]> map = new HashMap<String, String[]>();
        map.put("North", new String[]{"Bonta Park", "North Delhi Municipal Park", "Shalimar Lovers Park", "Kamla Nehru North", "Shubash Park"});
        map.put("South", new String[]{"Deer Park", "Maa Sarada Park", "Qila Rai Pithora Park", "Pancheel Park"});
        map.put("East", new String[]{"Green Belt Park", "Krishna Jayanti Park", "Shiv Park", "The Maharana Pratap Park"});
        map.put("West", new String[]{"Bheemrao Ambedkar Park", "Sanjay Park", "Bindra Park", "Jheel Wala Park"});
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String temp_zone = sp.getSelectedItem().toString();
                zone[0] = temp_zone;
                if(map.containsKey(temp_zone)){

                   // zone = adapterView.getItemAtPosition(i).toString();
                    Spinner sp2 = v.findViewById(R.id.location_spinner);
                    sp2.setAdapter(new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_item,map.get(temp_zone)));
                    location[0] = sp2.getSelectedItem().toString();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        host_submit = v.findViewById(R.id.host_submit);
        host_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String slt = slot.getText().toString();
                String s_name = sport_name.getText().toString();
                System.out.println(slt);
                System.out.println(s_name);
                FirebaseFirestore firebaseFirestore;
                DocumentReference ref;
                firebaseFirestore = FirebaseFirestore.getInstance();
                ref = firebaseFirestore.collection("event").document();
                Map<String, Object> mapper = new HashMap<>();

                mapper.put("Name",s_name );
                mapper.put("zone", zone[0]);
                mapper.put("location", location[0]);
                mapper.put("slots",slt);
                firebaseFirestore.collection("event").add(mapper);
            }
        });

        return v;


    }


}