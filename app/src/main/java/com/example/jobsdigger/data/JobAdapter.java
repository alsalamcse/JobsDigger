package com.example.jobsdigger.data;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jobsdigger.R;
import com.example.jobsdigger.ui.main.AllCustomerdetails;
import com.example.jobsdigger.ui.main.SectionsPagerAdapter;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;

public class JobAdapter extends ArrayAdapter<MyJob>
{

 ViewPager viewPager;

    public JobAdapter(@NonNull Context context) {
        super(context, R.layout.jobsitem);
    }
    public View getView(int position, @Nullable View convertView, @NonNull final ViewGroup parent) {

        //building item view
        View vitem= LayoutInflater.from(getContext()).inflate(R.layout.jobsitem,parent,false);
        final TextView tvSubject=vitem.findViewById(R.id.tvSubject);
        TextView tvCompany=vitem.findViewById(R.id.tvCompany);
        TextView tvPlace=vitem.findViewById(R.id.tvPlace);
        TextView tvTerms=vitem.findViewById(R.id.tvTerms);
        final Button btnApply=vitem.findViewById(R.id.btnApplyJob);
        CheckBox cbIsDleted=vitem.findViewById(R.id.cbDeleted);

        btnApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TabHost tabHost = viewPager.findViewById(R.id.tabs);
                tabHost.setCurrentTab(1);

            }
        });

        final MyJob myJob = getItem(position);//getting com.example.jobsdigger.data source

        cbIsDleted.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    //todo delete this item
                    FirebaseUtils.getRefrence().child(myJob.getKey()).removeValue(new DatabaseReference.CompletionListener() {
                        @Override
                        public void onComplete(@Nullable DatabaseError databaseError, @NonNull DatabaseReference databaseReference) {
                            if(databaseError==null)
                            {
                                Toast.makeText(getContext(), "deleted", Toast.LENGTH_SHORT).show();

                            }
                            else {
                                Toast.makeText(getContext(), "not deleted:"+databaseError.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });


        //connect item view to com.example.jobsdigger.data source
        tvSubject.setText(myJob.getSubject());
        tvCompany.setText(myJob.getCompaney());
        tvPlace.setText(myJob.getPlace());
        tvTerms.setText(myJob.getTermsofAcceptanc());

        return vitem;

    }


}
