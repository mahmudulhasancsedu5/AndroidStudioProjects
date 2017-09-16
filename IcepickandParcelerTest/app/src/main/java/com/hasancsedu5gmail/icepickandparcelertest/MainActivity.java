package com.hasancsedu5gmail.icepickandparcelertest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.squareup.leakcanary.LeakCanary;

import org.parceler.Parcels;

import icepick.Icepick;
import icepick.State;


public class MainActivity extends AppCompatActivity {

    @State String text="No Text";

    public MainActivity() {
    }
    public MainActivity(String text) {

        this.text = text;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(LeakCanary.isInAnalyzerProcess(this)){

            return;
        }
        LeakCanary.install(getApplication());


        setContentView(R.layout.activity_main);
        Icepick.restoreInstanceState(this,savedInstanceState);


        init();

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        Icepick.saveInstanceState(this,outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Icepick.restoreInstanceState(this,savedInstanceState);
    }

    public void onClickSetText(View view) {

        EditText etInput = (EditText) findViewById(R.id.text_input_text);
        text = etInput.getText().toString();

        TextView tvDoc = (TextView) findViewById(R.id.text_document);
        tvDoc.setText(text);


    }

    private void init(){


        TextView tvDoc = (TextView) findViewById(R.id.text_document);

        tvDoc.setText(text);


    }

    public void onClickStartChildActivity(View view) {

        Intent intent = new Intent(MainActivity.this,ChildActivity.class);

        MainClassData data = new MainClassData("MainActivity Doc : "+text);
        intent.putExtra("data", Parcels.wrap(data));
        startActivity(intent);
    }
}
