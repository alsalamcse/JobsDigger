package com.example.jobsdigger;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class CustomerDetailsScreen extends AppCompatActivity {
    private EditText eteducation,ethistory,etage,etSkills,etlang,etinter,etIDnumber,etreference,etcourses;
    private Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_details_screen);

        eteducation=findViewById(R.id.eteducation);
        etage=findViewById(R.id.etage);
        ethistory=findViewById(R.id.ethistory);
        etSkills=findViewById(R.id.etSkills);
        etlang=findViewById(R.id.etlang);
        etinter=findViewById(R.id.etinter);
    }
}
