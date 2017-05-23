package com.lovishsoftware.chinmay.todoapp;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Chinmay on 20-05-2017.
 */

public class ItemListAdapter extends RecyclerView.Adapter<ItemListAdapter.MyViewHolder> {
    List<ItemList> itemList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView listId/*,done,*//* item*/;
        public MyViewHolder(View view) {
            super(view);
            Log.e("ItemListAdapter", "Inside MyViewHolder");
            listId= (TextView) view.findViewById(R.id.listId);
           // item= (TextView) view.findViewById(R.id.list_item);
           // done= (TextView) view.findViewById(R.id.done);
        }
    }

    public ItemListAdapter(List<ItemList> itemList)
    {
        Log.e("ItemListAdapter", "Inside ItemListAdapter Constructor");
        this.itemList=itemList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Log.e("ItemListAdapter", "Inside onCreateViewHolder");
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Log.e("ItemListAdapter", "Inside onBindViewHolder");
        ItemList list=itemList.get(position);
         holder.listId.setText(Integer.toString(list.getListId()));
        // holder.item.setText(list.getDataList());
        //holder.done.setText(Integer.toString(list.getDone()));
    }

    @Override
    public int getItemCount() {
        Log.e("ItemListAdapter", "Inside getItemCount");
        return itemList.size();
    }


}

