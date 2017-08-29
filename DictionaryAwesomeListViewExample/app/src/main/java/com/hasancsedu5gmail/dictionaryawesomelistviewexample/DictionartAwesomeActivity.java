package com.hasancsedu5gmail.dictionaryawesomelistviewexample;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;


import stanford.androidlib.SimpleActivity;

import static android.widget.Toast.*;

public class DictionartAwesomeActivity extends SimpleActivity {



    private static final String TAG="Mahmud";

    private ListView list_view_defs;

    private static int totalQuestion;
    private static int currectAns;

    private MediaPlayer mediaPlayer;



    HashMap<String,String> dictionary = new HashMap<String,String>();
    List<String> list_words = new ArrayList<String>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dictionart_awesome);

        totalQuestion = 0;
        currectAns = 0;

        readDataFromFile();
        Log.i(TAG,"After read file");

        list_view_defs = (ListView)findViewById(R.id.word_list);
        choseDefination();


        list_view_defs.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                String clickedDef = adapterView.getItemAtPosition(i).toString();
                TextView textView = (TextView)findViewById(R.id.text_word);
                String word = textView.getText().toString();
                String wordDef = dictionary.get(word);

                //----------------
                setTraceLifecycle(true);
                //----------------


                totalQuestion++;
                TextView text_view_score = (TextView)findViewById(R.id.text_score);


                if(wordDef.equals(clickedDef)){

                    currectAns++;
                    Toast.makeText(DictionartAwesomeActivity.this, "Great Job :-)", Toast.LENGTH_SHORT).show();

                }
                else {

                    Toast.makeText(DictionartAwesomeActivity.this, "Aooooo Wrong Answer :-(", Toast.LENGTH_SHORT).show();

                }
                text_view_score.setText("Score : "+currectAns+"/"+totalQuestion);
                choseDefination();
            }





        });

        //Playing Song along with playing games.
        mediaPlayer = MediaPlayer.create(this,R.raw.music_photograph);
        mediaPlayer.start();



    }


    @Override
    protected void onPause() {
        super.onPause();

        mediaPlayer.pause();



    }

    @Override
    protected void onResume() {
        super.onResume();

        mediaPlayer.start();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("totalQuestion",totalQuestion);
        outState.putInt("currectAns",currectAns);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        totalQuestion = savedInstanceState.getInt("totalQuestion");
        currectAns = savedInstanceState.getInt("currectAns");
    }

    private void readDataFromFile()
    {

        try {

            Scanner scanner1 = new Scanner(getResources().openRawResource(R.raw.words));
            readDataHelper(scanner1);

            Scanner scanner2 = new Scanner(openFileInput("added_word.txt"));
            readDataHelper(scanner2);


        }catch (Exception ioe)
        {
            //nothind to do
            //Log.i(TAG,ioe.toString());
        }


        list_words = new ArrayList<>(dictionary.keySet());

    }

    private void readDataHelper(Scanner scanner)
    {

        while(scanner.hasNext())
        {
            String line = scanner.nextLine();
            String[] parts=line.split("\t");

            Log.i(TAG,parts[0]);

            if(parts.length<2) continue;
            dictionary.put(parts[0],parts[1]);
            //Log.i(TAG,parts[0]);
        }

        //Log.i(TAG,"Working");
        scanner.close();

    }

    // chose a word randomly
    // find 5 random defination of including the defination of chowsen word
    //show the word and the 5 defination in the ListView

    private void choseDefination(){

        List<String> list_words = new ArrayList<>(dictionary.keySet());


        Random random = new Random();

        int randomWordIndex = random.nextInt(list_words.size());
        String randomWord = list_words.get(randomWordIndex);
        String randomWordDef = dictionary.get(randomWord);

        List<String> wordDef = new ArrayList<>(dictionary.values());
        wordDef.remove(randomWordDef);
        Collections.shuffle(wordDef);

        wordDef = wordDef.subList(0,4);
        wordDef.add(randomWordDef);
        Collections.shuffle(wordDef);

        TextView text_word = (TextView)findViewById(R.id.text_word);
        text_word.setText(randomWord);



        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                wordDef
        );
        list_view_defs.setAdapter(adapter);



    }


    public void addNewWordClick(View view) {

        Intent intent_addWord = new Intent(this,AddWordActivity.class);

        startActivity(intent_addWord);
        //startActivityForResult(intent_addWord,);


    }
}
