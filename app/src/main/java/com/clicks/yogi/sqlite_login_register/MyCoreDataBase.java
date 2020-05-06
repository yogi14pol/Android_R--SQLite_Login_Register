package com.clicks.yogi.sqlite_login_register;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyCoreDataBase extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "MyData";
    private static final int VERSION = 1;

    MyCoreDataBase(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(MyTableData.DETAILS.CREATE_STATEMENT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(MyTableData.DETAILS.DELETE_STATEMENT);
        onCreate(db);
    }
}