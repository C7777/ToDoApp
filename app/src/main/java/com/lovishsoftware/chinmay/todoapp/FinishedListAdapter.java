package com.lovishsoftware.chinmay.todoapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Chinmay on 05-06-2017.
 */

public class FinishedListAdapter extends RecyclerView.Adapter<FinishedListAdapter.FinishedViewHolder> {

    private List<ItemList> finishedItemList;


    public FinishedListAdapter(List<ItemList> itemList) {

        this.finishedItemList=itemList;
    }

    public class FinishedViewHolder extends RecyclerView.ViewHolder {
        TextView item;
        public FinishedViewHolder(View itemView) {
            super(itemView);
            Log.e("FinishedListAdapter", "Inside FinishedViewHolder");
            item= (TextView) itemView.findViewById(R.id.finishedList);

        }
    }
    @Override
    public FinishedViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_finished, parent, false);
        Log.e("FinishedListAdapter", "Inside FinishedListAdapter onCreateViewHolder");
        return new FinishedViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final FinishedViewHolder holder, int position) {
        Log.e("FinishedListAdapter", "Inside FinishedListAdapter onBindViewHolder");
      final  ItemList finishedList=finishedItemList.get(position);
        holder.item.setText(finishedList.getDataList());

    }

    @Override
    public int getItemCount()
    {
        Log.e("FinishedListAdapter", "Inside FinishedListAdapter getItemCount");
        return (finishedItemList!= null) ?finishedItemList.size() :0;
    }



}
