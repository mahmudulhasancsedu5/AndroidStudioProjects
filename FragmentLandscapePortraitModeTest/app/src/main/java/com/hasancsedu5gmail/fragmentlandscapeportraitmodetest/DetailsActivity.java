package com.hasancsedu5gmail.fragmentlandscapeportraitmodetest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class DetailsActivity extends AppCompatActivity {

    private static String mItemName;
    private static int mItemId;
    DetailsFragment detailsFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Intent intent = getIntent();
        mItemName = intent.getStringExtra("itemName");
        mItemId = intent.getIntExtra("itemId",0);

        detailsFragment = (DetailsFragment) getFragmentManager().findFragmentById(R.id.fragment_details_id);
        detailsFragment.setData(mItemId,mItemName);



    }


}
