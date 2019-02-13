package org.waodec.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;
import org.waodec.R;
import org.waodec.activities.Spinners_fetcher.DivisionFetcher;
import org.waodec.activities.Spinners_fetcher.PostOfficeCodeFetcher;
import org.waodec.activities.Spinners_fetcher.ThanaFetcher;
import org.waodec.activities.Spinners_fetcher.ZelaFetcher;
import org.waodec.activities.uploader.RegisterClientUploader;
import org.waodec.activities.urls.URLS;

public class SignupActivity extends AppCompatActivity implements View.OnClickListener {


    private Button back, submit;

    private Intent backToSigninSignUpIntent;
    private Intent bookSearchIntent;

    private EditText firstName, lastName, email, phoneNum, location;

    private Spinner division, zela, thana, postOfficeCode;

    private RequestQueue requestQueue;//= Volley.newRequestQueue(getApplicationContext());

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up_activity);


        back = (Button) findViewById(R.id.sign_in_back);
        submit = (Button) findViewById(R.id.signup_submit);


        // EditTexts are implemented
        firstName = (EditText) findViewById(R.id.first_name);
        lastName = (EditText) findViewById(R.id.last_name);
        email = (EditText) findViewById(R.id.email);
        phoneNum = (EditText) findViewById(R.id.phone_number);
        location = (EditText) findViewById(R.id.location);


        //Spinners are implemented
        division = (Spinner) findViewById(R.id.division);
        zela = (Spinner) findViewById(R.id.zila);
        thana = (Spinner) findViewById(R.id.thana);
        postOfficeCode = (Spinner) findViewById(R.id.post_office_code);

        back.setOnClickListener(this);
        submit.setOnClickListener(this);
        requestQueue = Volley.newRequestQueue(getApplicationContext());

        ThanaFetcher fetcher = new ThanaFetcher(thana, requestQueue, getApplicationContext());
        new ZelaFetcher(zela, requestQueue, getApplicationContext());

        PostOfficeCodeFetcher.ViewPostOfficeCode(requestQueue, getApplicationContext(), postOfficeCode);
        DivisionFetcher.viewDivision(requestQueue, division, getApplicationContext());


        // System.out.println(previousIntent.getStringExtra("thanas"));

    }

    /**
     * none field is empty then return true otherwise false
     *
     * @return boolean
     */


    private boolean isNotEmpty() {
        return !firstName.getText().toString().isEmpty() &&
                !lastName.getText().toString().isEmpty() &&
                !email.getText().toString().isEmpty() &&
                !phoneNum.getText().toString().isEmpty() &&
                !location.getText().toString().isEmpty() &&
                thana.getSelectedItemPosition() != 0 &&
                zela.getSelectedItemPosition() != 0 &&
                postOfficeCode.getSelectedItemPosition() != 0 &&
                division.getSelectedItemPosition() != 0;
    }



    @Override
    public void onClick(View v) {


        switch (v.getId()) {
            case R.id.sign_in_back:
                backToSigninSignUpIntent = new Intent(SignupActivity.this, MainActivity.class);
                startActivity(backToSigninSignUpIntent);
                finish();
                return;
            case R.id.signup_submit:

                try {

                    if (isNotEmpty()) {
                        JSONObject data = new JSONObject();
                        data.put("firstName", firstName.getText().toString());
                        data.put("lastName", lastName.getText().toString());
                        data.put("email", email.getText().toString());
                        //future work
                        data.put("imageLink", "jajdhjahdjah");
                        data.put("phoneNumber", phoneNum.getText().toString());
                        data.put("zeladId", zela.getSelectedItemPosition());
                        data.put("devisionId", division.getSelectedItemPosition());
                        data.put("thanaId", thana.getSelectedItemPosition());
                        data.put("location", location.getText().toString());
                        data.put("postOfficeCode", postOfficeCode.getSelectedItemPosition());
                        Log.i("submit clicked", data.toString());
                        new RegisterClientUploader().upload(requestQueue, data, URLS.POST_REGISTER_CLIENT);

                        bookSearchIntent = new Intent(SignupActivity.this, SearchActivity.class);

                        startActivity(bookSearchIntent);
                        finish();

                    }
                } catch (Exception ex) {
                    Log.e("submit", ex.getMessage());
                }

                return;
        }
    }





}
