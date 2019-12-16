package data;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.ArrayAdapter;

import com.example.jobsdigger.R;

public class JobAdapter extends ArrayAdapter<MyJob>
{

    public JobAdapter(@NonNull Context context) {
        super(context, R.layout.jobsitem);
    }
}
