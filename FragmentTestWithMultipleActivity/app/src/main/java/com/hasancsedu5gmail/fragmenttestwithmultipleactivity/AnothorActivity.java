package com.hasancsedu5gmail.fragmenttestwithmultipleactivity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class AnothorActivity extends AppCompatActivity {

    private int mIndex;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anothor);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        mIndex = bundle.getInt("index");


        DetailsFragment detailsFragment = new DetailsFragment();

        FragmentManager manager = getFragmentManager();

        FragmentTransaction transaction = manager.beginTransaction();

        transaction.add(R.id.layout_anothor_activity,detailsFragment,"tag_fragment_details");

        transaction.commit();

        detailsFragment.setDetails(mIndex);






    }
}
