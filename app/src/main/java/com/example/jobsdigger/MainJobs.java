package com.example.jobsdigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.jobsdigger.ui.main.SectionsPagerAdapter;
import com.google.firebase.auth.OAuthProvider;
import com.google.firebase.database.util.GAuthToken;

public class MainJobs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_jobs2);
        final SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        final ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        final TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
        FloatingActionButton fab = findViewById(R.id.fab);

  //    if()
   //  {
    //      fab.setVisibility(View.GONE);

  //    }


            fab.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view) {
                    if(viewPager.getCurrentItem()==0)
                    {
                        Intent intent = new Intent(getApplication(), AddJobScreen.class);
                        startActivity(intent);
                    }
                    if(viewPager.getCurrentItem()==1)
                    {
                        Intent intent = new Intent(getApplication(), CustomerDetailsScreen.class);
                        startActivity(intent);

                    }


                }
            });



    }
}