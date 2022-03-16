package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button login;
    Button sign_up;
    @Override


    protected void onCreate(Bundle savedInstanceState) {
        Log.d("login_page", "Open");
        super.onCreate(savedInstanceState);
        fun();
        setContentView(R.layout.activity_main);

        login = findViewById(R.id.login);
        sign_up = findViewById(R.id.signup);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // check if username and password available and correct.
                Intent intent = new Intent(getApplicationContext(), MainScreen.class);
                startActivity(intent);
            }
        });

        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), RegisterName.class);
                startActivity(intent);
            }
        });

    }



    public  void fun(){
        EventList.getInstance().add_data(new EventData("Cricket","Delhi",10));
        EventList.getInstance().add_data(new EventData("KhoKho","Mumbai",10));
        EventList.getInstance().add_data(new EventData("Chess","Kolkata",10));
        EventList.getInstance().add_data(new EventData("Football","Bangalore",10));
        EventList.getInstance().add_data(new EventData("BasketBall","China",10));
        EventList.getInstance().add_data(new EventData("Baseball","Russia",10));
        EventList.getInstance().add_data(new EventData("Pool","USA",10));


    }


}