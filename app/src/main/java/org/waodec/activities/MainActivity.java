package org.waodec.activities;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;
import org.waodec.R;
import org.waodec.activities.urls.URLS;

import java.net.URL;
import java.net.URLEncoder;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private Button signUp, singIn, change;

    private Intent nextIntent;

    private final String BANGLA = "bn_BD";
    private Context mContext;

    private JsonArrayRequest jsonArrayRequest;


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

                try {
                    mContext = getApplicationContext();
                    //URL url = new URL(URLS.THANA_UPLOAD);

                    String url = URLS.THANA_UPLOAD;


                    //url = URLEncoder.encode(url);
                    //   System.out.println(url);

                    RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());


                    JSONObject gson = new JSONObject();


                    gson.put("thana_id", 2);
                    gson.put("thana_name", "Rampura");


                    JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, gson, new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {

                            Log.i("Thana Register", response.toString() + "");
                        }


                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                            System.out.println(error.getCause());
                        }


                    });

                    requestQueue.add(jsonObjectRequest);


                } catch (Exception e) {

                    System.out.println(e.getMessage());
                }


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
