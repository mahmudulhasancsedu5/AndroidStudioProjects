package com.hasancsedu5gmail.graphics2d;

import android.content.Context;
import android.graphics.Paint;
import android.util.AttributeSet;

import stanford.androidlib.graphics.GCanvas;
import stanford.androidlib.graphics.GOval;

/**
 * Created by mahmud on 9/8/2017.
 */

public class BouncingBallView extends GCanvas {
    private static final float BALL_RADIOYS = 100;
    private static final float BALL_MAX_VELOCITY = 5;
    GOval oval;
    float dx = 5;
    float dy = 10;

    public BouncingBallView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void init() {

//        oval = new GOval(50,80,100,100);
//
//        Paint col = new Paint();
//        col.setARGB(255,255,80,255);
//        col.setStyle(Paint.Style.FILL_AND_STROKE);
//        oval.setColor(col);
//        oval.setFillColor(col);
//        this.add(oval);
//        animate(50);

        drawOval();
//        drawOval();


    }


    public void drawOval(){

        oval = new GOval(50,80,100,100);

        Paint col = new Paint();
        col.setARGB(255,255,80,255);
        col.setStyle(Paint.Style.FILL_AND_STROKE);
        oval.setColor(col);
        oval.setFillColor(col);
        this.add(oval);
        animate(50);


    }

    @Override
    public void onAnimateTick() {
        super.onAnimateTick();
        oval.moveBy(dx,dy);
        if(oval.getRightX()>this.getWidth()){
            dx=-5;
        }
        else if(oval.getLeftX()<10){
            dx=5;

        }

        if(oval.getBottomY()>this.getHeight()){
            dy = -5;
        }
        else if(oval.getTopY()<10){
            dy = 5;
        }
    }
}
