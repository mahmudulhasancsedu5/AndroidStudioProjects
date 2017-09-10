package com.hasancsedu5gmail.lunarlandergame;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

import stanford.androidlib.graphics.GCanvas;
import stanford.androidlib.graphics.GColor;
import stanford.androidlib.graphics.GLabel;
import stanford.androidlib.graphics.GSprite;
import stanford.androidlib.util.RandomGenerator;

/**
 * Created by mahmud on 9/9/2017.
 */

public class LanderView  extends GCanvas{


    private static final int WINING_SCORE = 50;
    private Activity context;
    private GSprite rocket;
    private GSprite moonSurface;
    private int mFrame;
    private ArrayList<GSprite> astroidList;

    private GLabel scoreLable;
    private int score = 0;
    GLabel gameMessage;

    public LanderView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = (Activity) context;
    }

    @Override
    public void init() {

        astroidList = new ArrayList<GSprite>();
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


        addScoreLable();

        if(score>=WINING_SCORE){
            winGame();
//            animationStop();
        }

        if(mFrame%30==0){
            addAsteroid();
            score++;
        }

        doCollision();

    }

    private void addScoreLable(){

        if(scoreLable != null) scoreLable.remove();
        scoreLable = new GLabel();
        scoreLable.setX(100);
        scoreLable.setY(100);


        scoreLable.setText("Score : "+ score);
        scoreLable.setColor(GColor.WHITE);
        scoreLable.setFontSize(30);

        add(scoreLable);

    }

    private void addAsteroid(){

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

    private void doCollision(){



        if(rocket.collidesWith(moonSurface)){

            loseGame();

        }else{

            for(GSprite ast : astroidList){

                if(rocket.collidesWith(ast)){

                    loseGame();
                }
                else{
                    float px=ast.getX();
                    if(px<0) ast.remove();

                }
            }

        }

    }

    private void winGame(){

        winLoseHelper(getContext().getString(R.string.youwin));


    }

    private void loseGame(){

        winLoseHelper(getContext().getString(R.string.youlose));
    }

    private void winLoseHelper(String message){
        rocket.setVelocityY(0);
        rocket.setAccelerationY(0);
        gameMessage  = new GLabel();
        gameMessage.setText(message);
        gameMessage.setFontSize(30);
        gameMessage.setColor(GColor.RED);

        gameMessage.setX(getWidth()/2 - gameMessage.getWidth()/2);
        gameMessage.setY(getHeight()/2 - gameMessage.getHeight()/2);
        add(gameMessage);

//        animationStop();

        score = 0;

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


        if(gameMessage != null) gameMessage.remove();

        rocket.setX(getWidth()/2);
        rocket.setY(rocket.getHeight()/2);
        rocket.setVelocityY(5);

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
