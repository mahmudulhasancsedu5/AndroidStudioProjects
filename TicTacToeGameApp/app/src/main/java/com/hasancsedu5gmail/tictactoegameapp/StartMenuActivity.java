package com.hasancsedu5gmail.tictactoegameapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class StartMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_menu);
    }

    public void startSinglePlayerGame(View view) {
    }

    public void startMultiPlayerGame(View view) {

        Intent intent_multiplayer = new Intent(this,MultiPlayerActivity.class);

        startActivity(intent_multiplayer);

    }
}
