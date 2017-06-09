package com.lovishsoftware.chinmay.todoapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Chinmay on 05-06-2017.
 */

public class FinishedListAdapter extends RecyclerView.Adapter<FinishedListAdapter.FinishedViewHolder> {

    private Context context;
    private List<ItemList> finishedItemList;


    public FinishedListAdapter(Context context, List<ItemList> itemList) {

        this.context=context;
        this.finishedItemList=itemList;
    }

    public class FinishedViewHolder extends RecyclerView.ViewHolder {
        TextView item;
        public FinishedViewHolder(View itemView) {
            super(itemView);
            item= (TextView) itemView.findViewById(R.id.finishedList);

        }
    }
    @Override
    public FinishedListAdapter.FinishedViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_finished, parent, false);
        return new FinishedViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final FinishedViewHolder holder, int position) {
      final  ItemList finishedList=finishedItemList.get(position);
        holder.item.setText(finishedList.getDataList());

    }

    @Override
    public int getItemCount() {
        return (finishedItemList!= null) ?finishedItemList.size() :0;
    }



}
