package com.example.jobsdigger;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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
        etreference=findViewById(R.id.etreference);
        etcourses=findViewById(R.id.etcourses);
        etIDnumber=findViewById(R.id.etIDnumber);
        btnSave=findViewById(R.id.btnSave);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              dataHandler();
            }
        });
    }
    private void dataHandler(){
        boolean isok=true;
        String Education=eteducation.getText().toString();
        String Age=etage.getText().toString();
        String EmploymentHistory=ethistory.getText().toString();
        String Skills=etSkills.getText().toString();
        String language=etlang.getText().toString();
        String interships=etinter.getText().toString();
        String reference=etreference.getText().toString();
        String courses=etcourses.getText().toString();
        String IDnumber=etIDnumber.getText().toString();

        if (Education.length()== 0)
        {
            eteducation.setError("Enter Education");
            isok=false;

        }

        if (Age.length()<18)
        {
            etage.setError("Enter the age of 18 years and above ");
            isok=false;
        }
        if (EmploymentHistory.length()==0){
            ethistory.setError("Enter EmploymentHistory");
            isok=false;
        }
        if (Skills.length()==0){
            etSkills.setError("Enter Sills");
            isok=false;
        }
        if (language.length()==0){
            etlang.setError("Enter Language");
            isok=false;
        }
        if (interships.length()==0){
            etinter.setError("Enter interships");
            isok=false;
        }
        if (reference.length()==0){
            etreference.setError("Enter reference");
            isok=false;
        }
        if (courses.length()==0){
            etcourses.setError("Enter courses");
            isok=false;
        }
        if (IDnumber.length()==0){
            etIDnumber.setError("Enter ID Number");
            isok=false;

        }
        if (isok)
        {
            finish();
        }









    }
}
