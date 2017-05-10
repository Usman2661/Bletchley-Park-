package com.example.usman.bletcheypark;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class directionsHomepage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_directions_homepage);


        Button mynew=(Button) findViewById(R.id.direction);
        mynew.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                Intent intent= new Intent(directionsHomepage.this,MapsActivity.class);
                startActivity(intent);
            }

        });

        Button placePicker=(Button) findViewById(R.id.searchAPI);
        placePicker.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                Intent intent= new Intent(directionsHomepage.this,MapsActivity.class);
                startActivity(intent);
            }

        });
    }
}
