package com.hasancsedu5gmail.fragmenttestoneactivitylandscapevsportrait;

import android.app.FragmentManager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements Communicator{

    private final String TAG = "MainActivity";
    FragmentManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.manager = getFragmentManager();




    }


    @Override
    public void passMessage(int index) {


        try{
            DetailsFragment detailsFragment = (DetailsFragment) this.manager.findFragmentById(R.id.fragment_id_details);

            detailsFragment.setName(index);

        }catch (NullPointerException e){

            Log.d(TAG,e.toString());

        }








    }
}
