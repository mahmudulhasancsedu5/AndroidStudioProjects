package com.hasancsedu5gmail.moviestarworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class ActorListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_actor_list);

        ImageView imageView = (ImageView) findViewById(R.id.image_picasso);

//        Picasso.with(context).load("http://i.imgur.com/DvpvklR.png").into(imageView);

        Picasso.with(this)
                .load("http://i.imgur.com/DvpvklR.png")
                .resize(100,100)
                .centerCrop()
                .into(imageView);





    }
}
