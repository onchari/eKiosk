package com.example.user2.ekiosk;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by User2 on 08-Feb-17.
 */

public class EKiosk_DatabaseHelper_Class extends SQLiteOpenHelper {

    static final String DATABASE_NAME = "ekiosk.db";
    static final String USERS_TABLE = "users_table";
    static final String _ID = "id";
    static final String FIRSTNAME = "firstname";
    static final String LASTNAME = "lastname";
    static final String USERNAME = "username";
    static final String PASSWORD = "password";
    static final int DATABASE_VERSION = 1;


    public SQLiteDatabase m_sqLiteDatabase;
    final static String CREATE_TABLE = "create table " + USERS_TABLE + "(" +
            _ID + " integer primary key autoincrement, " +
            FIRSTNAME + " text, " +
            LASTNAME + " text, " +
            USERNAME + " text, " +
            PASSWORD + " text )";


    public EKiosk_DatabaseHelper_Class(Context context) {
        super(context, USERS_TABLE, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + DATABASE_NAME);
        onCreate(db);
    }

    public boolean insertEntry(String f_name, String l_name, String username, String password) {
        m_sqLiteDatabase = this.getWritableDatabase();
        ContentValues newValues = new ContentValues();
        newValues.put(FIRSTNAME, f_name);
        newValues.put(LASTNAME, l_name);
        newValues.put(USERNAME, username);
        newValues.put(PASSWORD, password);
        long result = m_sqLiteDatabase.insert(USERS_TABLE, null, newValues);

        if(result == -1){
            return false;
        }
        else{
            return  true;
        }


    }
}
