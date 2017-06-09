package com.lovishsoftware.chinmay.todoapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class Pending extends Fragment {

    private RecyclerView pendingRecyclerView;
    private ItemListAdapter itemAdapter;
    private Context context;

    public Pending() {
        Log.e("Pending", "Inside pending constructor");
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        Log.e("Pending", "Inside onCreateView");
        View view = inflater.inflate(R.layout.fragment_pending, container, false);
        pendingRecyclerView = (RecyclerView) view.findViewById(R.id.pendingrecyclerview);
        RecyclerView.LayoutManager iLayoutManager = new LinearLayoutManager(getActivity());
        pendingRecyclerView.setLayoutManager(iLayoutManager);
        Log.e("Pending", "setLayoutManager finished");
        pendingRecyclerView.setAdapter(itemAdapter);
        Log.e("Pending", "setAdapter finished");
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    public void showPendingData(List<ItemList> pendingList) {

        Log.e("Pending", "Inside showPendingData method");
        itemAdapter = new ItemListAdapter(context, pendingList);
        Log.e("Pending", "itemAdapter finished");
        itemAdapter.notifyDataSetChanged();
        Log.e("Pending", "notifyDataSetChanged finished");
    }
}
