package data;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.jobsdigger.R;

public class JobAdapter extends ArrayAdapter<MyJob>
{

    public JobAdapter(@NonNull Context context) {
        super(context, R.layout.jobsitem);
    }
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        //building item view
        View vitem= LayoutInflater.from(getContext()).inflate(R.layout.jobsitem,parent,false);
        final TextView tvSubject=vitem.findViewById(R.id.tvSubject);
        TextView tvCompany=vitem.findViewById(R.id.tvCompany);
        TextView tvPlace=vitem.findViewById(R.id.tvPlace);
        TextView tvTerms=vitem.findViewById(R.id.tvTerms);
        Button btnApply=vitem.findViewById(R.id.btnApplyJob);

        btnApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        final MyJob myJob = getItem(position);



        //connect item view to data source
        tvSubject.setText(myJob.getSubject());
        tvCompany.setText(myJob.getCompaney());
        tvPlace.setText(myJob.getPlace());
        tvTerms.setText(myJob.getTermsofAcceptanc());

        return vitem;
    }

}
