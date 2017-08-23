package com.hasancsedu5gmail.gridlayouttestcalculatorui;

import android.content.Context;
import android.os.TestLooperManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.graphics.Color;
import android.util.Log;
import android.widget.TextView;

import java.math.BigInteger;

class MyOnClickListner implements View.OnClickListener {

    char ch;
    MyOnClickListner( char ch){

        this.ch=ch;
    }

    @Override
    public void onClick(View view){

        //this.textView.append(new String(String.valueOf(this.ch)));


    }

}
public class MainActivity extends AppCompatActivity {


    String operent1=null,operent2=null,operation=null;

    private static void addButtonListner(Button btn)
    {

    }



    private static final String MyTag="Mahmud";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final TextView textView =(TextView)findViewById(R.id.display);
        //InputMethodManager im = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        //im.hideSoftInputFromWindow(textView.getWindowToken(), 0);

        Log.i(MyTag,"on create");

        final Button plusButton = (Button)findViewById(R.id.plusButton);
        final Button minusButton = (Button)findViewById(R.id.minusButton);
        final Button divideButton = (Button)findViewById(R.id.divideButton);
        final Button multiplyButton = (Button)findViewById(R.id.multiplyButton);
        final Button modeButton = (Button)findViewById(R.id.modeButton);
        final Button ansButton = (Button)findViewById(R.id.ansButton);
        final Button zeroButton = (Button)findViewById(R.id.button0);
        final Button oneButton = (Button)findViewById(R.id.button1);
        final Button twoButton = (Button)findViewById(R.id.button2);
        final Button threeButton = (Button)findViewById(R.id.button3);
        final Button fourButton = (Button)findViewById(R.id.button4);
        final Button fiveButton = (Button)findViewById(R.id.button5);
        final Button sixButton = (Button)findViewById(R.id.button6);
        final Button sevenButton = (Button)findViewById(R.id.button7);
        final Button eightButton = (Button)findViewById(R.id.button8);
        final Button nineButton = (Button)findViewById(R.id.button9);

        final Button[] buttonList=
                {
                        plusButton,minusButton,divideButton,
                        multiplyButton,modeButton,ansButton,
                        zeroButton,oneButton,twoButton,
                        threeButton,fourButton,fiveButton,
                        sixButton,sevenButton,eightButton,nineButton
                };

        final char[] buttonText={'+','-','/','x','%','=','0','1','2','3','4','5','6','7','8','9'};

        //--------------------add button action listner-----------

        plusButton.setOnClickListener(new View.OnClickListener(){

            public void onClick(View V){

                //System.out.println("Plus Button was Pressed.");
                //Log.i(MyTag, "Plus was pressed");
                plusButton.setBackgroundColor(Color.GREEN);
                textView.append("+");
            }

        });

        int numberOfButton = buttonList.length;

        for(int i=0;i<numberOfButton;i++)
        {
            buttonList[i].setOnClickListener(

                    new MyOnClickListner(buttonText[i]){
                        public void onClick(View v){

                            textView.append(new String(String.valueOf(this.ch)));
                            Log.i(MyTag," Pressing button : "+this.ch);
                        }

                    }
            );

        }



    }
}
