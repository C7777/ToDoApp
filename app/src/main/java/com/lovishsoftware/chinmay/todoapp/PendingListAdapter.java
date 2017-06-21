package com.lovishsoftware.chinmay.todoapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import java.util.List;


/**
 * Created by Chinmay on 20-05-2017.
 */

public class PendingListAdapter extends RecyclerView.Adapter<PendingListAdapter.PendingViewHolder> {
    private List<ItemList> pendingItemList;
    private Context context;

    public class PendingViewHolder extends RecyclerView.ViewHolder {
        private TextView item;
        private ImageButton check;

        public PendingViewHolder(final View view) {
            super(view);
            Log.e("PendingListAdapter", "Inside PendingViewHolder");
            //listId= (TextView) view.findViewById(R.id.listId);
            item = (TextView) view.findViewById(R.id.list_item);
            check = (ImageButton) view.findViewById(R.id.check);
        }

    }

    

    public PendingListAdapter(Context context, List<ItemList> itemList) {
        Log.e("PendingListAdapter", "Inside PendingListAdapter Constructor");
        this.pendingItemList = itemList;
        this.context = context;
    }
    

    @Override
    public PendingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Log.e("PendingListAdapter", "Inside PendingListAdapter onCreateViewHolder");
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_pending, parent, false);

        return new PendingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final PendingViewHolder holder, int position) {

        Log.e("PendingListAdapter", "Inside PendingListAdapter onBindViewHolder");
        final ItemList list = pendingItemList.get(position);
        holder.item.setText(list.getDataList());
        holder.check.setImageResource(R.drawable.ic_action_name);
        holder.check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int id = list.getListId();
                Log.e("PendingListAdapter", "Inside setOnClickListener " + id);
                DbListHelper dbListHelper = new DbListHelper(context);
                boolean finished = dbListHelper.updateDone(id);
                if (finished) {
                    ((MainActivity)context).showUpdatedPendingAndFinishedData();
                }
            }
        });

        Log.e("PendingListAdapter", "item: " + holder.item.toString());
    }


    @Override
    public int getItemCount() {
        Log.e("PendingListAdapter", "Inside PendingListAdapter getItemCount");
        return (pendingItemList != null) ? pendingItemList.size() : 0;

    }

}