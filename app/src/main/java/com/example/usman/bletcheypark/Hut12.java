package com.example.usman.bletcheypark;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import static com.example.usman.bletcheypark.R.id.checkout;

public class Hut12 extends AppCompatActivity {
    private Button scanbutton;

    Context ctx=this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hut12);

        Button scanPage=(Button) findViewById(R.id.scanPage);
        scanPage.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                Intent intent= new Intent(Hut12.this,scanItems.class);
                startActivity(intent);

            }

        });


        scanbutton = (Button) findViewById(checkout);
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

        WebView myWebView = (WebView) findViewById(R.id.webView);
        myWebView.loadUrl("https://bletchleypark.org.uk/visit-us/what-to-see/hut-12");

        myWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return false;
            }
        });
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);

        if (result != null) {
            if (result.getContents() == null) {
                Toast.makeText(this, "You cancelled the scanning", Toast.LENGTH_LONG).show();
                //  TextView changeText = (TextView) findViewById(R.id.checkInPlace);

                BackGround b=new BackGround();
                b.execute("", "", "", "", "");

                //  changeText.setText("Hello");

            } else {
                Toast.makeText(this, result.getContents(), Toast.LENGTH_LONG).show();

                String myBarcode = result.getContents().toString();
                //  TextView changeText =(TextView) findViewById(R.id.checkInPlace);
                // changeText.setText(myBarcode);

                Intent i = getIntent();
                String tv1= i.getExtras().getString("Email");

                BackGround b=new BackGround();
                b.execute(myBarcode, "", "", "",tv1);
                backtocheckin();
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
                URL url = new URL("http://usmanali136.com/checkOUT.php");
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

    private void backtocheckin(){
        Intent intent = new Intent(this, CheckIn.class);
        startActivity(intent);
    }
}
