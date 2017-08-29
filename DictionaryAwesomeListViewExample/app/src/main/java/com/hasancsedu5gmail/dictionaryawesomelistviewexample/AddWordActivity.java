package com.hasancsedu5gmail.dictionaryawesomelistviewexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.io.PrintStream;

import stanford.androidlib.SimpleActivity;

public class AddWordActivity extends SimpleActivity {

    private static String Add_TAG = "Mahmud";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_word);

        //----------------
        setTraceLifecycle(true);
        //----------------

        Intent intent = getIntent();

        String input1 = intent.getStringExtra("input1");

        EditText text = (EditText)findViewById(R.id.text_new_word);
        text.setText(input1);
    }



    public void addThisWordClick(View view) {

        //get word and def from the text fild

        EditText text_new_word = (EditText)findViewById(R.id.text_new_word);
        EditText text_new_defination = (EditText)findViewById(R.id.text_new_defination);

        String newWord = text_new_word.getText().toString();
        String newDef = text_new_defination.getText().toString();


        //add word and its definatio in the dictionary
        PrintStream printStream = new PrintStream(
                openFileOutput("added_word.txt",MODE_APPEND | MODE_PRIVATE));
        printStream.println(newWord+"\t"+newDef);
        printStream.close();

        //return result to the caller
        Intent goBack_intent = new Intent();
        goBack_intent.putExtra("new_word",newWord);
        goBack_intent.putExtra("new_def",newDef);

        Log.i(Add_TAG,newWord+"  "+newDef);

        setResult(RESULT_OK , goBack_intent);

        finish();// stop/close the current activity







    }
}
