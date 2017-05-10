package com.example.usman.bletcheypark;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class socialShare extends AppCompatActivity {

    private EditText editTextUsername;
    private EditText editTextPassword;
    private Button loginButton;

    private String username;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_social_share);

        //Creating the share button and setting the action listener
        Button share=(Button) findViewById(R.id.Share);
        share.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){

                //Getting the text input in the field from the user
                editTextUsername = (EditText) findViewById(R.id.nameText);
                username = editTextUsername.getText().toString().trim();
                //Opening the share intent to show all social media options along with passing the textfield text
                Intent share = new Intent(Intent.ACTION_SEND);
                share.setType("text/plain");
                share.putExtra(Intent.EXTRA_TEXT, username);

                startActivity(Intent.createChooser(share, "Title of the dialog the system will open"));

            }

        });
    }
}
