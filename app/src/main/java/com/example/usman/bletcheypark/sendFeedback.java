package com.example.usman.bletcheypark;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class sendFeedback extends Activity {

    EditText name,feedback;
    String Name, Feedback;
    Context ctx=this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_feedback);
       // name = (EditText) findViewById(R.id.myName);
        feedback = (EditText) findViewById(R.id.myFeedback);
     //   email = (EditText) findViewById(R.id.userEmail);
      //  id = (EditText) findViewById(R.id.userID);


    }

    public void register_register(View v){
       // Name = name.getText().toString();
        Feedback = feedback.getText().toString();
       // Email = email.getText().toString();
        //ID= id.getText().toString();

        Intent intent = getIntent();
        String tv1= intent.getExtras().getString("Email");


        BackGround b = new BackGround();
        b.execute(tv1, Feedback);
    }

    class BackGround extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... params) {
            String name = params[0];
            String feedback = params[1];
         //   String email = params[3];
          //  String id=params[0];
            String data="";
            int tmp;

            try {
                URL url = new URL("http://usmanali136.com/leavingFeedback.php");
                String urlParams = "name="+name+"&feedback="+feedback;

                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setDoOutput(true);
                OutputStream os = httpURLConnection.getOutputStream();
                os.write(urlParams.getBytes());
                os.flush();
                os.close();
                InputStream is = httpURLConnection.getInputStream();
                while((tmp=is.read())!=-1){
                    data+= (char)tmp;
                }
                is.close();
                httpURLConnection.disconnect();

                return data;

            } catch (MalformedURLException e) {
                e.printStackTrace();
                return "Exception: "+e.getMessage();
            } catch (IOException e) {
                e.printStackTrace();
                return "Exception: "+e.getMessage();
            }
        }

        @Override
        protected void onPostExecute(String s) {
            if(s.equals("")){
                s="Data saved successfully.";
            }
            Toast.makeText(ctx, s, Toast.LENGTH_LONG).show();
        }
    }
}
