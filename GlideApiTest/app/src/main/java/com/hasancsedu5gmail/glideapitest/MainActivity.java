package com.hasancsedu5gmail.glideapitest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import jp.wasabeef.glide.transformations.CropCircleTransformation;
import jp.wasabeef.glide.transformations.CropSquareTransformation;

public class MainActivity extends AppCompatActivity {

    private static final String IMG_URL = "https://image.tmdb.org/t/p/original/neWvvnFVWVWmo7bXsUdrbvJIFHF.jpg";
    @BindView(R.id.button_clicked)Button button;
    @BindView(R.id.text_heading)TextView heading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        heading.setText("ButterKnife");
        ImageView imageView = (ImageView) findViewById(R.id.image_view_cast);





        loadCenterCrop(IMG_URL,imageView);
    }
    @OnClick(R.id.button_clicked)
    public void onCLickButton(Button button) {
        // TODO submit data to server...

        button.setText("ButterKnife Changed");
        Toast.makeText(this,"ButtonClicked",Toast.LENGTH_SHORT).show();
        Log.d("Button log "," Button Clicked");
    }

    private void loadeBasicImage(String url, ImageView imageView){


        Glide.with(this)
                .load(url)
                .into(imageView);

    }
    private void loadCenterCrop(String url, ImageView imageView){


        Glide.with(this)
                .load(url)
                .override(200,200)
                .fitCenter()
                .bitmapTransform(new CropCircleTransformation(this))
                .into(imageView);

    }
    private void loadSquareCrop(String url, ImageView imageView){


        Glide.with(this)
                .load(url)
                .override(200,200)
                .fitCenter()
                .bitmapTransform(new CropSquareTransformation(this))
                .into(imageView);

    }

    private void loadCenterCropAddBar(String url, ImageView imageView){


        Glide.with(this)
                .load(url)
                .override(200,200)
                .fitCenter()
                .bitmapTransform(new CropCircleTransformation(this))
                .into(imageView);

    }


}
