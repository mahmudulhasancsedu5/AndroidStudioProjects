package com.hasancsedu5gmail.gestureswipe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.TextView;
import android.view.MotionEvent;
import android.view.GestureDetector;
import android.support.v4.view.GestureDetectorCompat;

public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener,GestureDetector.OnDoubleTapListener{


    private TextView textMessage;
    private GestureDetector gestureDetector;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textMessage = (TextView)findViewById(R.id.text);
        this.gestureDetector = new GestureDetector(this,this);

        gestureDetector.setOnDoubleTapListener(this);


    }


    //---------------------Begin Gesture-------------------

    @Override
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {

        textMessage.setText("onSingleTap");

        return true;
    }

    @Override
    public boolean onDoubleTap(MotionEvent motionEvent) {
        textMessage.setText("onDoubleTap");
        return true;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {

        textMessage.setText("onSingleTapEvent");
        return true;
    }

    @Override
    public boolean onDown(MotionEvent motionEvent) {

        textMessage.setText("onDown");
        return true;
    }

    @Override
    public void onShowPress(MotionEvent motionEvent) {

        textMessage.setText("onShowPress");
    }

    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {


        textMessage.setText("onSingleTapUp");

        return true;
    }

    @Override
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {

        textMessage.setText("onScroll");
        return true;
    }

    @Override
    public void onLongPress(MotionEvent motionEvent) {

        textMessage.setText("onLongPress");
    }

    @Override
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {

        textMessage.setText("onFling");

        return true;
    }

    //--------Gesture end-----------------


    @Override
    public boolean onTouchEvent(MotionEvent event) {

        this.gestureDetector.onTouchEvent(event);

        return super.onTouchEvent(event);
    }
}

