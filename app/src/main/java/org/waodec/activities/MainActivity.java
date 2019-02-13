package org.waodec.activities;


import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.waodec.R;
import org.waodec.activities.entities.Thana;
import org.waodec.activities.urls.URLS;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private Button signUp, singIn, change;

    private Intent nextIntent;

    private final String BANGLA = "bn_BD";
    private RequestQueue requestQueue;
    private JSONArray thanas;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        signUp = (Button) findViewById(R.id.sign_up);
        singIn = (Button) findViewById(R.id.sign_in);
        change = (Button) findViewById(R.id.change);

        signUp.setOnClickListener(this);
        singIn.setOnClickListener(this);
        change.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {


        switch (view.getId()) {
            case R.id.sign_up:



                nextIntent = new Intent(MainActivity.this, SignupActivity.class);

                startActivity(nextIntent);
                finish();

                System.out.println("Hello");

                return;
            case R.id.sign_in:


                return;

            case R.id.change:

                LocalHelper.setLocale(MainActivity.this, BANGLA);
                recreate();

                System.out.println("Hello");
                // String text = getResources(R.bangla_string.);


                return;
        }

    }





}
