package com.hasancsedu5gmail.gameofthronesbio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class CastDetailsActivity extends AppCompatActivity {

    public static String mPersonId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cast_details);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        mPersonId = bundle.getString("id");

    }

    public static String getId(){

        return mPersonId.toString();

    }
}
