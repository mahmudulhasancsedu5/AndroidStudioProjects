package com.hasancsedu5gmail.sqliteapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    public static MyDatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseDatabase fb = FirebaseDatabase.getInstance();
        DatabaseReference myRef = fb.getReference("message");
        myRef.setValue("Hello FireBase");

        db = new MyDatabaseHelper(this);
    }

    public void onClickInsertStudent(View view) {

        EditText etName = (EditText)findViewById(R.id.text_name);
        EditText etSection = (EditText)findViewById(R.id.text_section);
        EditText etRoll = (EditText)findViewById(R.id.text_roll);
        String name = etName.getText().toString();
        String section = etSection.getText().toString();
        String roll = etRoll.getText().toString();

        boolean isSuccessful = db.insertStudent(name,section,roll);

        if(isSuccessful==true){

            Log.d(TAG,"Insert Successfully");
        }
        else{
            Log.d(TAG,"Insertion Fail.");


        }



    }

    public void onClickShowAllStudent(View view) {

        Intent intent = new Intent(this,ShowStudentActivity.class);

        startActivity(intent);
    }

    public static MyDatabaseHelper getDatabase()
    {
        return db;

    }
}
