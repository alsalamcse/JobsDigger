package com.example.jobsdigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import data.CustomerdetailsAdapter;
import data.MyCustomerdetails;

public class SeeCustomersScreen extends AppCompatActivity {

    private ListView listView;
    private CustomerdetailsAdapter customerdetailsAdapter;
    private ImageButton imgbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_customers_screen);


        imgbtn=findViewById(R.id.imgbtn);

        imgbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplication(),CustomerDetailsScreen.class);
                startActivity(intent);

            }
        });

        listView=findViewById(R.id.List);
        customerdetailsAdapter=new CustomerdetailsAdapter(getBaseContext(),R.layout.customer_details_item);


        listView.setAdapter(customerdetailsAdapter);

    }

    @Override
    public void onResume() {
        super.onResume();
        readTasksFromFirebase();
    }

    public void readTasksFromFirebase(){
        FirebaseDatabase database=FirebaseDatabase.getInstance();
        FirebaseAuth auth=FirebaseAuth.getInstance();
        String uid=auth.getUid();
        DatabaseReference reference=database.getReference();


        reference.child("CustomerDetails").child(uid).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
               customerdetailsAdapter.clear();
                for (DataSnapshot d:dataSnapshot.getChildren())
                {
                  MyCustomerdetails myCustomerdetails =d.getValue(MyCustomerdetails.class);
                    Log.d("MyCustomerdetails",myCustomerdetails.toString());
                    customerdetailsAdapter.add(myCustomerdetails);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



    }




}
