package org.waodec.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import org.waodec.R;
import org.waodec.activities.entities.RegisterClient;

public class SignupActivity extends AppCompatActivity implements View.OnClickListener {


    private Button back, submit;

    private Intent backToSigninSignUpIntent;

    private EditText firstName, lastName, email, phoneNum, location;

    private Spinner division, zela, thana, postOfficeCode;


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

                System.out.println(firstName.getText() + " " + lastName.getText());

                RegisterClient registerClient = new RegisterClient();

                // EditText set

                registerClient.setFirstName(firstName.getText().toString());
                registerClient.setLastName(lastName.getText().toString());
                registerClient.setEmail(email.getText().toString());
                registerClient.setPhone_num(phoneNum.getText().toString());

                //Spinner set

                registerClient.setZelaId((int) zela.getSelectedItemId());
                registerClient.setDivisionId((int) division.getSelectedItemId());
                registerClient.setThanaId((int) thana.getSelectedItemId());
                registerClient.setPostOfficeCodeId((int) postOfficeCode.getSelectedItemId());

                System.out.println(registerClient);

                return;
        }
    }
}
