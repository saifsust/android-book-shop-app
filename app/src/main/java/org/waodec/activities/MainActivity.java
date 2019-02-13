package org.waodec.activities;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;
import org.waodec.R;
import org.waodec.activities.Spinners_fetcher.Authenticationer;
import org.waodec.activities.urls.URLS;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private Button signUp, singIn, change;

    private EditText email, password;

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

        //authentication

        email = (EditText) findViewById(R.id.sign_in_email);
        password = (EditText) findViewById(R.id.sing_in_pwd);

        signUp.setOnClickListener(this);
        singIn.setOnClickListener(this);
        change.setOnClickListener(this);
    }

    private boolean isNotEmpty() {
        return !email.getText().toString().isEmpty() && !password.getText().toString().isEmpty();
    }


    @Override
    public void onClick(View view) {


        switch (view.getId()) {
            case R.id.sign_up:

                Log.i("sign up", "sign up button clicked !");
                nextIntent = new Intent(MainActivity.this, SignupActivity.class);

                startActivity(nextIntent);
                finish();

                System.out.println("Hello");

                return;
            case R.id.sign_in:

                if (isNotEmpty()) {
                    try {
                        JSONObject userInfo = new JSONObject();

                        userInfo.put("email", email.getText().toString());
                        userInfo.put("password", password.getText().toString());

                        requestQueue = Volley.newRequestQueue(getApplicationContext());
                        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, URLS.POST_AUTHENTICATION, userInfo, new RequestListener(), new RequestListener());
                        requestQueue.add(request);

                        Log.i("userInfo", userInfo.toString());

                    } catch (Exception ex) {
                        Log.e("userInfoError", ex.getMessage());
                    }


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

    /**
     *
     *
     *
     */

    private class RequestListener implements Response.Listener<JSONObject>, Response.ErrorListener {


        @Override
        public void onResponse(JSONObject response) {
            try {
                Log.i("onResponse", "authorized successfully " + response.toString());
                /**
                 *if authentication is done seccessfully then seachactivity will open . otherwise Toast show
                 */

                if (response.getBoolean("token")) {
                    nextIntent = new Intent(MainActivity.this, SearchActivity.class);
                    startActivity(nextIntent);
                    finish();
                } else {
                    Toast.makeText(getApplicationContext(), "Your password or email id is invalid", Toast.LENGTH_LONG).show();
                }
            } catch (Exception ex) {
                Log.e("onResponse", ex.getMessage());
            }
        }

        @Override
        public void onErrorResponse(VolleyError error) {
            Log.e("onErrorResponse", error.getMessage());
        }
    }


}
