package com.example.usman.bletcheypark;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class BletchleyHomepage extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bletchley_homepage);

       // TextView changeText = (TextView) findViewById(R.id.email);



        Button newPage=(Button) findViewById(R.id.directionBTN);
        newPage.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                Intent intent= new Intent(BletchleyHomepage.this,directionsHomepage.class);
                startActivity(intent);

            }
        });
        Button newPage2=(Button) findViewById(R.id.button12);
        newPage2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                Intent intent= new Intent(BletchleyHomepage.this,directionsHomepage.class);
                startActivity(intent);
            }
        });


        Button myshareMedia=(Button) findViewById(R.id.shareButton);
        myshareMedia.setOnClickListener(new View.OnClickListener() {


            public void onClick(View view){
                Intent intent = getIntent();
                String tv1= intent.getExtras().getString("Email");

                Intent i= new Intent(BletchleyHomepage.this,shareMedia.class);
                i.putExtra("Email",tv1);
                startActivity(i);

            }

        });
        Button myshareMedia2=(Button) findViewById(R.id.button7);
        myshareMedia2.setOnClickListener(new View.OnClickListener() {


            public void onClick(View view){
                Intent intent = getIntent();
                String tv1= intent.getExtras().getString("Email");

                Intent i= new Intent(BletchleyHomepage.this,shareMedia.class);
                i.putExtra("Email",tv1);
                startActivity(i);

            }

        });

        Button checkinPage=(Button) findViewById(R.id.scanItems);
        checkinPage.setOnClickListener(new View.OnClickListener() {


            public void onClick(View view){
                Intent intent = getIntent();
                String tv1= intent.getExtras().getString("Email");

                Intent i= new Intent(BletchleyHomepage.this,CheckIn.class);
                i.putExtra("Email",tv1);
                startActivity(i);

            }

        });

        Button checkinPage2=(Button) findViewById(R.id.button10);
        checkinPage2.setOnClickListener(new View.OnClickListener() {


            public void onClick(View view){
                Intent intent = getIntent();
                String tv1= intent.getExtras().getString("Email");

                Intent i= new Intent(BletchleyHomepage.this,CheckIn.class);
                i.putExtra("Email",tv1);
                startActivity(i);

            }

        });

        Button explorePage=(Button) findViewById(R.id.exploreBTN);
        explorePage.setOnClickListener(new View.OnClickListener() {


            public void onClick(View view){
                Intent intent= new Intent(BletchleyHomepage.this,exploreHomepage.class);
                startActivity(intent);

            }

        });
        Button explorePage2=(Button) findViewById(R.id.button9);
        explorePage2.setOnClickListener(new View.OnClickListener() {


            public void onClick(View view){
                Intent intent= new Intent(BletchleyHomepage.this,exploreHomepage.class);
                startActivity(intent);

            }

        });


        Button feedbackPage=(Button) findViewById(R.id.feedbackbutton);
        feedbackPage.setOnClickListener(new View.OnClickListener() {


            public void onClick(View view){
                Intent intent = getIntent();
                String tv1= intent.getExtras().getString("Email");

                Intent i= new Intent(BletchleyHomepage.this,leaveFeedback.class);
                i.putExtra("Email",tv1);
                startActivity(i);

            }

        });
        Button feedbackPage2=(Button) findViewById(R.id.button8);
        feedbackPage2.setOnClickListener(new View.OnClickListener() {


            public void onClick(View view){
                Intent intent = getIntent();
                String tv1= intent.getExtras().getString("Email");

                Intent i= new Intent(BletchleyHomepage.this,leaveFeedback.class);
                i.putExtra("Email",tv1);
                startActivity(i);

            }

        });


        Button adminPage=(Button) findViewById(R.id.bletchleyInfo);
        adminPage.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                Intent intent= new Intent(BletchleyHomepage.this,infoPage.class);
                startActivity(intent);
            }

        });

        Button adminPage2=(Button) findViewById(R.id.button17);
        adminPage2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                Intent intent= new Intent(BletchleyHomepage.this,infoPage.class);
                startActivity(intent);
            }

        });
    }
}
