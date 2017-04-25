package com.example.usman.bletcheypark;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class adminHomepage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_homepage);





        Button logincheck =(Button) findViewById(R.id.events);
        logincheck.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                Intent intent= new Intent(adminHomepage.this,postEvents.class);
                startActivity(intent);
            }

        });


        Button eventCheck =(Button) findViewById(R.id.register);
        eventCheck.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                Intent intent= new Intent(adminHomepage.this,eventsList.class);
                startActivity(intent);
            }

        });


        Button createAdmin =(Button) findViewById(R.id.button24);
        createAdmin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                Intent intent= new Intent(adminHomepage.this,createAdmin.class);
                startActivity(intent);
            }

        });
        Button viewFeedback =(Button) findViewById(R.id.button4);
        viewFeedback.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                Intent intent= new Intent(adminHomepage.this,feedbacklist.class);
                startActivity(intent);
            }
        });
    }
}