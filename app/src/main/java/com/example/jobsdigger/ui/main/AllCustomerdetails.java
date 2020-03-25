package com.example.jobsdigger.ui.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.jobsdigger.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import com.example.jobsdigger.data.CustomerdetailsAdapter;
import com.example.jobsdigger.data.MyCustomerdetails;


public class AllCustomerdetails extends Fragment {

    private CustomerdetailsAdapter customerdetailsAdapter;
    private ListView listview;

    private EditText etTitleTosearch;
    private ImageButton imSearch;


    public AllCustomerdetails() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        customerdetailsAdapter = new CustomerdetailsAdapter(getContext());


        View view = inflater.inflate(R.layout.fragment_all_customerdetails, container, false);
        listview = view.findViewById(R.id.listview);
        listview.setAdapter(customerdetailsAdapter);

        imSearch=view.findViewById(R.id.imSearch);
        etTitleTosearch=view.findViewById(R.id.etTitleTosearch);

        imSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String toSearch=etTitleTosearch.getText().toString();
                readTasksFromFirebase(toSearch);
            }
        });

        return view;

    }

    @Override
    public void onResume() {
        super.onResume();
        readTasksFromFirebase("");
    }


    public void readTasksFromFirebase(final String st) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        FirebaseAuth auth = FirebaseAuth.getInstance();
        String uid = auth.getUid();
        DatabaseReference reference = database.getReference();


        reference.child("CustomerDetails").child(uid).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                customerdetailsAdapter.clear();
                for (DataSnapshot d : dataSnapshot.getChildren()) {
                    MyCustomerdetails myCustomerdetails = d.getValue(MyCustomerdetails.class);
                    Log.d("MyCustomerdetails", myCustomerdetails.toString());
                    if (st==null || st.length()==0)
                    {
                        customerdetailsAdapter.add(myCustomerdetails);
                    }
                    else
                    if (myCustomerdetails.getSkills().contains(st))
                        customerdetailsAdapter.add(myCustomerdetails);


                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }

}


