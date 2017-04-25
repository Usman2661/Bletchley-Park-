package com.example.usman.bletcheypark;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class shareMedia extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_media);

        Button newPage=(Button) findViewById(R.id.sharebutton);
        newPage.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                Intent i = getIntent();
                String tv1= i.getExtras().getString("Email");

                Intent intent= new Intent(shareMedia.this,feedUpload.class);
                intent.putExtra("Email",tv1);
                startActivity(intent);

            }

        });
        Button newPage1=(Button) findViewById(R.id.sharebutton1);
        newPage1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                Intent i = getIntent();
                String tv1= i.getExtras().getString("Email");

                Intent intent= new Intent(shareMedia.this,feedUpload.class);
                intent.putExtra("Email",tv1);
                startActivity(intent);

            }

        });
        Button myNewPage=(Button) findViewById(R.id.checkFeeds);
        myNewPage.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                Intent intent= new Intent(shareMedia.this,FeedsPage.class);
                startActivity(intent);

            }

        });
        Button myNewPage1=(Button) findViewById(R.id.checkFeeds1);
        myNewPage1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                Intent intent= new Intent(shareMedia.this,FeedsPage.class);
                startActivity(intent);

            }

        });

        Button another=(Button) findViewById(R.id.shareSocial);
        another.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                Intent intent= new Intent(shareMedia.this,socialShare.class);
                startActivity(intent);

            }

        });
        Button another1=(Button) findViewById(R.id.shareSocial1);
        another1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                Intent intent= new Intent(shareMedia.this,socialShare.class);
                startActivity(intent);

            }

        });
    }
}
