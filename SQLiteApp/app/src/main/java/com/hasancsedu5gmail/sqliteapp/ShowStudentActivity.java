package com.hasancsedu5gmail.sqliteapp;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ShowStudentActivity extends AppCompatActivity {

    private static final String TAG = ShowStudentActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_student);

        Log.d(TAG,"Switch to show");
//        Intent intent = getIntent();
//
//        Bundle bundle = intent.getExtras();

        MyDatabaseHelper db = MainActivity.db;

        showStudents(db);

    }


    private void showStudents(MyDatabaseHelper db){

        Cursor cr = db.getData();

        List<String> list = new ArrayList<String>();

        if(cr.moveToFirst()){

            do{
                String name = cr.getString(cr.getColumnIndex("name"));
                String section = cr.getString(cr.getColumnIndex("section"));
                String roll = cr.getString(cr.getColumnIndex("roll"));
                String row = name+" "+section+" "+roll+"\n";
                list.add(row);
                Log.v(TAG,row);

            }while(cr.moveToNext());


        }


        ArrayAdapter adapter = new ArrayAdapter(
                this,
                android.R.layout.simple_list_item_1,
                list
        );

        ListView listView = (ListView) findViewById(R.id.list_student);

        listView.setAdapter(adapter);


    }
}
