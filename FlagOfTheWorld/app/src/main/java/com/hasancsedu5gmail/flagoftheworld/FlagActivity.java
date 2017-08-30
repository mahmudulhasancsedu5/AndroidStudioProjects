package com.hasancsedu5gmail.flagoftheworld;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import stanford.androidlib.SimpleActivity;

public class FlagActivity extends SimpleActivity {


    private  static final String TAG = FlagActivity.class.getSimpleName();

    private static String[] COUNTRIES = {
                    "afghanistan",
                    "armenia",
                    "bahamas",
                    "belarus",
                    "ethiopia",
                    "mexico",
                    "vancouver",
                    "australia",
                    "azerbaijan",
                    "belgium",
                    "cuba",
                    "ireland",
                    "malaysia",
                    "united_kingdom"
    };

    //instance initializer
    {
        setTraceLifecycle(true);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flag);


        //add a new button dynamically to the screen
//        Button button = new Button(this);
//        button.setText("Dynamic Button");
//
//        ViewGroup.LayoutParams button_params = new ViewGroup.LayoutParams(
//
//                ViewGroup.LayoutParams.WRAP_CONTENT,
//                ViewGroup.LayoutParams.WRAP_CONTENT
//        );
//        button.setLayoutParams(button_params);



        LinearLayout layout = (LinearLayout)findViewById(R.id.layout_activityFlags);

        for(String countrynName : COUNTRIES){

            addFlag(countrynName,layout);

        }





    }

    private void addFlag(final String countryName,LinearLayout layout){


        View layoutFlag = getLayoutInflater()
                .inflate(R.layout.flag,/* parent*/null);

//        findViewById(R.id.text_view_country_name); //asking the whole activity
        TextView tvCountryName = (TextView)layoutFlag.findViewById(R.id.text_view_country_name);
        tvCountryName.setText(countryName);
        ImageButton imageButton = (ImageButton) layoutFlag.findViewById(R.id.image_view_flag);

        imageButton.setOnClickListener(
                new View.OnClickListener(){

                    @Override
                    public void onClick(View view) {

//                        Toast.makeText(FlagActivity.this,
//                                "You had clicked on the flag of "+countryName,
//                                Toast.LENGTH_SHORT).show();

                        AlertDialog.Builder builder = new AlertDialog.Builder(FlagActivity.this);
                        builder.setTitle("Country Message");
                        builder.setMessage("You clicked on the flag of "+countryName);

                        //----------------

                        builder.setPositiveButton("ok",

                                new DialogInterface.OnClickListener(){

                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {

                                        Toast.makeText(FlagActivity.this,
                                                "You clicked ok.",
                                                Toast.LENGTH_SHORT).show();

                                    }
                                }


                                );

                        //--------------

                        AlertDialog dialog = builder.create();
                        dialog.show();

                    }
                }


        );

        String countryName2 = countryName.replace(" ","");
        countryName2 = "image_"+countryName2;

        Log.d(TAG,countryName);
        int flagImageId = getResources().getIdentifier(countryName2,"drawable",getPackageName());
        imageButton.setImageResource(flagImageId);

        layout.addView(layoutFlag);



    }
}
