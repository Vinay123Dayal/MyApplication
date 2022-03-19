package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;


public class RegisterName extends AppCompatActivity {
    Button sub;


    private EditText name;
    private EditText id;
    private EditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_name);
        sub = findViewById(R.id.submit);
        name = findViewById(R.id.name);
        id = findViewById(R.id.user_id);
        password = findViewById(R.id.user_password);
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseFirestore firebaseFirestore;
                DocumentReference ref;
                firebaseFirestore = FirebaseFirestore.getInstance();

                ref = firebaseFirestore.collection("user").document();
                Map<String, Object> mapper = new HashMap<>();

                mapper.put("Name", name.getText().toString());
                mapper.put("id", id.getText().toString());
                mapper.put("password", password.getText().toString());
                firebaseFirestore.collection("user").add(mapper);
            }
        });
    }
}