package com.hasancsedu5gmail.sqliteapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by mahmud on 9/7/2017.
 */

public class MyDatabaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "student_db";
    private static final String TABLE_NAME = "student";
    private static final String COL1 = "id";
    private static final String COL2 = "name";
    private static final String COL3 = "section";
    private static final String COL4 = "roll";
    public MyDatabaseHelper(Context context) {
        super(context,DB_NAME,null,1);
//        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //create table
        String query = "CREATE TABLE "+TABLE_NAME +
                " ( "
                +COL1+" INTEGER PRIMARY KEY AUTOINCREMENT ,"
                +COL2+" VARCHAR(30),"
                +COL3+" VARCHAR(20),"
                +COL4+" VARCHAR(10)"
                +")";

        sqLiteDatabase.execSQL(query);
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        //drop table
        //call on create
        sqLiteDatabase.execSQL("DELETE TABLE IF EXISTS "+TABLE_NAME);
        onCreate(sqLiteDatabase);

    }

    public boolean insertStudent(String name,String section,String roll){

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COL2,name);
        contentValues.put(COL3,section);
        contentValues.put(COL4,roll);

        long res = sqLiteDatabase.insert(TABLE_NAME,null,contentValues);

        if(res == -1) return false;
        else return true;
    }


    public Cursor getData(){

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();


        Cursor cr = sqLiteDatabase.rawQuery("SELECT * FROM "+TABLE_NAME,null);

        return cr;

    }


}
