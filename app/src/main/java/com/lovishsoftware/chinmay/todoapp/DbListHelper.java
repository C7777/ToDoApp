package com.lovishsoftware.chinmay.todoapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chinmay on 20-05-2017.
 */

public class DbListHelper extends SQLiteOpenHelper {

    private Context context;
    private static final String DB_NAME = "MY_DATABASE";
    private static final String DB_TABLE = "DB_LIST";
    private static final int DB_VERSION = 1;
    private static final String COLUMN0 = "ID";
    private static final String COLUMN1 = "LIST";
    private static final String COLUMN2 = "DONE";

    public DbListHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create = "CREATE TABLE " + DB_TABLE + "(ID INTEGER PRIMARY KEY , LIST TEXT, DONE INTEGER DEFAULT 0)";
        db.execSQL(create);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP IF TABLE EXISTS " + DB_TABLE);
        onCreate(db);

    }

    public boolean inserData(String list) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN1, list);
        Log.e("DbListHelper", "Inside inserdata method");
        Log.e("DbListHelper", "list: " + list.toString());
        long result = db.insert(DB_TABLE, null, contentValues);
        db.close();
        return result != -1;

    }

    public List<ItemList> getPendingData() {
    List<ItemList> pendingItemList = new ArrayList();
        Log.e("DbListHelper", "Inside getPendingData method");
        SQLiteDatabase db = this.getReadableDatabase();
        String read = "SELECT * FROM " + DB_TABLE + " WHERE DONE= " + 0;
        Cursor cursor = db.rawQuery(read, null);

        while (cursor.moveToNext()) {

            Log.e("DbListHelper", "Inside getPendingData While");
            ItemList pendingListData = new ItemList();
            pendingListData.setListId(cursor.getInt(0));
            pendingListData.setDataList(cursor.getString(1));
            pendingListData.setDone(cursor.getInt(2));
            Log.e("DbListHelper", "ID: " + pendingListData.getListId());
            Log.e("DbListHelper", "Text: " + pendingListData.getDataList());
            Log.e("DbListHelper", "done: " + pendingListData.getDone());
            pendingItemList.add(pendingListData);
            Log.e("DbListHelper", "itemList add finished");

        }
        cursor.close();
        db.close();
        return pendingItemList;
    }

    public boolean updateDone(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN2, 1);
        String updateQuery = "WHERE ID=" + id;
        int updateResult = db.update(DB_TABLE, contentValues, updateQuery, null);
        Log.e("DbListHelper", "value" + updateResult);
        db.close();

        if (updateResult == 1) {
            return true;
        } else {
            return false;
        }

    }

    public List<ItemList> fetchFinishedData() {

    List<ItemList> finishedItemList = new ArrayList();
        Log.e("DbListHelper", "Inside fetchFinishedData method");
        SQLiteDatabase db = getReadableDatabase();
        String read = "SELECT * FROM " + DB_TABLE + " WHERE ID > " + 5;
        Cursor cursor = db.rawQuery(read, null);
        while (cursor.moveToNext()) {
            Log.e("DbListHelper", "Inside fetchFinishedData While");
            ItemList finishedListData = new ItemList();
            finishedListData.setListId(cursor.getInt(0));
            finishedListData.setDataList(cursor.getString(1));
            finishedListData.setDone(cursor.getInt(2));
            Log.e("DbListHelper", "ID: " + finishedListData.getListId());
            Log.e("DbListHelper", "Text: " + finishedListData.getDataList());
            Log.e("DbListHelper", "done: " + finishedListData.getDone());
            finishedItemList.add(finishedListData);
            Log.e("DbListHelper", "itemList add finished");
        }

        cursor.close();
        db.close();
        return finishedItemList;


    }
}
