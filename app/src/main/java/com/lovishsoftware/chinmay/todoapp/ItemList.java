package com.lovishsoftware.chinmay.todoapp;

import android.util.Log;

/**
 * Created by Chinmay on 21-05-2017.
 */

public class ItemList {

    private int listId;
    private String dataList;
    private  int done;

    public int getDone() {
        Log.e("ItemList", "Inside done setter method");
        return done;
    }

    public void setDone(int done)
    {
        Log.e("ItemList", "Inside done setter method");
        this.done = done;
    }



    public ItemList() {
        super();
        Log.e("ItemList", "Inside ItemList constructor");
    }


    public String getDataList() {

        Log.e("ItemList", "Inside DataList getter method");
        return dataList;
    }

    public void setDataList(String dataList) {

        Log.e("ItemList", "Inside DataList setter method");
        this.dataList = dataList;
    }

    public int getListId() {
        return listId;
    }

    public void setListId(int listId) {
        this.listId = listId;
    }
}
