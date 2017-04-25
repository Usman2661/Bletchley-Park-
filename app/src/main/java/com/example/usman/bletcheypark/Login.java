package com.example.usman.bletcheypark;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Login extends AppCompatActivity implements View.OnClickListener {



    public static final String LOGIN_URL = "http://www.usmanali136.com/login.php";

    public static final String KEY_USERNAME="username";
    public static final String KEY_PASSWORD="password";




    private EditText editTextUsername;
    private EditText editTextPassword;
    private Button loginButton;

    private String username;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextUsername = (EditText) findViewById(R.id.nameText);
        editTextPassword = (EditText) findViewById(R.id.passwordText);

        loginButton = (Button) findViewById(R.id.loginButton);

        loginButton.setOnClickListener(this);


        Button registerPage=(Button) findViewById(R.id.registerButton);
        registerPage.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                Intent intent= new Intent(Login.this,RegisterPage.class);
                startActivity(intent);
            }

        });
    }


    private void userLogin() {
        username = editTextUsername.getText().toString().trim();
        password = editTextPassword.getText().toString().trim();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, LOGIN_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if(response.trim().equals("successEmail or Password is Incorrect")) {
                            openProfile();
                        }
                        if (response.trim().equals("admin")) {
                                openAdmin();
                            }
                        else{
                            Toast.makeText(Login.this,response,Toast.LENGTH_LONG).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Login.this,error.toString(),Toast.LENGTH_LONG ).show();
                    }
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> map = new HashMap<String,String>();
                map.put(KEY_USERNAME,username);
                map.put(KEY_PASSWORD,password);
                return map;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    private void openProfile(){
        Intent intent = new Intent(this, BletchleyHomepage.class);
        intent.putExtra(KEY_USERNAME, username);
        intent.putExtra("Email",editTextUsername.getText().toString());
        startActivity(intent);
    }
    private void openAdmin(){
        Intent intent = new Intent(this, adminHomepage.class);
        intent.putExtra(KEY_USERNAME, username);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        final String email = editTextUsername.getText().toString();
        if (!isValidEmail(email)) {
            editTextUsername.setError("Invalid Email");
        }

        final String pass = editTextPassword.getText().toString();
        if (!isValidPassword(pass)) {
            editTextPassword.setError("Invalid Password");
        }
        if (isValidPassword(pass) & isValidEmail(email)){
            userLogin();
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
        if (pass != null && pass.length() > 1) {
            return true;
        }
        return false;
    }
}
