package com.hasancsedu5gmail.picassophotoapp;

import android.app.Activity;
import android.content.ContentResolver;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import static android.provider.Settings.Global.AIRPLANE_MODE_ON;


public class MainActivity extends Activity {

    private static final String DIR = "http://anantajalil.co/wp-content/uploads/2015/02/";
    String str="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




    }

    public void onClickMe(View view) {
        //download picture and dis
//        Picasso.with(context).load("http://i.imgur.com/DvpvklR.png").into(imageView);

        ImageView img = (ImageView)findViewById(R.id.image_view_image);
        //Picasso.with(this).load("http://i.imgur.com/DvpvklR.png").into(img);

        String path ="http://www.martystepp.com/dogs/barney-and-clyde-01-large.jpg";
        Picasso.with(this)
                .load(path)
                .placeholder(R.drawable.thumbnail_placeholder)
                .resize(200,200)
                .into(img);
    }

    static boolean isAirplaneModeOn(Activity context) {
        ContentResolver contentResolver = context.getContentResolver();
        return Settings.System.getInt(contentResolver, AIRPLANE_MODE_ON, 0) != 0;
    }




}
