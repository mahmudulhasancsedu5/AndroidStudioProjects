package com.hasancsedu5gmail.ionlibrary;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG =MainActivity.class.getSimpleName();
    private static final String RESOURCE_DIR = "http://www.martystepp.com/dogs/";
    private static final String NAME_CONTAINER = "files.txt";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        downloadImageNameAndAddToSpinner(NAME_CONTAINER);

        Spinner spinner = (Spinner) findViewById(R.id.spinner_image_name);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // your code here

//                String imageName;
//                imageName = parentView.getSelectedItem().toString();
//                spinnerImageLoader(imageName);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });






    }



    private void downloadImageNameAndAddToSpinner(String name){


        Ion.with(this)
                .load(RESOURCE_DIR+name)
                .asString()
                .setCallback(new FutureCallback<String>() {
                    @Override
                    public void onCompleted(Exception e, String result) {

                        Log.v(TAG,result);


                        String[] res = result.split("\n");
                        List<String> list = Arrays.asList(res);

                        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                                MainActivity.this,
                                android.R.layout.simple_list_item_1,
                                list);

                        Spinner spinner = (Spinner) findViewById(R.id.spinner_image_name);
                        spinner.setAdapter(adapter);
                    }
                });




    }




    public void onClickLoadImage(View view) {
        ImageView imageView = (ImageView) findViewById(R.id.image_view_image);
        String imageName;
        Spinner spinner = (Spinner) findViewById(R.id.spinner_image_name);
        imageName = spinner.getSelectedItem().toString();
        spinnerImageLoader(imageName);

    }



    public void spinnerImageLoader(String imageName) {

        // This is the "long" way to do build an ImageView request... it allows you to set headers, etc.
//        Ion.with(context)
//                .load("http://example.com/image.png")
//                .withBitmap()
//                .placeholder(R.drawable.placeholder_image)
//                .error(R.drawable.error_image)
//                .animateLoad(spinAnimation)
//                .animateIn(fadeInAnimation)

        ImageView imageView = (ImageView) findViewById(R.id.image_view_image);
        String path = RESOURCE_DIR+imageName;

        Ion.with(this)
                .load(path)
                .withBitmap()
                .placeholder(R.drawable.placeholder_image)
                .error(R.drawable.error_image)
                .intoImageView(imageView);


    }
}


