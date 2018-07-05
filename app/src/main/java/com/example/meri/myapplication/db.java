package com.example.meri.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteAbortException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class db extends SQLiteOpenHelper{
public  static final String a="name";
    public  static final String b="phone";
    public db(Context context) {
        super(context, "mdb",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
 db.execSQL("create table mytable ("
         + "_id integer primary key autoincrement,"
         + "a text,"
         + "b text"
         + ");");
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
