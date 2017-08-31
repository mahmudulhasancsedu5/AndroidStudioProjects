package com.hasancsedu5gmail.bangladeshcricketteamplayerprofile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlayerActivity extends AppCompatActivity {

    private static final String TAG = PlayerActivity.class.getSimpleName();


    private String mPlayerName;

    private List<String> mlistPlayerInfo = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        // receive data from the caller activity
        Intent intent = getIntent();
        Bundle playerInfo = intent.getExtras();
        String mPlayerName = playerInfo.getString("playerName");

        TextView tvPlayerName = (TextView)findViewById(R.id.text_view_player_name);
        tvPlayerName.setText(mPlayerName);
        tvPlayerName.setTextSize(30);


        ImageView ivPlayerImage = (ImageView) findViewById(R.id.image_view_player_image);
        int playerImageId = getImageId(mPlayerName);
        ivPlayerImage.setImageResource(playerImageId);

        //find id of player information file from player name

        String playerInfoFileName =mPlayerName;
        playerInfoFileName = playerInfoFileName.replace(" ","_");
        playerInfoFileName = "info_"+playerInfoFileName;
        playerInfoFileName = playerInfoFileName.toLowerCase();

        //debug
        Log.d(TAG,mPlayerName);
        Log.d(TAG,playerInfoFileName);

        //decode file id from file name
        int playerInfoFileId = getResources().getIdentifier(playerInfoFileName,"raw",this.getPackageName());

        //read player information from text file
        //make a list of the player information

        mlistPlayerInfo.clear();
        readDataFromFile(playerInfoFileId);

        ListView lvPlayerInfo = (ListView) findViewById(R.id.list_view_player_info);
        addListIntoListView(mlistPlayerInfo,lvPlayerInfo);



    }

    private int getImageId(String normalName){

        String playerImageName = "img_"+normalName;
        playerImageName = playerImageName.replace(" ","_");
        playerImageName = playerImageName.toLowerCase();

        Log.d(TAG,playerImageName);

        int playerImageId = getResources().getIdentifier(playerImageName,"drawable",this.getPackageName());

        return playerImageId;

    }


    private void readDataFromFile(int fileId){


        try{

            Scanner sc = new Scanner(getResources().openRawResource(fileId));

            while(sc.hasNext()){

                String line = sc.nextLine();
                if(line.length() > 0) mlistPlayerInfo.add(line);
            }

            sc.close();


        }catch (Exception e){

            Log.e(TAG,e.toString());

        }

    }


    private void addListIntoListView(List<String> listInfo, ListView lvPlayerInfo){


        ArrayAdapter<String> adapterInfo = new ArrayAdapter<String>(
                PlayerActivity.this,
                android.R.layout.simple_list_item_1,
                listInfo
        );

        lvPlayerInfo.setAdapter(adapterInfo);


    }



}

