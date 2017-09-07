package com.hasancsedu5gmail.fragmentcommunicationinterface;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements ConnectorInterface{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState == null){

            attachDisplayFragment();
            attachButtonFragment();

        }





    }

    private void attachDisplayFragment(){

        Fragment displayFragment = new DisplayFragment();
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(
                R.id.layout_main_activity,
                displayFragment,
                "tag_display_fragment"
        );
        transaction.commit();



    }
    private void attachButtonFragment(){
        Fragment fragment = new ButtonFragment();
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(
                R.id.layout_main_activity,
                fragment,
                "tag_button_fragment");
        transaction.commit();



    }

    @Override
    public void clickProcessing(String data) {
        DisplayFragment displayFragment = (DisplayFragment)getFragmentManager().findFragmentByTag("tag_display_fragment");
        displayFragment.changeDisplayText(data);
    }
}
