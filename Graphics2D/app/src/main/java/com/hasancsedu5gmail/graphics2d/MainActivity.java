package com.hasancsedu5gmail.graphics2d;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        BouncingBallView ballView = new BouncingBallView(this,null);

        setContentView(ballView);

    }
}
