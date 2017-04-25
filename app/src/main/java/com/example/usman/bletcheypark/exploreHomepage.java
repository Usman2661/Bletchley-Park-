package com.example.usman.bletcheypark;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class exploreHomepage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explore_homepage);


        Button scanpage=(Button) findViewById(R.id.scanItems);
        scanpage.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                Intent intent= new Intent(exploreHomepage.this,scanItems.class);
                startActivity(intent);

            }

        });

        Button explore=(Button) findViewById(R.id.explore);
        explore.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                Intent intent= new Intent(exploreHomepage.this,PanoramaVideoActivity.class);
                startActivity(intent);

            }

        });
    }
}
