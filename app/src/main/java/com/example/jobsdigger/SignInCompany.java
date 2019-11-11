package com.example.jobsdigger;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignInCompany extends AppCompatActivity {
    private EditText etNumber,etSMS ;
    private Button btnIn,btnUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_company);

        etNumber=findViewById(R.id.etNumber);
        etSMS=findViewById(R.id.etSMS);
        btnIn=findViewById(R.id.btnIn);
        btnUp=findViewById(R.id.btnUp);

        btnUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplication(),CustomerSignUpScreen.class);
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
    private void dataHandler()
    {
        
    }
}
