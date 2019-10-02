package com.example.jobsdigger;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ManageJobScreen extends AppCompatActivity {

    Button btnaddjob,btnSeeCustomer,btnUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_job_screen);

        btnaddjob=findViewById(R.id.btnaddjob);
        btnSeeCustomer=findViewById(R.id.btnSeeCustomer);
        btnUpdate=findViewById(R.id.btnUpdate);


        btnaddjob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplication(),AddJobScreen.class);
                startActivity(intent);
            }
        });
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplication(),JobslistScreen.class);
                startActivity(i);
            }
        });
        btnSeeCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent see=new Intent(getApplication(),SeeCustomersScreen.class);
                startActivity(see);
            }
        });
    }
}
