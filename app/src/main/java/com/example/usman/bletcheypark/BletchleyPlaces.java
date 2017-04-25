package com.example.usman.bletcheypark;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BletchleyPlaces extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bletchley_places);

        Button mansion=(Button) findViewById(R.id.mansion);
        mansion.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                Intent intent= new Intent(BletchleyPlaces.this,mansionPage.class);
                startActivity(intent);

            }
        });
        Button mansion1=(Button) findViewById(R.id.mansion1);
        mansion1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                Intent intent= new Intent(BletchleyPlaces.this,mansionPage.class);
                startActivity(intent);

            }
        });

        Button blockb=(Button) findViewById(R.id.blockb);
        blockb.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                Intent intent= new Intent(BletchleyPlaces.this,BlockB.class);
                startActivity(intent);

            }
        });

        Button blockb1=(Button) findViewById(R.id.blockb1);
        blockb1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                Intent intent= new Intent(BletchleyPlaces.this,BlockB.class);
                startActivity(intent);

            }
        });
        Button hut8=(Button) findViewById(R.id.hut8);
        hut8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                Intent intent= new Intent(BletchleyPlaces.this,hut8.class);
                startActivity(intent);

            }
        });
        Button hut81=(Button) findViewById(R.id.hut81);
        hut81.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                Intent intent= new Intent(BletchleyPlaces.this,hut8.class);
                startActivity(intent);

            }
        });

        Button hut11=(Button) findViewById(R.id.hut11);
        hut11.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                Intent intent= new Intent(BletchleyPlaces.this,hut11.class);
                startActivity(intent);

            }
        });
        Button hut111=(Button) findViewById(R.id.hut111);
        hut111.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                Intent intent= new Intent(BletchleyPlaces.this,hut11.class);
                startActivity(intent);

            }
        });

        Button hut12=(Button) findViewById(R.id.hut12);
        hut12.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                Intent intent= new Intent(BletchleyPlaces.this,Hut12.class);
                startActivity(intent);

            }
        });

        Button hut121=(Button) findViewById(R.id.hut121);
        hut121.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                Intent intent= new Intent(BletchleyPlaces.this,Hut12.class);
                startActivity(intent);

            }
        });
    }
}
