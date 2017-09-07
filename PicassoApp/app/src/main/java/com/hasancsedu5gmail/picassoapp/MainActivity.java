package com.hasancsedu5gmail.picassoapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView = (ImageView) findViewById(R.id.iv_image);
        Picasso.with(this)
                .load("http://anantajalil.co/wp-content/uploads/2015/02/002.jpg")
                .into(imageView);



    }
}
