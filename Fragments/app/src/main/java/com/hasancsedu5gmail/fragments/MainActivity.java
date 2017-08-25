package com.hasancsedu5gmail.fragments;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements TopSectionFregment.TopSectionListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    //this get called by the top Fragment when the user clicks the button
    @Override
    public void createMeme(String top, String bottom) {


        bottomPictureFragment bottoFragment =
                (bottomPictureFragment) getSupportFragmentManager().findFragmentById(R.id.fragment5);

        bottoFragment.setText(top,bottom);

    }



}
