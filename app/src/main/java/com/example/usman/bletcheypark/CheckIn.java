package com.example.usman.bletcheypark;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import static com.example.usman.bletcheypark.R.id.checkIN;
import static com.example.usman.bletcheypark.R.id.scanbutton;
import static com.example.usman.bletcheypark.R.id.textViewResult;

public class CheckIn extends AppCompatActivity {

    private Button scanbutton;
    private TextView textViewResult;
    Context ctx=this;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_in);

     //   textViewResult = (TextView) findViewById(R.id.checkInPlace);
        Button newPage=(Button) findViewById(R.id.viewPlaces);
        newPage.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                Intent intent= new Intent(CheckIn.this,BletchleyPlaces.class);
                startActivity(intent);

            }
        });

        Button newPage2=(Button) findViewById(R.id.viewPlaces1);
        newPage2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                Intent intent= new Intent(CheckIn.this,BletchleyPlaces.class);
                startActivity(intent);

            }
        });




        scanbutton = (Button) findViewById(checkIN);
        final Activity activity = this;
        scanbutton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                IntentIntegrator integrator = new IntentIntegrator(activity);
                integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
                integrator.setPrompt("Scan");
                integrator.setCameraId(0);
                integrator.setBeepEnabled(false);
                integrator.setBarcodeImageEnabled(false);
                integrator.initiateScan();

            }

        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);

        if (result != null) {
            if (result.getContents() == null) {
                Toast.makeText(this, "You cancelled the scanning", Toast.LENGTH_LONG).show();
              //  TextView changeText = (TextView) findViewById(R.id.checkInPlace);

              //  BackGround b=new BackGround();
               // b.execute("", "", "", "","");

///                changeText.setText("Hello");

            } else {
                Toast.makeText(this, result.getContents(), Toast.LENGTH_LONG).show();

                String myBarcode = result.getContents().toString();
               // TextView changeText =(TextView) findViewById(R.id.checkInPlace);
                //changeText.setText(myBarcode);

                Intent i = getIntent();
                String tv1= i.getExtras().getString("Email");

                BackGround b=new BackGround();
                b.execute(myBarcode, "", "", "",tv1);
                       if (myBarcode.equals("Mansion")) {
                           openProfile();
                       }
                       if (myBarcode.equals("Hut8"))  {
                           openHut8();

                       }
                       if (myBarcode.equals("Hut11")) {
                           openHut11();
                       }
                     if (myBarcode.equals("Hut12")) {
                         openHut12();
                     }
                    if (myBarcode.equals("BlockB")) {
                         openBlockB();
                      }
            }

        }
        else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
    class BackGround extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... params) {
            String name = params[1];
            String password = params[2];
            String email = params[4];
            String id=params[0];
            String data="";
            int tmp;

            try {
                URL url = new URL("http://usmanali136.com/checkIN.php");
                String urlParams = "name="+name+"&password="+password+"&email="+email+"&id="+id;

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
    private void openProfile(){
        Intent i = getIntent();
        String tv1= i.getExtras().getString("Email");

        Intent intent = new Intent(this, mansionPage.class);
        intent.putExtra("Email",tv1);
        startActivity(intent);

       // Intent i= new Intent(BletchleyHomepage.this,shareMedia.class);
        //startActivity(intent);
    }
    private void openHut8(){
        Intent i = getIntent();
        String tv1= i.getExtras().getString("Email");

        Intent intent = new Intent(this, hut8.class);
        intent.putExtra("Email",tv1);
        startActivity(intent);
    }
    private void openHut11(){

        Intent i = getIntent();
        String tv1= i.getExtras().getString("Email");

        Intent intent = new Intent(this, hut11.class);
        intent.putExtra("Email",tv1);
        startActivity(intent);
    }
    private void openHut12(){
        Intent i = getIntent();
        String tv1= i.getExtras().getString("Email");

        Intent intent = new Intent(this, Hut12.class);
        intent.putExtra("Email",tv1);
        startActivity(intent);
    }
    private void openBlockB(){
        Intent i = getIntent();
        String tv1= i.getExtras().getString("Email");

        Intent intent = new Intent(this, BlockB.class);
        intent.putExtra("Email",tv1);
        startActivity(intent);
    }
}


