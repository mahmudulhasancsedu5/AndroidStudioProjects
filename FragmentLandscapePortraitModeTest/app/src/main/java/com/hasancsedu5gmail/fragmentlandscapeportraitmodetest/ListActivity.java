package com.hasancsedu5gmail.fragmentlandscapeportraitmodetest;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class ListActivity extends AppCompatActivity implements ListFragment.CommunicatorFragmentList {

    ListFragment listFragment;
    DetailsFragment detailsFragment;
    FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        fragmentManager = getFragmentManager();

        listFragment = (ListFragment) fragmentManager.findFragmentById(R.id.fragment_list_id);
        listFragment.setCommunicatorFragmentList(this);
    }

    @Override
    public void respond(int itemId,String itemName) {

        detailsFragment = (DetailsFragment) fragmentManager.findFragmentById(R.id.fragment_details_id);

        if(detailsFragment != null && detailsFragment.isVisible())
        {
            detailsFragment.setData(itemId,itemName);

        }else{

            Intent intent  = new Intent(this,DetailsActivity.class);
            intent.putExtra("itemId",itemId);
            intent.putExtra("itemName",itemName);
            startActivity(intent);
        }

    }
}
