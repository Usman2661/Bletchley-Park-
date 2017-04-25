package com.example.usman.bletcheypark;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class infoPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_page);


        Button adminPage=(Button) findViewById(R.id.event1);
        adminPage.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                Intent intent= new Intent(infoPage.this,eventsList.class);
                startActivity(intent);
            }

        });

        Button adminPage1=(Button) findViewById(R.id.events);
        adminPage1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                Intent intent= new Intent(infoPage.this,eventsList.class);
                startActivity(intent);
            }

        });

        Button ticket=(Button) findViewById(R.id.ticket);
        ticket.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                Intent intent= new Intent(infoPage.this,ticket.class);
                startActivity(intent);
            }

        });

        Button ticket1=(Button) findViewById(R.id.ticket1);
        ticket1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                Intent intent= new Intent(infoPage.this,ticket.class);
                startActivity(intent);
            }

        });

        Button news=(Button) findViewById(R.id.news);
        news.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                Intent intent= new Intent(infoPage.this,newsBletchley.class);
                startActivity(intent);
            }

        });

        Button news1=(Button) findViewById(R.id.news1);
        news1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                Intent intent= new Intent(infoPage.this,newsBletchley.class);
                startActivity(intent);
            }

        });

        Button website=(Button) findViewById(R.id.website);
        website.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                Intent intent= new Intent(infoPage.this,newPage.class);
                startActivity(intent);
            }

        });

        Button website1=(Button) findViewById(R.id.website1);
        website1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                Intent intent= new Intent(infoPage.this,newPage.class);
                startActivity(intent);
            }

        });

    }
}
