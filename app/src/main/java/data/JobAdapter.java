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
import android.widget.Toast;

import com.example.jobsdigger.R;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;

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

        final MyJob myJob = getItem(position);//getting data source




                    FirebaseUtils.getReference().child(myJob.getKey()).removeValue(new DatabaseReference.CompletionListener() {
                        @Override
                        public void onComplete(@Nullable DatabaseError databaseError, @NonNull DatabaseReference databaseReference) {
                            if(databaseError==null)
                            {
                                Toast.makeText(getContext(), "deleted", Toast.LENGTH_SHORT).show();

                            }
                            else {
                                Toast.makeText(getContext(), "not deleted"+databaseError.getMessage(), Toast.LENGTH_SHORT).show();

                            }
                        }
                    });


        //connect item view to data source
        tvSubject.setText(myJob.getSubject());
        tvCompany.setText(myJob.getCompaney());
        tvPlace.setText(myJob.getPlace());
        tvTerms.setText(myJob.getTermsofAcceptanc());

        return vitem;
    }

}
