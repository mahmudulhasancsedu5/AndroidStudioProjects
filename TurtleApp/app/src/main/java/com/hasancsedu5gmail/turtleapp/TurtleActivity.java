package com.hasancsedu5gmail.turtleapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import stanford.androidlib.SimpleActivity;

public class TurtleActivity extends SimpleActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_turtle);
    }

    public void radioClick(View view) {

        ImageView imgDisplay = (ImageView) findViewById(R.id.turtle_image);
        int id = view.getId();

        if( id == R.id.leo_button ){

            imgDisplay.setImageResource(R.drawable.turtle1);
        }
        else if(id == R.id.mike_button){

            imgDisplay.setImageResource(R.drawable.turtle2);
        }
        else if( id == R.id.don_button ){

            imgDisplay.setImageResource(R.drawable.turtle3);

        }
        else if( id == R.id.rap_button ){
            imgDisplay.setImageResource(R.drawable.turtle4);
        }
        else{

        }
    }
}
