package com.example.usman.bletcheypark;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class createAdmin extends AppCompatActivity {

    EditText id,name, password, email;
    String ID,Name, Password, Email;
    Context ctx=this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_admin);
        name = (EditText) findViewById(R.id.userName);
        password = (EditText) findViewById(R.id.userPassword);
        email = (EditText) findViewById(R.id.userEmail);
        id = (EditText) findViewById(R.id.userID);
    }

    public void register_register(View v){
        final String emails = email.getText().toString();
        if (!isValidEmail(emails)) {
            email.setError("Invalid Email");
        }

        final String pass = password.getText().toString();
        if (!isValidPassword(pass)) {
            password.setError("Invalid Password Password has to be greater than 2 letters");
        }
        final String fname = id.getText().toString();
        if (!isfnameValid(fname)) {
            id.setError("Invalid First Name");
        }
        final String lname = name.getText().toString();
        if (!islnameValid(lname)) {
            name.setError("Invalid Last Name");
        }
        if (islnameValid(lname) & isValidPassword(pass) & isfnameValid(fname) & isValidEmail(emails)){
            Name = name.getText().toString();
            Password = password.getText().toString();
            Email = email.getText().toString();
            ID= id.getText().toString();
            BackGround b=new BackGround();
            b.execute(ID, Name, Password, Email);
        }
    }

    class BackGround extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... params) {
            String name = params[1];
            String password = params[2];
            String email = params[3];
            String id=params[0];
            String data="";
            int tmp;

            try {
                URL url = new URL("http://usmanali136.com/adminRegisteration.php");
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
    private boolean isValidEmail(String email) {
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    // validating password with retype password
    private boolean isValidPassword(String pass) {
        if (pass != null && pass.length() > 2) {
            return true;
        }
        return false;
    }

    // validating password with retype password
    private boolean isfnameValid(String fname) {
        if (fname != null && fname.length() > 1) {
            return true;
        }
        return false;
    }

    // validating password with retype password
    private boolean islnameValid(String lname) {
        if (lname != null && lname.length() > 1) {
            return true;
        }
        return false;
    }
}
