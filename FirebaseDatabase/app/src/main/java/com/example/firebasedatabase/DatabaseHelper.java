package com.example.firebasedatabase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static  String DATABASE_NAME = "student.db" ;
    public static String TABLE_NAME = "student_table" ;
    public static final int DATABASE_VERSION  = 1 ;
    public static final String TABLE_STUDENTS = "students" ;
    public static final String ID = "ID" ;
    public static final String FIRSTNAME = "FIRSTNAME" ;
    public static final String SURNAME = "SURNAME" ;
    public static final String MARKS = "MARKS" ;




    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME  +" (ID INTEGER PRIMARY KEY ,  FIRSTNAME TEXT , SURNAME TEXT,MARKS INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        Oncreate(db);
    }

    private void Oncreate(SQLiteDatabase db) {
    }
}