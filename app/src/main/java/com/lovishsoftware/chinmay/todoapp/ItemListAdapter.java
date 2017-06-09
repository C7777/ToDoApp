package com.lovishsoftware.chinmay.todoapp;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


/**
 * Created by Chinmay on 20-05-2017.
 */

public class ItemListAdapter extends RecyclerView.Adapter<ItemListAdapter.MyViewHolder> {
    List<ItemList> pendingItemList;
    private Context context;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView item;//listId
        public ImageButton check;

        public MyViewHolder(final View view) {
            super(view);
            Log.e("ItemListAdapter", "Inside MyViewHolder");
            //listId= (TextView) view.findViewById(R.id.listId);
            item = (TextView) view.findViewById(R.id.list_item);
            check = (ImageButton) view.findViewById(R.id.check);
        }

    }

    public ItemListAdapter(Context context, List<ItemList> itemList) {
        Log.e("ItemListAdapter", "Inside ItemListAdapter Constructor");
        this.pendingItemList = itemList;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Log.e("ItemListAdapter", "Inside onCreateViewHolder");
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_pending, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {

        Log.e("ItemListAdapter", "Inside onBindViewHolder");
        final ItemList list = pendingItemList.get(position);
        // holder.listId.setText(Integer.toString(list.getListId()));

        holder.item.setText(list.getDataList());
        holder.check.setImageResource(R.drawable.ic_action_name);
        holder.check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int id = list.getListId();
                Log.e("ItemListAdapter", "Inside setOnClickListener " + id);
                DbListHelper dbListHelper = new DbListHelper(context);
                boolean finished = dbListHelper.updateDone(id);
                if (finished == true) {
                    pendingItemList.remove(id);
                }
            }
        });

        Log.e("ItemListAdapter", "item: " + holder.item.toString());
    }


    @Override
    public int getItemCount() {
        Log.e("ItemListAdapter", "Inside getItemCount");
        return (pendingItemList != null) ? pendingItemList.size() : 0;

    }

}