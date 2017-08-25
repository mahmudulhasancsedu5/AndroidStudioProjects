package com.hasancsedu5gmail.stanfordlecture1biggernumberapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {



    private Button leftButton;
    private Button rightButton;

    private int numOne;
    private int numTwo;
    private int points=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        pickRandomNumber();
    }

    private void pickRandomNumber() {

        //pick random numbers

        Random rand = new Random();
        numOne =rand.nextInt(10);

        while(true) {


            numTwo = rand.nextInt(10);
            if(numTwo != numOne) break;
        }
        leftButton = (Button)findViewById(R.id.left_button);
        rightButton = (Button)findViewById(R.id.right_button);

        leftButton.setText(Integer.toString(numOne));
        rightButton.setText(Integer.toString(numTwo));


    }

    public void leftButtonClick(View view) {

        if(numOne >= numTwo)
        {
            //correct
            points++;

            Toast.makeText(this, "Good Job!", Toast.LENGTH_SHORT).show();
        }
        else
        {
            //wrong
            points--;
            Toast.makeText(this, "Try Harder!", Toast.LENGTH_SHORT).show();
        }

        //update points display
        TextView bottomText = (TextView)findViewById(R.id.bottomText);
        bottomText.setText("Points : "+points);

        //take new random numbers

        pickRandomNumber();




    }

    public void rightButtonClick(View view) {


        if(numOne <= numTwo)
        {
            //correct
            points++;
            Toast.makeText(this, "Good Job!", Toast.LENGTH_SHORT).show();
        }
        else
        {
            //wrong
            points--;
            Toast.makeText(this, "Try Harder!", Toast.LENGTH_SHORT).show();
        }

        //update points display
        TextView bottomText = (TextView)findViewById(R.id.bottomText);
        bottomText.setText("Points : "+points);

        pickRandomNumber();

    }
}
