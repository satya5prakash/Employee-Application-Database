package com.example.sunita.dbapp.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class Myhelper extends SQLiteOpenHelper {


    public Myhelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
    super(context, name, factory, version);
}

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        //create table
        sqLiteDatabase.execSQL("create table employee(_id integer primary key,emp_name text,emp_location text,emp_salary integer)");
        Log.i("employee1","table created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
