package com.example.jobsdigger;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeScreen extends AppCompatActivity {
    private Button btnSearcher,btncompany;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        btnSearcher=findViewById(R.id.btnSearcher);
        btncompany=findViewById(R.id.btncompany);


        btnSearcher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplication(),SignInScreen.class);
                startActivity(intent);
            }
        });

        btncompany.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplication(),CompanySigninScreen.class);
                startActivity(i);

            }
        });
    }
}
