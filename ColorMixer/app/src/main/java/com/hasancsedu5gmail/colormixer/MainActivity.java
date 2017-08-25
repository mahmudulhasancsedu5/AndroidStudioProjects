package com.hasancsedu5gmail.colormixer;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import android.graphics.Color;
import android.widget.Button;
import android.widget.TextView;
import android.R.color;

public class MainActivity extends AppCompatActivity {



    private static TextView display;

    private static boolean color_flag[] = new boolean[7];

    private  static String color_id[] = new String[7];

    private float RED=0;
    private float GRE=0;
    private float BLU=0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.color_mixer);




        color_id[0]="0x01060017";
        color_id[1]="0x01060019";
        color_id[2]="0x01060018";
        color_id[3]="0x01060014";
        color_id[4]="0x01060015";
        color_id[5]="0x01060013";
        color_id[6]="0x0106001a";



        display = (TextView)findViewById(R.id.display);



    }



    public void redButtonClick(View view) {

        Button button=(Button) findViewById(R.id.red_button);
        Button flagButton = (Button) findViewById(R.id.red_flag);

        if(color_flag[0])
        {
            color_flag[0]=false;
            flagButton.setBackgroundColor(Color.GREEN);


        }
        else
        {
           // color_flag[0]=true;
            //flagButton.setBackgroundColor(Color.parseColor(color_id[0]));

        }

    }

    public void orangeButtonClick(View view) {

        Button button=(Button) findViewById(R.id.orange_button);
        Button flagButton = (Button) findViewById(R.id.orange_flag);
        if(color_flag[1])
        {
            color_flag[1]=false;
        }
        else
        {
            color_flag[1]=true;
            flagButton.setBackgroundColor(Color.parseColor(color_id[1]));
        }

    }

    public void yellowButtonClick(View view) {

        Button button=(Button) findViewById(R.id.yellow_button);
        Button flagButton = (Button) findViewById(R.id.yellow_flag);

        if(color_flag[2])
        {
            color_flag[2]=false;
        }
        else
        {
            color_flag[2]=true;
            flagButton.setBackgroundColor(Color.parseColor(color_id[2]));

        }

    }

    public void greenButtonClick(View view) {

        Button button=(Button) findViewById(R.id.green_button);
        Button flagButton = (Button) findViewById(R.id.green_flag);

        if(color_flag[3])
        {
            color_flag[3]=false;
        }
        else
        {
            color_flag[3]=true;
            flagButton.setBackgroundColor(Color.parseColor(color_id[3]));

        }

    }

    public void blueButtonClick(View view) {

        Button button=(Button) findViewById(R.id.blue_button);
        Button flagButton = (Button) findViewById(R.id.blue_flag);
        if(color_flag[4])
        {
            color_flag[4]=false;
        }
        else
        {
            color_flag[4]=true;
            flagButton.setBackgroundColor(Color.parseColor(color_id[4]));
        }

    }

    public void indigoButtonClick(View view) {

        Button button=(Button) findViewById(R.id.indigo_button);
        Button flagButton = (Button) findViewById(R.id.indigo_flag);
        if(color_flag[5])
        {
            color_flag[5]=false;
        }
        else
        {
            color_flag[5]=true;
            flagButton.setBackgroundColor(Color.parseColor(color_id[5]));

        }

    }

    public void violateButtonClick(View view) {

        Button button=(Button) findViewById(R.id.violate_button);
        Button flagButton = (Button) findViewById(R.id.violate_flag);
        if(color_flag[6])
        {
            color_flag[6]=false;
        }
        else
        {
            color_flag[6]=true;
            flagButton.setBackgroundColor(Color.parseColor(color_id[6]));

        }

    }
}
