package com.example.jobsdigger;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

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
        etPlace.setError("Enter Place");

    }
    if (isok)
    {
        createCompanyAccount(Email,password,CompanyName,PhoneNumber,Place);

    }
    }

    private void createCompanyAccount(String Email,String password,String CompanyName,String PhoneNumber,String Place)
    {
        FirebaseAuth firebaseAuth=FirebaseAuth.getInstance();
        firebaseAuth.createUserWithEmailAndPassword(Email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(CompanySignUpScreen.this,"SignUp Successful",Toast.LENGTH_SHORT ).show();
                    finish();

                }
                else {
                    etEmail.setError("SignUp fialed"+task.getException().getMessage() );
                    task.getException().printStackTrace();
                }

            }
        });

    }
}
