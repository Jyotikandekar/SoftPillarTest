package com.example.softpillartest.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.softpillartest.model.Project;
import com.example.softpillartest.utils.DatabaseHelper;

import java.util.ArrayList;

public class DataSourceProject {

    public static DataSourceProject dataSourceCart = null;
    /**
     * reference of DatabaseHelper
     */
    private DatabaseHelper databaseHelper;
    /**
     * reference of SQLiteDatabase to execute SQLite Queries
     */
    private SQLiteDatabase sqLiteDatabase;

    /**
     * constructor of this class
     *
     * @param context
     */
    private DataSourceProject(Context context) {
        databaseHelper = DatabaseHelper.getInstance(context);
    }

    /**
     * create Singleton object of this class
     *
     * @param context
     * @return
     */

    synchronized public static DataSourceProject getInstance(Context context) {
        if (dataSourceCart == null) {
            dataSourceCart = new DataSourceProject(context);
        }
        return dataSourceCart;
    }

    /**
     * open database
     */
    public void open() {
        if (sqLiteDatabase == null) {
            sqLiteDatabase = databaseHelper.getWritableDatabase();
        } else {
            if (!sqLiteDatabase.isOpen()) {
                sqLiteDatabase = databaseHelper.getWritableDatabase();
            }
        }
    }

    /**
     * close database
     */
    public void close() {
        if (sqLiteDatabase == null) {
            sqLiteDatabase = databaseHelper.getWritableDatabase();
        } else {
            if (sqLiteDatabase.isOpen()) {
                sqLiteDatabase.close();
            }
        }
    }

    /**
     * insert values into project table
     *
     * @param project
     * @return
     */
    public boolean insert(Project project) {

        ContentValues contentValues = new ContentValues();
        contentValues.put(IDatabase.PROJECT_ID, project.client_id);
        contentValues.put(IDatabase.CLIENT_NAME, project.client_name);
        contentValues.put(IDatabase.COMPONY_NAME, project.compony_name);
        contentValues.put(IDatabase.PROJECT_STAGE, project.project_stage);
        contentValues.put(IDatabase.CATEGORY, project.category);
        contentValues.put(IDatabase.PROJECT_DATE, project.project_date);

        return sqLiteDatabase.insert(IDatabase.TABLE_PROJECT, null, contentValues) >= 1;

    }

    /**
     * delete TABLE_CART  table  from database
     */
    public void delete() {
        sqLiteDatabase.delete(IDatabase.TABLE_PROJECT, null, null);
    }

    /**
     * get All banner details from TABLE_ADD_TO_LIST  TABLE
     *
     * @return
     */
    public ArrayList<Project> getRecords() {

        Project cartLocal = null;
        ArrayList<Project> arrayList = new ArrayList<Project>();

        Cursor cursor = sqLiteDatabase.query(IDatabase.TABLE_PROJECT, IDatabase.COLUMNS_PROJECT, null, null, null, null, null);
        for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {

            cartLocal = new Project();
            cartLocal.setClient_id(cursor.getString(cursor.getColumnIndex(IDatabase.PROJECT_ID)));
            cartLocal.setClient_name(cursor.getString(cursor.getColumnIndex(IDatabase.CLIENT_NAME)));
            cartLocal.setCompony_name(cursor.getString(cursor.getColumnIndex(IDatabase.COMPONY_NAME)));
            cartLocal.setProject_stage(cursor.getString(cursor.getColumnIndex(IDatabase.PROJECT_STAGE)));
            cartLocal.setCategory(cursor.getString(cursor.getColumnIndex(IDatabase.CATEGORY)));
            cartLocal.setProject_date(cursor.getString(cursor.getColumnIndex(IDatabase.PROJECT_DATE)));


            arrayList.add(cartLocal);
        }
        return arrayList;
    }

    /**
     * get All banner details  given by id from AMENITIES TABLE
     *
     * @return
     */
    public ArrayList<Project> getRecordsByCategory(String category) {
        Project cartLocal = null;
        ArrayList<Project> arrayList = new ArrayList<Project>();

        Cursor cursor = sqLiteDatabase.query(IDatabase.TABLE_PROJECT, IDatabase.COLUMNS_PROJECT
                , IDatabase.CATEGORY + " = '" + category + "' ", null, null, null, null);
        for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {

            cartLocal = new Project();
            cartLocal.setClient_id(cursor.getString(cursor.getColumnIndex(IDatabase.PROJECT_ID)));
            cartLocal.setClient_name(cursor.getString(cursor.getColumnIndex(IDatabase.CLIENT_NAME)));
            cartLocal.setCompony_name(cursor.getString(cursor.getColumnIndex(IDatabase.COMPONY_NAME)));
            cartLocal.setProject_stage(cursor.getString(cursor.getColumnIndex(IDatabase.PROJECT_STAGE)));
            cartLocal.setCategory(cursor.getString(cursor.getColumnIndex(IDatabase.CATEGORY)));
            cartLocal.setProject_date(cursor.getString(cursor.getColumnIndex(IDatabase.PROJECT_DATE)));


            arrayList.add(cartLocal);
        }
        return arrayList;
    }

}
