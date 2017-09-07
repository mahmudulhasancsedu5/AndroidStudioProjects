package com.hasancsedu5gmail.gameofthronesbio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Scanner;

public class CastInfoActivity extends AppCompatActivity {

    private static final String TAG = CastInfoActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cast_info);


        Intent parentActivity = getIntent();
        String castName = parentActivity.getStringExtra("name");
        Log.v(TAG,"Get Name : "+castName);

        //set cast name
        TextView tvName = (TextView) findViewById(R.id.text_cast_name);
        tvName.setText(castName);

        //set cast image
        ImageView imageViewCast = (ImageView) findViewById(R.id.image_cast_image);

        String imageName = castName;
        imageName = "image_"+imageName.trim().toLowerCase().replace(" ","_");
        int imageId = getResources().getIdentifier(imageName,"drawable",getPackageName());

        imageViewCast.setImageResource(imageId);

        //set cast biography

        TextView tvBio = (TextView) findViewById(R.id.text_cast_biography);

        String bioTextFileName = castName;
        bioTextFileName = bioTextFileName.trim().toLowerCase().replace(" ","_");

        int bioID = getResources().getIdentifier(bioTextFileName,"raw",getPackageName());


        String bio="";
        Scanner scanner = new Scanner(getResources().openRawResource(bioID));

        try {

            while(scanner.hasNext()){

                String line = scanner.nextLine();
                bio+=line+"\n";


            }

        }catch (Exception e){

            Log.e(TAG,e.toString());
        }


        scanner.close();

        tvBio.setText(bio);





    }

    private void loadeImage(){


    }
}
