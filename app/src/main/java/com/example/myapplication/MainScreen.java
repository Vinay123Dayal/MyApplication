package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainScreen extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("MainScreen","Open");
        setContentView(R.layout.activity_main_screen);
        getSupportFragmentManager().beginTransaction().add(R.id.fragment,new SearchCreateFragment()).commit();

    }
}