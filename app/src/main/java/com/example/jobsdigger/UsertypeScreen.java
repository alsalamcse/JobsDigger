package com.example.jobsdigger;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UsertypeScreen extends AppCompatActivity {
  private   Button btnCompany,btnJobSerarcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usertype_screen);

        btnCompany=findViewById(R.id.btnCompany);
        btnJobSerarcher=findViewById(R.id.btnJobSearcher);


        btnCompany.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent i=new Intent(getApplication(),CompanySignUpScreen.class);
                startActivity(i);
            }
        });

        btnJobSerarcher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplication(),CustomerSignUpScreen.class);
                startActivity(intent);
            }
        });
    }
}
