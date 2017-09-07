package com.hasancsedu5gmail.fragmenttestwithmultipleactivity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements MenuFragment.ConnectorMenu {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        MenuFragment menuFragment = new MenuFragment();



            FragmentManager manager = getFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.add(R.id.layout_id_main_activity,menuFragment,"tag_menu");
            transaction.commit();

        //attachFragmentDetails(R.id.layout_id_main_activity);

        try {

            menuFragment.setConnectorMenu(this);


        }catch (NullPointerException e){

            Log.d(TAG,"MenuFragment referance is null.\n");

        }



    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }


    private void attachFragmentMenu(){

        MenuFragment menuFragment = new MenuFragment();
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        transaction.add(R.id.layout_id_main_activity,menuFragment,"tag_menu_fragment");

        transaction.commit();


    }




    private void attachFragmentDetails(int container_activity){

        DetailsFragment detailsFragment = new DetailsFragment();
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();


        transaction.add(container_activity,detailsFragment,"tag_fragment_details");

        transaction.commit();
    }

    @Override
    public void getMenuData(int index) {



        Log.d(TAG,"Connector Works well "+index+" \n");

        Intent intent = new Intent(this,AnothorActivity.class);
        intent.putExtra("index",index);
        startActivity(intent);


    }

}
