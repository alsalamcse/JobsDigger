package com.example.jobsdigger;

import android.content.Intent;
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

import data.MyJobSearcher;

public class CustomerSignUpScreen extends AppCompatActivity {
    private EditText etFirst,etLast,etPhone,etEmail,etPass,etrewrite;
    private Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_sign_up_screen);

        etFirst=findViewById(R.id.etFirst);
        etLast=findViewById(R.id.etLast);
        etPhone=findViewById(R.id.etPhone);
        etEmail=findViewById(R.id.etEmail);
        etPass=findViewById(R.id.etPass);
        etrewrite=findViewById(R.id.etrewrite);
        btnNext=findViewById(R.id.btnNext);



        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplication(),CustomerDetailsScreen.class);
                startActivity(intent);
            }
        });




    }

    private void dataHandler()
    {
        boolean isok=true;
        String FirstName=etFirst.getText().toString();
        String LastName=etLast.getText().toString();
        String phone=etPhone.getText().toString();
        String Email=etEmail.getText().toString();
        String password=etPass.getText().toString();
        String rewrite=etrewrite.getText().toString();
        if (Email.length()<4||Email.indexOf('@')<0||Email.indexOf('.')<0)
        {
            etEmail.setError("Wrong Email");
            isok=false;

        }
        if (password.length()<8||password.equals(rewrite)==false)
        {
            etrewrite.setError("Have to be at least 8 char and the same Password ");
            etPass.setError("Have to be at least 8 char and the same Password");
            isok=false;
        }
        if (FirstName.length()==0)
        {
            etFirst.setError("enter name");
            isok=false;

        }
        if (isok)
        {

            createAcount(Email,password,FirstName,LastName,phone);
        }
    }

    private void createAcount(String Email, String password, String FirstName, String LastName, String phone)
    {
        FirebaseAuth auth=FirebaseAuth.getInstance();
        auth.createUserWithEmailAndPassword(Email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(CustomerSignUpScreen.this, "SignUp Successful ", Toast.LENGTH_SHORT).show();
                    finish();
                }
                else
                {
                    etEmail.setError("SignUp fialed"+task.getException().getMessage());
                    task.getException().printStackTrace();
                }

            }
        });
    }
}




