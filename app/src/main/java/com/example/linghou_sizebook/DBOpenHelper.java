package com.example.linghou_sizebook;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by linghou on 2017-02-03.
 */
//Based on the tutorial from https://www.lynda.com/Android-tutorials/Building-Note-Taking-App-Android/377485-2.html
public class DBOpenHelper extends SQLiteOpenHelper {
    //Constants for db names and version
    private static final String DATABASE_NAME = "notes.db";
    private static final int DATABASE_VERSION = 1;

    //constants for identifying table and columns
    public static final String TABLE_NOTES = "notes";
    public static final String NOTE_ID = "_id";
    public static final String NOTE_TEXT = "noteText";
    public static final String NOTE_CREATED = "noteCreated";
    public static final String[] ALL_COLUMNS =
            {NOTE_ID,NOTE_TEXT,NOTE_CREATED};
    //SQL to create table
    private static  final String TABLE_CREATE = "CREATE TABLE " +
            TABLE_NOTES + "(" +NOTE_ID +
            " INTEGER PRIMARY KEY AUTOINCREMENT, " + NOTE_TEXT + " TEXT," +
            NOTE_CREATED + " TEXT default CURRENT_TIMESTAMP" + ")";


    public DBOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NOTES);
        onCreate(db);
    }
}
