package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterName extends AppCompatActivity {

    private Button sub;
    private EditText name;
    private EditText id;
    private EditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_name);
        sub = findViewById(R.id.submit_button);
        name = findViewById(R.id.user_name);
        id = findViewById(R.id.user_email);
        password = findViewById(R.id.user_password);
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("register","onclick");
                DatabaseReference node = FirebaseDatabase.getInstance().getReference().child("User");
                Log.d("REgister","User");
                User u = new User(id.getText().toString(), name.getText().toString(), password.getText().toString());
                node.push().setValue(u);

                Log.d("register","end");
            }
        });
    }
}