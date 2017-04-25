package com.example.usman.bletcheypark;

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

public class postEvents extends AppCompatActivity {

    EditText eventName,eventDate, eventDescription, eventURL;
    String Ename,Edate, EDescription, EURL;
    Context ctx=this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_events);
        eventName = (EditText) findViewById(R.id.eventName);
        eventDate = (EditText) findViewById(R.id.eventDate);
        eventDescription = (EditText) findViewById(R.id.eventDescription);
        eventURL = (EditText) findViewById(R.id.eventURL);


    }

    public void register_register(View v){
        Ename = eventName.getText().toString();
        Edate = eventDate.getText().toString();
        EDescription = eventDescription.getText().toString();
        EURL= eventURL.getText().toString();
        BackGround b = new BackGround();
        b.execute(Ename, Edate, EDescription, EURL);
    }

    class BackGround extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... params) {
            String eventName = params[1];
            String eventDate = params[2];
            String eventDescription = params[3];
            String eventURL=params[0];
            String data="";
            int tmp;

            try {
                URL url = new URL("http://usmanali136.com/events.php");
                String urlParams = "eventName="+eventName+"&eventDate="+eventDate+"&eventDescription="+eventDescription+"&eventURL="+eventURL;

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
                s="Event Is Posted Successfully";
            }
            Toast.makeText(ctx, s, Toast.LENGTH_LONG).show();
        }
    }
}
