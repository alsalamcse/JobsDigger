package com.example.jobsdigger;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class SignInCompany extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private EditText etNumber, etSMS;
    private Button btnIn, btnUp,btnGet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_company);

        etNumber = findViewById(R.id.etNumber);
        etSMS = findViewById(R.id.etSMS);
        btnIn = findViewById(R.id.btnIn);
        btnUp = findViewById(R.id.btnUp);
        btnGet=findViewById(R.id.btnGet);

        btnUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplication(), CustomerSignUpScreen.class);
                startActivity(intent);
            }
        });

        btnIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataHandler();
            }
        });
    }

    private void dataHandler() {
        String PhoneNumber = etNumber.getText().toString();
        String Code = etSMS.getText().toString();
        boolean isok = true;

        if (isValidPhoneNumber(PhoneNumber) == false) {
            etNumber.setError("Invalied PhoneNumber");
            isok = false;
        }
        if (isok)
        {
            verifyPhoneNumberWithCode(PhoneNumber,Code);
        }



    }

    private boolean isValidPhoneNumber(String PhoneNumber) {

        if (null == PhoneNumber || PhoneNumber.length() != 8) {
            return false;
        }

        if (PhoneNumber.charAt(0) != '8' && PhoneNumber.charAt(0) != '9') {
            return false;
        }

        for (char c : PhoneNumber.toCharArray()) {
            if (!Character.isDigit(c)) {
                // One of the characters is not a digit (e.g. 0-9)
                return false;
            }
        }
        // At this point you know it is valid
        return true;
    }


    private void verifyPhoneNumberWithCode(String PhoneNumber, String Code) {
        // [START verify_with_code]
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(PhoneNumber, Code);
        // [END verify_with_code]
        signInWithPhoneAuthCredential(credential);
    }


    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {

        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        mAuth.signInWithCredential(credential).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Intent intent = new Intent(getApplication(), ManageJobScreen.class);
                    startActivity(intent);


                } else {
                    etNumber.setError("PhoneNumber or Code is wrong" + task.getException().getMessage());
                    task.getException().printStackTrace();

                }
            }
        });
    }
}




