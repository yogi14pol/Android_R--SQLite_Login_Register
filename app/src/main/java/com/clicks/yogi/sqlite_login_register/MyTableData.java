package com.clicks.yogi.sqlite_login_register;

import android.provider.BaseColumns;

public class MyTableData {

    MyTableData() {
        // Empty Constructor...
    }

    static abstract class DETAILS implements BaseColumns {

        static final String TABLE_NAME = "TABLENAME";
        static final String ID = "ID";
        static final String USERNAME = "USERNAME";
        static final String EMAILID = "EMAILID";
        static final String MOBILENUMBER = "MOBILENUMBER";
        static final String PASSWORD = "PASSWORD";
        static final String CONFIRMPASSWORD = "CONFIRMPASSWORD";

        static final String CREATE_STATEMENT = " CREATE TABLE "
                + TABLE_NAME + " ( "
                + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + USERNAME + " TEXT, "
                + EMAILID + " TEXT, "
                + MOBILENUMBER + " TEXT, "
                + PASSWORD + " TEXT, "
                + CONFIRMPASSWORD + " TEXT" + ");";

        static final String DELETE_STATEMENT = "DROP TABLE " + TABLE_NAME;

    }
}