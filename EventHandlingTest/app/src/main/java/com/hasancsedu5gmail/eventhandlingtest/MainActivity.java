package com.hasancsedu5gmail.eventhandlingtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android .widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        *
        *
        * ADDING EVENT LISTNER TO A BUTTON
        *
        * MULTIPLE EVENT:
        * 1 . CLICK
        * 2 . HOLD
        * 3 . RELEASE
        *
        *
        * */

        Button clickMeButton = (Button)findViewById(R.id.button);


        //---------CLICK EVENT-----
        clickMeButton.setOnClickListener(

                new Button.OnClickListener(){

                    public void onClick(View v){

                        TextView text = (TextView)findViewById(R.id.text);
                        text.setText("Hay, You have a New message.");

                    }

                }

        );

        // handle holding of a button for long time
        clickMeButton.setOnLongClickListener(
                //holding it down

                new View.OnLongClickListener(){

                    public boolean onLongClick(View v){

                        TextView textView = (TextView)findViewById(R.id.text);

                        textView.setText("Woo , You hava a realy big Message.");

                        // true holding the change
                        // false - return to previous result

                        return false;
                    }
                }


        );


        TextView textView = (TextView)findViewById(R.id.text);

        //------------------dont know hoe it work---------
        textView.setOnFocusChangeListener(

                new View.OnFocusChangeListener(){

                    @Override
                    public void onFocusChange(View view, boolean b) {

                        TextView textView = (TextView)findViewById(R.id.text);
                        textView.setText("Hay What are you thinking??");
                    }
                }


        );

        /*
        *
        *
        * ADDING EVENT LISTNER TO A BUTTON
        *
        * MULTIPLE EVENT:
        * 1 . CLICK
        * 2 . HOLD
        * 3 . RELEASE
        *
        *
        * */




    }
}
