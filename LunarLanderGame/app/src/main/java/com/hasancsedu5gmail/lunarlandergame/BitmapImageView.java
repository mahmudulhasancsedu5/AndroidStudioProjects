package com.hasancsedu5gmail.lunarlandergame;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by mahmud on 9/8/2017.
 */

public class BitmapImageView extends View{
    public BitmapImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Bitmap backGroundImage = BitmapFactory.decodeResource(getResources(),R.drawable.moonsurface_transparent);
        Bitmap resizedImage = Bitmap.createScaledBitmap(backGroundImage,canvas.getWidth(),canvas.getHeight(),false);
        canvas.drawBitmap(resizedImage,0,0,null);

    }
}
