package com.example.usman.bletcheypark;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class leaveFeedback extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leave_feedback);

        Button newPage=(Button) findViewById(R.id.showFeed);
        newPage.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                Intent intent= new Intent(leaveFeedback.this,feedbacklist.class);
                startActivity(intent);

            }

        });

        Button myFeed=(Button) findViewById(R.id.leavingFeedback);
        myFeed.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                Intent i = getIntent();
                String tv1= i.getExtras().getString("Email");


                Intent intent= new Intent(leaveFeedback.this,sendFeedback.class);
                intent.putExtra("Email",tv1);
                startActivity(intent);

            }

        });
    }
}
