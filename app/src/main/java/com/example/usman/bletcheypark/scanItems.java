package com.example.usman.bletcheypark;

import android.app.Activity;
import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import android.app.ProgressDialog;

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

import java.util.Locale;

import static com.example.usman.bletcheypark.R.id.editTextId;
import static com.example.usman.bletcheypark.R.id.myText;

public class scanItems extends AppCompatActivity  {
    private Button scanbutton;
    private TextView textViewResult;
    private ProgressDialog loading;
    Button Read;
    Button Stop;
    Button Stop2;
    Button Read2;
    TextToSpeech t1;
    TextToSpeech t2;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_items);

        textViewResult = (TextView) findViewById(R.id.myText);
        Read=(Button)findViewById(R.id.audioButton);
        Stop=(Button)findViewById(R.id.stopAudio);
        Stop2=(Button)findViewById(R.id.audio2);
        Read2=(Button)findViewById(R.id.listen2);



        t1=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    t1.setLanguage(Locale.UK);
                }
            }
        });

        //Creating t2 as text to speech reader and settiing the language to English UK
        t2=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    t2.setLanguage(Locale.UK);
                }
            }
        });
        //Action listenner to the listen audio button
        Read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creating a string varaible of the text to be read
                String toSpeak = textViewResult.getText().toString();
                //Passing String Text to the t2 speech variable to read
                t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
            }
        });

        Read2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String toSpeak = textViewResult.getText().toString();
                //Toast.makeText(getApplicationContext(), toSpeak,Toast.LENGTH_SHORT).show();
                t2.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
            }
        });
        Read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String toSpeak = textViewResult.getText().toString();
                //Toast.makeText(getApplicationContext(), toSpeak,Toast.LENGTH_SHORT).show();
                t2.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
            }
        });


        Stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t1.stop();
                t2.stop();
            }
        });

        Stop2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t1.stop();
                t2.stop();
            }
        });





        scanbutton=(Button) findViewById(R.id.scanbutton);
        final Activity activity=this;
        scanbutton.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view){
                IntentIntegrator integrator= new IntentIntegrator(activity);
                integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
                integrator.setPrompt("Scan");
                integrator.setCameraId(0);
                integrator.setBeepEnabled(false);
                integrator.setBarcodeImageEnabled(false);
                integrator.initiateScan();

            }

        });
    }
    public void onPause(){
        if(t1 !=null){
            t1.stop();
            t1.shutdown();
        }
        super.onPause();
    }



    @Override
    //Method For Scanning the QR Barcode and Retreiving Results of the barcode
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        //Creating the intent to retrive the result code data
        IntentResult result=IntentIntegrator.parseActivityResult(requestCode, resultCode,data);

        //If there is no result retrieved from QR barcode
        if (result!=null){
            if (result.getContents()==null){
                //View the message of cancelling scanning if the user backs from scanning
                Toast.makeText(this, "You cancelled the scanning", Toast.LENGTH_LONG).show();
                TextView changeText =(TextView) findViewById(R.id.myText);

                changeText.setText("Hello");

            }
            //this else statemeng will run when the QR Barcode item is scanned
            else {
                //Showing the results of the retrieved contents of QR barcode
                Toast.makeText(this, result.getContents(),Toast.LENGTH_LONG).show();

                String myBarcode=result.getContents().toString();


                {
                    String id = result.getContents().toString().trim();
                    if (id.equals("")) {
                        Toast.makeText(this, "Please enter an id", Toast.LENGTH_LONG).show();
                        return;
                    }
                    final ProgressDialog loading = ProgressDialog.show(this, "Please wait...", "Fetching...", false, false);

                    String url = Config.DATA_URL+id.toString().trim();

                    StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            loading.dismiss();
                            showJSON(response);
                        }
                    },
                            new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {
                                    Toast.makeText(scanItems.this,error.getMessage().toString(),Toast.LENGTH_LONG).show();
                                }
                            });

                    RequestQueue requestQueue = Volley.newRequestQueue(this);
                    requestQueue.add(stringRequest);
                }
            }
        }
        else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }


    private void showJSON(String response){
        String name="";
        String address="";
        String vc = "";
        try {
            JSONObject jsonObject = new JSONObject(response);
            JSONArray result = jsonObject.getJSONArray(Config.JSON_ARRAY);
            JSONObject collegeData = result.getJSONObject(0);
            name = collegeData.getString(Config.KEY_NAME);
            address = collegeData.getString(Config.KEY_ADDRESS);
            vc = collegeData.getString(Config.KEY_VC);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        textViewResult.setText("Item Name:\t"+name+"\nDescription:\t" + vc+ "\nYear Made In:\t"+address );
    }



   // @Override
   // public void onClick(View v) {
     //   getData();
    //}
}
