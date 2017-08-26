package com.hasancsedu5gmail.dictionaryawesomelistviewexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;

import stanford.androidlib.SimpleActivity;

public class DictionartAwesomeActivity extends SimpleActivity {


    private static String[] words = {

            "Mahmud","Hasan",
            "Faru","Man",
            "Yolu","Tom"

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dictionart_awesome);

        final HashMap<String,String> dictionary = new HashMap<String,String>();

        int numOfWords = words.length;
        for(int i=0;i<numOfWords;i+=2)
        {
            dictionary.put(words[i],words[i+1]);
        }


        ListView wordList = (ListView)findViewById(R.id.word_list);


        ArrayAdapter adapter = new ArrayAdapter<String>(
                this,//activity
                android.R.layout.simple_list_item_1,//layout
                new ArrayList<String>(dictionary.keySet())// items list
        );

        wordList.setAdapter(adapter);

        wordList.setOnItemClickListener(

                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                        String word = adapterView.getItemAtPosition(i).toString();
                        String defination = dictionary.get(word);

                        toast(defination);
                    }
                }


        );


    }
}
