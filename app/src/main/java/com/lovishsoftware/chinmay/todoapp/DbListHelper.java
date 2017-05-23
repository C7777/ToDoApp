package com.lovishsoftware.chinmay.todoapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Chinmay on 20-05-2017.
 */

public class DbListHelper extends SQLiteOpenHelper {

    private Context context;
    private static final String DB_NAME="MY_DATABASE";
    private static final String DB_TABLE="DB_LIST";
    private static final int DB_VERSION=1;
    private static final String COLUMN0="ID";
    private static final String COLUMN1="LIST";
    private static final String COLUMN2="DONE";


    public DbListHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create="CREATE TABLE " +DB_TABLE+ "(ID INTEGER PRIMARY KEY , LIST TEXT, DONE INTEGER DEFAULT 0)";
        db.execSQL(create);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP IF TABLE EXISTS "+ DB_TABLE);
        onCreate(db);

    }

    public boolean inserData(String list)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COLUMN1, list);
        Log.e("DbListHelper", "Inside inserdata method");
        long result=db.insert(DB_TABLE, null, contentValues);
        db.close();
        if(result == -1)
        {
            return false;
        }
        else
        {
            return true;
        }

    }
    public Cursor getData()
    {
        SQLiteDatabase db=this.getReadableDatabase();
        String read="SELECT * FROM "+ DB_TABLE;
        Cursor cursor=db.rawQuery(read, null);
        Log.e("DbListHelper", "Inside getData method");
        //cursor.close();
       // db.close();
        return cursor;

    }
}
