package com.example.softpillartest.database;

public interface IDatabase {

    int DATABASE_VERSION = 1;

    String DATABASE_NAME = "DB_PROJECT";


    String TABLE_PROJECT = "TABLE_PROJECT";

    String PROJECT_ID="PROJECT_ID";
    String CLIENT_NAME = "CART_BASE_QTY";
    String COMPONY_NAME = "CART_ITEM_NAME";
    String PROJECT_STAGE = "CART_IMAGE_URL";
    String CATEGORY = "CART_ITEM_DESCRIPTION";
    String PROJECT_DATE = "CART_ITEM_AMT";

    String[] COLUMNS_PROJECT = {PROJECT_ID, CLIENT_NAME, COMPONY_NAME, PROJECT_STAGE, CATEGORY, PROJECT_DATE};

    String CREATE_PROJECT = "CREATE TABLE '" + TABLE_PROJECT + "' ( '"
            + PROJECT_ID + "' INTEGER, '"
            + CLIENT_NAME + "' TEXT, '"
            + COMPONY_NAME + "' TEXT, '"
            + PROJECT_STAGE + "' TEXT, '"
            + CATEGORY + "' TEXT,'"
            +PROJECT_DATE +"'TEXT )";
}
