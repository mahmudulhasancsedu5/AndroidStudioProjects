package com.hasancsedu5gmail.fragmentxmlconnection;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int mClickCount = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fragment newFragment = new FragmentB();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.layout_main,newFragment,"tag_fragment_b");

        fragmentTransaction.commit();




    }

    public void changeFragmentText(View view) {

        mClickCount++;
        TextView tvFragmentText = (TextView) findViewById(R.id.text_fragment_a);
        tvFragmentText.setText("Fragment Text Changes "+mClickCount + " times.");


    }
}
