package com.hasancsedu5gmail.graphics2d;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by mahmud on 9/8/2017.
 */

class SmilifaceView extends View {
    public SmilifaceView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        drawCircle(canvas);


    }

    public void drawCircle(Canvas canvas){
        Paint col = new Paint();
        col.setARGB(255,255,80,255);
        col.setStyle(Paint.Style.FILL_AND_STROKE);
        Paint textColor = new Paint();
        textColor.setColor(Color.BLACK);
        textColor.setTextSize(30);

        float x = 200;
        float y = 200;
        float r = 200;
        canvas.drawCircle(x,y,r,col);
        canvas.drawText("Purple Circle",200,200,textColor);

    }
}
