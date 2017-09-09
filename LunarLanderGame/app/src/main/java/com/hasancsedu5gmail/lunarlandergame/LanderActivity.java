package com.hasancsedu5gmail.lunarlandergame;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class LanderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        BitmapImageView back = new BitmapImageView(this,null);
//        LanderView rocket = new LanderView(this,null);
        setContentView(R.layout.activity_lander);
    }



    public void onClickStartNewGame(View view) {

        LanderView landerView = (LanderView) findViewById(R.id.lander_1);
        landerView.startGame();



    }

    public void onClickStopGame(View view) {

        LanderView landerView = (LanderView) findViewById(R.id.lander_1);
        landerView.stopGame();



    }
}
