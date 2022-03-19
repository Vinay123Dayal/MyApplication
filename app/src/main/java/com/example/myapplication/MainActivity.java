package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

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


        FirebaseFirestore db= FirebaseFirestore.getInstance();
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("IN");
                db.collection("user").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {

                @Override
                public void onComplete(@NonNull Task<QuerySnapshot> task) {

                    if (task.isSuccessful()) {
                        System.out.println("out");
                        System.out.println(task.getResult().isEmpty());
                        for (QueryDocumentSnapshot document : task.getResult()) {
                            System.out.println(document.getData());
                            Log.d("data",document.getId() + " => " + document.getData());
                        }
                        Intent intent = new Intent(getApplicationContext(), MainScreen.class);
                        startActivity(intent);
                    } else {
                        System.out.println("out2");
                        Log.d("data", "Error getting documents: ", task.getException());
                    }
                }
                });
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

//        FirebaseFirestore db= FirebaseFirestore.getInstance();
//
//        db.collection("user").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
//
//                    @Override
//                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
//
//                        if (task.isSuccessful()) {
//                            System.out.println("out");
//                            System.out.println(task.getResult().isEmpty());
//                            for (QueryDocumentSnapshot document : task.getResult()) {
//                                System.out.println(document.getData());
//                                Log.d("data",document.getId() + " => " + document.getData());
//                            }
//                            Intent intent = new Intent(getApplicationContext(), MainScreen.class);
//                            startActivity(intent);
//                        } else {
//                            System.out.println("out2");
//                            Log.d("data", "Error getting documents: ", task.getException());
//                        }
//                    }
//                });


        EventList.getInstance().add_data(new EventData("Cricket","Delhi",10));
        EventList.getInstance().add_data(new EventData("KhoKho","Mumbai",10));
        EventList.getInstance().add_data(new EventData("Chess","Kolkata",10));
        EventList.getInstance().add_data(new EventData("Football","Bangalore",10));
        EventList.getInstance().add_data(new EventData("BasketBall","China",10));
        EventList.getInstance().add_data(new EventData("Baseball","Russia",10));
        EventList.getInstance().add_data(new EventData("Pool","USA",10));


    }


}