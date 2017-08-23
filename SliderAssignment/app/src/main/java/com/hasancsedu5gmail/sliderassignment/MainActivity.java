package com.hasancsedu5gmail.sliderassignment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;

import android.view.MotionEvent;
import android.view.GestureDetector;
import android.support.v4.view.GestureDetectorCompat;


public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener,
        GestureDetector.OnDoubleTapListener{


    private static  final String TAG="SliderAssignment :";
    private Button clickButton;
    private TextView displayText;


    private GestureDetectorCompat gestureDetector;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //-----------------button and textView references--------------

        clickButton = (Button)findViewById(R.id.clickButton);
        displayText = (TextView)findViewById(R.id.displayText);


        //------------add clickEventListner to the button-------------------

        clickButton.setOnClickListener(

                new View.OnClickListener(){

                    public void onClick(View view){

                        displayText.setText("Button was Clicked !!");


                    }

                }
        );

        clickButton.setOnLongClickListener(
                new View.OnLongClickListener(){
                    public boolean onLongClick(View v){

                        displayText.setText("Button was Pressed for a Long Period.");
                        return true;
                    }

                }


        );
        //------------------------------------------------------------------------

        //-------------------add Gesture to the main display-------------------------------

        this.gestureDetector = new GestureDetectorCompat(this,this);
        this.gestureDetector.setOnDoubleTapListener(this);







        //-------------------------------------------------------------------

        Log.i(TAG,"onCreate");
    }

    ///-----------------GESTURE METHOD-------------

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        this.gestureDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {

        this.displayText.setText("onSingleTap");
        return true;
    }

    @Override
    public boolean onDoubleTap(MotionEvent motionEvent) {

        this.displayText.setText("onDoubleTap");
        return true;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {

        this.displayText.setText("onDoubleTapEvent");
        return true;
    }

    @Override
    public boolean onDown(MotionEvent motionEvent) {

        this.displayText.setText("onDown");
        return true;
    }

    @Override
    public void onShowPress(MotionEvent motionEvent) {

        this.displayText.setText("onShowPress");

    }

    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        this.displayText.setText("onSingleTapUp");
        return true;
    }

    @Override
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {

        this.displayText.setText("onScroll");
        return true;
    }

    @Override
    public void onLongPress(MotionEvent motionEvent) {
        this.displayText.setText("onLongPress");
    }


    @Override
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {

        this.displayText.setText("onFling");
        return true;
    }
}
