package com.example.jobsdigger;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CompanySignUpScreen extends AppCompatActivity {
    private EditText etEmail,etPassword,etCompanyname,etPhone,etPlace;
    private Button btnSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_sign_up_screen);

        etEmail=findViewById(R.id.etEmail);
        etPassword=findViewById(R.id.etPasword);
        etCompanyname=findViewById(R.id.etCompanyname);
        etPhone=findViewById(R.id.etPhone);
        etPlace=findViewById(R.id.etPlace);
        btnSignup=findViewById(R.id.btnSignup);

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataHandler();

            }
        });
    }
    public void dataHandler()
    {
     boolean isok=true;
     String Email=etEmail.getText().toString();
     String password=etPassword.getText().toString();
     String CompanyName=etCompanyname.getText().toString();
     String PhoneNumber=etPhone.getText().toString();
     String Place=etPlace.getText().toString();
        if (Email.length()<4||Email.indexOf('@')<0||Email.indexOf('.')<0)
        {
            etEmail.setError("Wrong Email");
            isok=false;

        }
        if (password.length()<8){
            etPassword.setError("Have to be at least 8 char");
            isok=false;
        }
        if (CompanyName.length()==0){
            etCompanyname.setError("Enter Company Name");
            isok=false;
        }
        if (PhoneNumber.length()<10){


        etPhone.setError("Have to be at least 10 nums");
        isok=false;
    }
    if (Place.length()==0)
    {

    }
    }


}
