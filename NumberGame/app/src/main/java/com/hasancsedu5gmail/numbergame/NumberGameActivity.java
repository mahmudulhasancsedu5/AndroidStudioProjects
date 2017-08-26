package com.hasancsedu5gmail.numbergame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class NumberGameActivity extends AppCompatActivity {




    private static Button btn_no;
    private  static Button btn_yes;
    private  static TextView text_top;
    private  static TextView text_steps;
    private static boolean hasPressedYesButton;

    private static int numberLeft;
    private static int numberRight;
    private static int numberMid ;
    private static int stepsNumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number_game);

        text_top = (TextView)findViewById(R.id.text_view);

        text_steps =(TextView)findViewById(R.id.text_steps);

        restartGame();

    }

    public void restartGame(){

        hasPressedYesButton = false;
        stepsNumber=1;
        numberLeft = 1;
        numberRight = 1000;
        numberMid = (numberLeft+numberRight+1)/2;
        text_top.setText(getResources().getString(R.string.text));
        text_steps.setText("");



    }


    public void noButtonClick(View view) {

        if(hasPressedYesButton == false)
        {
            Toast.makeText(this,"Guess a number and press yes",Toast.LENGTH_LONG).show();

        }else{

            text_steps.setText("Steps : "+stepsNumber);

            int temp = numberMid;
            numberLeft =numberMid;

            numberMid = (numberLeft+numberRight+1)/2;



            if(numberLeft<numberRight)
            {
                text_top.setText("Is your guess is less than "+numberMid);
                //text_top.append(" "+numberLeft+" "+numberRight);
            }
            else{

                Toast.makeText(this,"Your Guess is : "+numberMid,Toast.LENGTH_LONG).show();
                restartGame();

            }



        }




    }

    public void yesButonClick(View view) {

        int temp = numberMid;
        text_steps.setText("Steps : "+stepsNumber);

        if(hasPressedYesButton == false){

            hasPressedYesButton = true;
            text_top.setText("Is your guess is less than "+numberMid);
        }
        else
        {
            numberRight = numberMid-1;
            numberMid = (numberLeft+numberRight+1)/2;

            if(numberLeft<numberRight)
            {
                text_top.setText("Is your guess is less than "+numberMid);
                //text_top.append(" "+numberLeft+" "+numberRight);
            }
            else{

                Toast.makeText(this,"Your Guess is : "+numberMid,Toast.LENGTH_LONG).show();
                restartGame();

            }





        }



    }
}
