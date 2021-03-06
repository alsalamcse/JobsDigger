package com.example.jobsdigger.data;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jobsdigger.R;

public class CustomerdetailsAdapter extends ArrayAdapter<MyCustomerdetails>
{
    private Uri filePath;

        public CustomerdetailsAdapter(@NonNull Context context) {
            super(context, R.layout.customer_details_item);
        }




        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            //building item view
            View vitem= LayoutInflater.from(getContext()).inflate(R.layout.customer_details_item,parent,false);
            final TextView tvName=vitem.findViewById(R.id.tvFullname);
            final TextView tvphone=vitem.findViewById(R.id.tvphoneNumber);
            TextView tvAge=vitem.findViewById(R.id.tvAge);
            TextView tvHistory=vitem.findViewById(R.id.tvhistory);
            TextView tvSkills=vitem.findViewById(R.id.tvSkills);
            TextView tvlanguages=vitem.findViewById(R.id.tvlanguages);
            TextView tvinterships=vitem.findViewById(R.id.tvinterships);
            TextView tvcourses=vitem.findViewById(R.id.tvcourses);
            TextView tvId=vitem.findViewById(R.id.tvIDnumber);
            ImageButton imcall=vitem.findViewById(R.id.imcalls);




            final MyCustomerdetails myCustomerdetails = getItem(position);//getting com.example.jobsdigger.data source


            imcall.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    Intent callIntent =new Intent(Intent.ACTION_CALL);
                    callIntent.setType("phone/*");
                    callIntent.setData(Uri.parse(myCustomerdetails.getPhone()));

                    Toast.makeText(getContext(), "calling:"+myCustomerdetails.getPhone(), Toast.LENGTH_SHORT).show();
                }
            });



            tvName.setText(myCustomerdetails.getFullName());
            tvphone.setText(myCustomerdetails.getPhone());
            tvAge.setText(myCustomerdetails.getAge());
            tvHistory.setText(myCustomerdetails.getHistory());
            tvSkills.setText(myCustomerdetails.getSkills());
            tvlanguages.setText(myCustomerdetails.getLang());
            tvinterships.setText(myCustomerdetails.getInter());
            tvcourses.setText(myCustomerdetails.getCou());
            tvId.setText(myCustomerdetails.getIdnum());

            return vitem;
        }
}


