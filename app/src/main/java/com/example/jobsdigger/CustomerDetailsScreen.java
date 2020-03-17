package com.example.jobsdigger;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.IOException;
import java.util.UUID;

import data.MyCustomerdetails;

public class CustomerDetailsScreen extends AppCompatActivity {
    private EditText  ethistory, etage, etSkills, etlang, etinter, etIDnumber, etcourses,etph,etfullname;
    private Button btnSave;

    private ImageButton imgBtnl;
    private Button btnUpload;
    private TextView tvImgUrl;
    private Uri filePath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_details_screen);

        imgBtnl=findViewById(R.id.imgBtnl);
        btnUpload=findViewById(R.id.btnUpload);
        tvImgUrl=findViewById(R.id.tvImgUrl);
        etph=findViewById(R.id.etph);
        etfullname=findViewById(R.id.etfullname);
        etage = findViewById(R.id.etage);
        ethistory = findViewById(R.id.ethistory);
        etSkills = findViewById(R.id.etSkills);
        etlang = findViewById(R.id.etlang);
        etinter = findViewById(R.id.etinter);
        etcourses = findViewById(R.id.etcourses);
        etIDnumber = findViewById(R.id.etIDnumber);
        btnSave = findViewById(R.id.btnSave);


        imgBtnl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("file/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent,
                        "Select File"), 99);
            }
        });
        btnUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uploadFile();
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataHandler();
            }
        });
    }
    private void uploadFile() {

        if(filePath != null)
        {
            final ProgressDialog progressDialog = new ProgressDialog(this);
            progressDialog.setTitle("Uploading...");
            progressDialog.show();
            FirebaseStorage storage= FirebaseStorage.getInstance();
            StorageReference storageReference = storage.getReference();
            StorageReference ref = storageReference.child("files/"+ UUID.randomUUID().toString());
            ref.putFile(filePath)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            progressDialog.dismiss();
                            Toast.makeText(getApplicationContext(), "Uploaded", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            progressDialog.dismiss();
                            Toast.makeText(getApplicationContext(), "Failed "+e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    })
                    .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                            double progress = (100.0*taskSnapshot.getBytesTransferred()/taskSnapshot
                                    .getTotalByteCount());
                            progressDialog.setMessage("Uploaded "+(int)progress+"%");
                        }
                    });
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 99 && resultCode == RESULT_OK
                && data != null && data.getData() != null )
        {
            filePath = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filePath);
                imgBtnl.setImageBitmap(bitmap);
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    private void dataHandler() {
        boolean isok = true;
       String fullname=etfullname.getText().toString();
        String phoneNumber=etph.getText().toString();
        String Age = etage.getText().toString();
        String EmploymentHistory = ethistory.getText().toString();
        String Skills = etSkills.getText().toString();
        String language = etlang.getText().toString();
        String interships = etinter.getText().toString();
        String courses = etcourses.getText().toString();
        String IDnumber = etIDnumber.getText().toString();

        if (fullname.length()==0)
        {
            etfullname.setError("Enter FullName");
            isok=false;
        }

        if (phoneNumber.length()<10) {
            etph.setError("Have to be at least 10 nums");
            isok = false;
        }
        if (EmploymentHistory.length() == 0) {
            ethistory.setError("Enter EmploymentHistory");
            isok = false;
        }
        if (Skills.length() == 0) {
            etSkills.setError("Enter Sills");
            isok = false;
        }
        if (language.length() == 0) {
            etlang.setError("Enter Language");
            isok = false;
        }
        if (interships.length() == 0) {
            etinter.setError("Enter interships");
            isok = false;
        }

        if (courses.length() == 0) {
            etcourses.setError("Enter courses");
            isok = false;
        }
        if (IDnumber.length() == 0) {
            etIDnumber.setError("Enter ID Number");
            isok = false;

        }

        if (isok) {
            MyCustomerdetails myCustomerdetails = new MyCustomerdetails();
            myCustomerdetails.setAge(Age);
            myCustomerdetails.setHistory(EmploymentHistory);
            myCustomerdetails.setSkills(Skills);
            myCustomerdetails.setLang(language);
            myCustomerdetails.setInter(interships);
            myCustomerdetails.setCou(courses);
            myCustomerdetails.setIdnum(IDnumber);
            myCustomerdetails.setFullName(fullname);
            myCustomerdetails.setPhone(phoneNumber);
            createMyCustomerdetails(myCustomerdetails);
        }

    }

    private void createMyCustomerdetails(MyCustomerdetails myCustomerdetails) {
        //.1
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        //.2-save in database
        DatabaseReference reference = firebaseDatabase.getReference();//make a barameter ( with var)
        FirebaseAuth auth = FirebaseAuth.getInstance();//to get the user uid or details like email
        String uid = auth.getCurrentUser().getUid();
        myCustomerdetails.setOwner(uid);

        String Key = reference.child("CustomerDetails").push().getKey();
        myCustomerdetails.setKey(Key);
        reference.child("CustomerDetails").child(uid).child(Key).setValue(myCustomerdetails).addOnCompleteListener(CustomerDetailsScreen.this, new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Intent intent=new Intent(getApplication(),MainJobs.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(CustomerDetailsScreen.this, "Add Failed" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    task.getException().printStackTrace();
                }
            }

        });
    }
}














