package com.example.sunita.dbapp.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.sunita.dbapp.helper.Myhelper;

public class MyDatabase {

    public static final  String MY_db="employee1";

    Context myCon;
    SQLiteDatabase db;
    Myhelper myhelper;

    public MyDatabase(Context mycontext) {
        myCon = mycontext;
        myhelper = new Myhelper(myCon,MY_db,null,1);

    }

    //method to open database
    public void open()
    {
        db=myhelper.getWritableDatabase();
    }
    //method to insert values in the table
    //nullColumnHack is used to pass empty row
    public void insertEmp(ContentValues cv)
    {
        db.insert("employee",null,cv);
        Log.i("employee1","data inserted");

    }

    public Cursor getEmp()
    {
        db=myhelper.getReadableDatabase();
        Cursor cursor=db.query("employee" ,null,null,null,null,null,null);

        return cursor;
    }
}
k