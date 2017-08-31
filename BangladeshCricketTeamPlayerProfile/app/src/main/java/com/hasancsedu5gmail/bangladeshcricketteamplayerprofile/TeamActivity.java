package com.hasancsedu5gmail.bangladeshcricketteamplayerprofile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.TextView;

public class TeamActivity extends AppCompatActivity {

    private static final String TAG = TeamActivity.class.getSimpleName();
    private static final String[] PLAYER_NAME = {
            "Mashrafe Mortaza",
            "Shakib Al Hasan",
            "Tamim Iqbal",
            "Mushfiqur Rahim",
            "Mahmudullah",
            "Sabbir Rahman",
            "Rubel Hossain",
            "Mustafizur Rahman",
            "Soumya Sarkar",
            "Taskin Ahmed",
            "Imrul Kayes",
            "Mehidy Hasan",
            "Shafiur Islam",
            "Sanzamul Islam"

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team);

        GridLayout gridLayout = (GridLayout) findViewById(R.id.layout_grid_team);
        for(String playerName : PLAYER_NAME){

            addPlayerInfo(playerName,gridLayout);

        }
    }


    private void addPlayerInfo(final String playerName,GridLayout gridLayout){

        View playerView = getLayoutInflater().inflate(R.layout.player_info,null);

        TextView tvPlayerName = (TextView)playerView.findViewById(R.id.text_view_player_name);
        tvPlayerName.setText(playerName);

        ImageButton playerImageButton = (ImageButton)playerView.findViewById(R.id.image_button_player);

        String playerImageName = playerName.replace(" ","_");
        playerImageName = playerImageName.toLowerCase();

        playerImageName = "img_"+playerImageName;

        Log.d(TAG,playerImageName);

        int playerImageId = getResources().getIdentifier(playerImageName,"drawable",this.getPackageName());
        playerImageButton.setImageResource(playerImageId);

        playerImageButton.setOnClickListener(

                new View.OnClickListener(){

                    @Override
                    public void onClick(View view) {

                        Intent intent = new Intent(TeamActivity.this,PlayerActivity.class);

                        intent.putExtra("playerName",playerName);

                        startActivity(intent);

                    }
                }
        );

        gridLayout.addView(playerView);


    }
}
