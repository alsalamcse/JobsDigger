package com.example.jobsdigger;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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


    }
}
