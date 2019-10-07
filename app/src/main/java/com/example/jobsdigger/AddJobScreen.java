package com.example.jobsdigger;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import data.MyJob;

public class AddJobScreen extends AppCompatActivity {
    private Button btnAdd;
    private EditText etSubject, etplace, etCompany, etTerms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_job_screen);

        etSubject = findViewById(R.id.etSubject);
        etplace = findViewById(R.id.etplace);
        etCompany = findViewById(R.id.etCompany);
        etTerms = findViewById(R.id.etTerms);
        btnAdd = findViewById(R.id.btnAdd);


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataHandler();
            }

            private void dataHandler()
            {
                boolean isok=true;
                String Subject=etSubject.getText().toString();
                String place=etplace.getText().toString();
                String Company=etCompany.getText().toString();
                String TermsOfAcceptane=etTerms.getText().toString();

                if (Subject.length()==0){
                    etSubject.setError("Enter Subject");
                    isok=false;
                }
                if (place.length()==0){
                    etplace.setError("Enter Place");
                    isok=false;
                }
                if (Company.length()==0){
                    etCompany.setError("Enter Company");

                }
                if (TermsOfAcceptane.length()==0){
                    etTerms.setError("Enter TermsOfAcceptane");
                    isok=false;
                }

                if (isok)
                {
                    MyJob myJob=new MyJob();

                }



            }
        });

    }
}
