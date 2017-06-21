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

    private List<ItemList> pendingList;
    View view;
    RecyclerView pendingRecyclerView;
    RecyclerView.LayoutManager iLayoutManager;
    PendingListAdapter pendingListAdapter;

    public Pending(List<ItemList> pendingList) {
        Log.e("Pending", "Inside pending constructor");
        this.pendingList = pendingList;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Log.e("Pending", "Inside Pending onCreateView");
         view = inflater.inflate(R.layout.fragment_pending, container, false);
        pendingRecyclerView = (RecyclerView) view.findViewById(R.id.pendingrecyclerview);
        iLayoutManager = new LinearLayoutManager(getActivity());
        pendingRecyclerView.setLayoutManager(iLayoutManager);
        Log.e("Pending", "setLayoutManager finished");
        pendingListAdapter = new PendingListAdapter(getContext(), pendingList);
        Log.e("Pending", "pendingListAdapter initialised");
        pendingListAdapter.notifyDataSetChanged();
        Log.e("Pending", "notifyDataSetChanged called");
        pendingRecyclerView.setAdapter(pendingListAdapter);
        Log.e("Pending", "setAdapter finished");
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.e("Pending", "Pending onAttach called");
    }


    public void showUpdatedPendingList(List<ItemList> pendingList) {
        pendingRecyclerView = (RecyclerView) view.findViewById(R.id.pendingrecyclerview);
        iLayoutManager = new LinearLayoutManager(getActivity());
        pendingRecyclerView.setLayoutManager(iLayoutManager);
        Log.e("Pending", "setLayoutManager finished");
        pendingListAdapter = new PendingListAdapter(getContext(), pendingList);
        Log.e("Pending", "pendingListAdapter initialised");
        pendingListAdapter.notifyDataSetChanged();
        Log.e("Pending", "notifyDataSetChanged called");
        pendingRecyclerView.setAdapter(pendingListAdapter);
        Log.e("Pending", "setAdapter finished");
    }
}
