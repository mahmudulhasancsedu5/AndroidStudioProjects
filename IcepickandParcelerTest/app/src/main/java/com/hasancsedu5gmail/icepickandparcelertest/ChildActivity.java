package com.hasancsedu5gmail.icepickandparcelertest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.parceler.Parcels;

public class ChildActivity extends AppCompatActivity {

    String mText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child);

        MainClassData mainClassData = Parcels.unwrap(getIntent().getParcelableExtra("data"));
        mText = mainClassData.text;

        TextView tvChildDoc = (TextView) findViewById(R.id.text_child_doc);
        tvChildDoc.setText(mText);



    }
}
