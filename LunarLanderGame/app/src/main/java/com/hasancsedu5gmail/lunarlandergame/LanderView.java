package com.hasancsedu5gmail.lunarlandergame;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import stanford.androidlib.graphics.GCanvas;
import stanford.androidlib.graphics.GColor;
import stanford.androidlib.graphics.GSprite;
import stanford.androidlib.util.RandomGenerator;

/**
 * Created by mahmud on 9/9/2017.
 */

public class LanderView  extends GCanvas{


    private Activity context;
    private GSprite rocket;
    private GSprite moonSurface;
    private int mFrame;
    private ArrayList<GSprite> astroidList = new ArrayList<GSprite>();

    public LanderView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = (Activity) context;
    }

    @Override
    public void init() {

        setBackgroundColor(GColor.BLUE);




        Bitmap moonImage = BitmapFactory.decodeResource(getResources(),R.drawable.moonsurface_transparent);


        float imageH = moonImage.getHeight();
        float imageW = moonImage.getWidth();

        float newWidth = (getWidth()/imageW)*imageW;
        float newHeight = moonImage.getHeight()/(moonImage.getWidth()/getWidth());


        moonImage = Bitmap.createScaledBitmap(moonImage,getWidth(),(int)newHeight,true);
        moonSurface = new GSprite(moonImage);
        moonSurface.setBottomY(getHeight());
        moonSurface.setCollisionMargin(10);
        add(moonSurface);

        ArrayList<Bitmap> rocketImages = new ArrayList<Bitmap>();
        rocketImages.add(loadScaledImage(R.drawable.rocket1_transparent,5));
        rocketImages.add(loadScaledImage(R.drawable.rocket_fire_transparent,5));




//        Bitmap rocketResizeImage = loadScaledImage(R.drawable.rocket1,5);

        rocket = new GSprite(rocketImages,100,100);
        rocket.setFramesPerBitmap(3);
        rocket.setVelocityY(5);
//        rocket.setAccelerationY(0.05f);
        rocket.setCollisionMargin(10);
        add(rocket);

//        this.onTouc(getRootView(),null);


//        animate(30);

    }

    private Bitmap loadScaledImage(int imageId,int factor){

        Bitmap rocketImg = BitmapFactory.decodeResource(getResources(),imageId);
        Bitmap rocketResizeImage = Bitmap.createScaledBitmap(
                rocketImg,
                rocketImg.getWidth()/factor,
                rocketImg.getHeight()/factor,
                true);
        return rocketResizeImage;

    }


    @Override
    public void onAnimateTick() {
        super.onAnimateTick();

        //todo
        //update
        //collision
        mFrame++;

        if(mFrame%50==0){

            Bitmap bombImage = BitmapFactory.decodeResource(getResources(),R.drawable.granade1_transparent);
            bombImage = Bitmap.createScaledBitmap(bombImage,bombImage.getWidth()/10,bombImage.getHeight()/10,true);
            GSprite bomb = new GSprite(bombImage);
            bomb.setRightX(getWidth());
            bomb.setVelocityX(-5);
            bomb.setCollisionMargin(10);

            float y = RandomGenerator.getInstance().nextFloat(getHeight()-100);
            bomb.setY(y);
            add(bomb);
            astroidList.add(bomb);


        }

        doCollision();

    }

    private void doCollision(){

        if(rocket.collidesWith(moonSurface)){

            Toast.makeText(context,"Boom Surface",Toast.LENGTH_SHORT).show();
            rocket.stop();

        }else{

            for(GSprite ast : astroidList){

                if(rocket.collidesWith(ast)){

                    Toast.makeText(context,"Boom Boom",Toast.LENGTH_SHORT).show();
//                    animationStop();
                    rocket.stop();
                }
                else{
                    float px=ast.getX();
                    if(px<0) ast.remove();

                }
            }

        }


    }


    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_DOWN){

//            rocket.setAccelerationY(-0.051f);
            rocket.setVelocityY(-5);

        }else if(event.getAction() == MotionEvent.ACTION_UP){

//            rocket.setAccelerationY(0.05f);
            rocket.setVelocityY(5);
        }
        return super.onTouch(v, event);
    }

    public void startGame(){

        animate(30);


    }
    public void stopGame(){


        try {
            animationStop();
        } catch (Exception e){

            Log.d("Stopanimation",e.toString());

        }

    }
}
