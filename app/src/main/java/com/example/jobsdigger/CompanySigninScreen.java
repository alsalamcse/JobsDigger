package com.example.jobsdigger;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class CompanySigninScreen extends AppCompatActivity {
    private EditText etmail,etpass;
    private Button btnsign,btnsignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_signin_screen);

        etmail = findViewById(R.id.etmail);
        etpass = findViewById(R.id.etpass);
        btnsign = findViewById(R.id.btnsign);
        btnsignup = findViewById(R.id.btnsignup);

        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplication(), CompanySignUpScreen.class);
                startActivity(intent);
            }
        });

        btnsign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataHandler();
            }


        });
    }
        private void dataHandler()
    {
            String email = etmail.getText().toString();
            String password = etpass.getText().toString();
            boolean isok = true;

            if (isValidEmailAddress(email) == false) {
                etmail.setError("Invalid Email");
                isok = false;
            }


            if (password.length() < 8) {
                etpass.setError("password length eror");
                isok = false;

            }
            if(isok)
            {

                signIn(email,password);
            }



        }


        private boolean isValidEmailAddress(String email) {
            String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
            java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
            java.util.regex.Matcher m = p.matcher(email);
            return m.matches();

        }

        private void signIn(String email,String password)
        {
            FirebaseAuth auth=FirebaseAuth.getInstance();
            auth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful())
                    {


                        Intent i =new Intent(getApplication(),ManageJobScreen.class);
                        startActivity(i);

                    }
                    else
                    {
                        etmail.setError("email or password is wrong"+task.getException().getMessage());
                        task.getException().printStackTrace();



                    }


                }
            });



        }
}
