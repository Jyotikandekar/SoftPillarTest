package com.example.softpillartest.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.softpillartest.database.IDatabase;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static DatabaseHelper databaseHelper = null;


    private DatabaseHelper(Context context) {

        super(context, IDatabase.DATABASE_NAME, null, IDatabase.DATABASE_VERSION);
    }

    public static synchronized DatabaseHelper getInstance(Context context) {
        if (databaseHelper == null) {
            databaseHelper = new DatabaseHelper(context);
        }
        return databaseHelper;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(IDatabase.CREATE_PROJECT);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
