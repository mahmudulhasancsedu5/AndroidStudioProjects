package com.hasancsedu5gmail.dictionaryawesomelistviewexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import stanford.androidlib.SimpleActivity;

public class StartMemuActivity extends SimpleActivity {

    private static final int INTENT_CODE_ADD_WORD = 1234;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_memu);

        //----------------
        setTraceLifecycle(true);
        //----------------
    }

    public void playTheGame(View view) {

        //go to dictionary activity
        Intent intent = new Intent(this,DictionartAwesomeActivity.class);

        //intent.putExtra("input1","Some Food");

        startActivity(intent);
    }

    public void addANewWord(View view) {

        // go to add word activity

        Intent intent = new Intent(this,AddWordActivity.class);
        intent.putExtra("input1","Some Food");
        startActivityForResult(intent,INTENT_CODE_ADD_WORD);

    }

    @Override
    protected void onActivityResult(Class<?> activityClass, Intent intent) {
        super.onActivityResult(activityClass, intent);
    }

    //get called when add one activity return
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);


        if(requestCode == INTENT_CODE_ADD_WORD){

            //want data return from the intent

            String newWord = intent.getStringExtra("new_word");
            String newDef = intent.getStringExtra("new_def");

            String message =new String("New Word : "+newWord+"\n New Word Defination : "+newDef+"\n Added Successfully.");

            Toast.makeText(this,message,Toast.LENGTH_LONG).show();


        }
    }
}
