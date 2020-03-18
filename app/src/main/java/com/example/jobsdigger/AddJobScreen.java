package com.example.jobsdigger;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import com.example.jobsdigger.data.MyJob;

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
        });
    }

    private void dataHandler() {
        boolean isok = true;
        String Subject = etSubject.getText().toString();
        String place = etplace.getText().toString();
        String Company = etCompany.getText().toString();
        String TermsOfAcceptane = etTerms.getText().toString();

        if (Subject.length() == 0) {
            etSubject.setError("Enter Subject");
            isok = false;
        }

        if (place.length() == 0) {
            etplace.setError("Enter Place");
            isok = false;
        }

        if (Company.length() == 0) {
            etCompany.setError("Enter Company");

        }

        if (TermsOfAcceptane.length() == 0) {
            etTerms.setError("Enter TermsOfAcceptane");
            isok = false;
        }


        if (isok) {
            MyJob myJob = new MyJob();
            myJob.setSubject(Subject);
            myJob.setPlace(place);
            myJob.setCompaney(Company);
            myJob.setTermsofAcceptanc(TermsOfAcceptane);
            createMyJob(myJob);

        }


    }

    private void createMyJob(MyJob myJob) {
        //.1
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        //.2-save in database
        DatabaseReference reference = firebaseDatabase.getReference();//make a barameter ( with var)
        FirebaseAuth auth =FirebaseAuth.getInstance();//to get the user uid or details like email
        String uid = auth.getCurrentUser().getUid();
        myJob.setOwner(uid);

        String key = reference.child("Jobs").push().getKey();
        myJob.setKey(key);
        reference.child("Jobs").child(uid).child(key).setValue(myJob).addOnCompleteListener(AddJobScreen.this, new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(AddJobScreen.this, "Add Successful", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(AddJobScreen.this, "Add Failed" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    task.getException().printStackTrace();
                }
            }

        });
    }
}







