package com.example.usman.bletcheypark;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

import java.net.PasswordAuthentication;
import java.util.Properties;

public class createBarcodes extends AppCompatActivity {
    EditText editText2;
    Button genrateButton;
    ImageView image;
    String text2QR;
    ProgressDialog pdialog=null;
    Context context=null;
    EditText sender;
    String rec,subject,textMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_barcodes);

        Button sendemail=(Button) findViewById(R.id.sendEmail);
        sendemail.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                Intent intent= new Intent(createBarcodes.this,sendEmail.class);
                startActivity(intent);

            }

        });


        editText2=(EditText) findViewById(R.id.editText2);
        genrateButton=(Button) findViewById(R.id.genrateButton);
        image=(ImageView) findViewById(R.id.image);
        genrateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text2QR= editText2.getText().toString().trim();
                MultiFormatWriter multiFormatWriter=new MultiFormatWriter();
                try{
                    BitMatrix bitMatrix=multiFormatWriter.encode(text2QR, BarcodeFormat.QR_CODE,200,200);
                    BarcodeEncoder barcodeEncoder=new BarcodeEncoder();
                    Bitmap bitmap=barcodeEncoder.createBitmap(bitMatrix);
                    image.setImageBitmap(bitmap);
                }
                catch (WriterException e){
                    e.printStackTrace();
                }
            }
        });
    }
}
