package com.lovishsoftware.chinmay.todoapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class Finished extends Fragment {

    private List<ItemList> finishedList;
    View view;
    RecyclerView finishedRecyclerView;
    RecyclerView.LayoutManager iLayoutManager;
    FinishedListAdapter finishedListAdapter;

    public Finished(List<ItemList> finishedList) {
        Log.e("Finished", "Inside finished constructor");
        this.finishedList=finishedList;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.e("Finished", "Inside onCreateView");
        view = inflater.inflate(R.layout.fragment_finished, container, false);
        finishedRecyclerView = (RecyclerView) view.findViewById(R.id.finishedRecyclerView);
        iLayoutManager = new LinearLayoutManager(getActivity());
        finishedRecyclerView.setLayoutManager(iLayoutManager);
        Log.e("Finished", "setLayoutManager finished");
        finishedListAdapter = new FinishedListAdapter(finishedList);
        Log.e("Finished", "finishedListAdapter initialised");
        finishedListAdapter.notifyDataSetChanged();
        Log.e("Finished", "notifyDataSetChanged called");
        finishedRecyclerView.setAdapter(finishedListAdapter);
        Log.e("Finished", "setAdapter finished");
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }


    public void showUpdatedFinishedList(List<ItemList> finishedList) {

        finishedRecyclerView = (RecyclerView) view.findViewById(R.id.finishedRecyclerView);
        iLayoutManager = new LinearLayoutManager(getActivity());
        finishedRecyclerView.setLayoutManager(iLayoutManager);
        Log.e("Finished", "setLayoutManager finished");
        finishedListAdapter = new FinishedListAdapter(finishedList);
        Log.e("Finished", "finishedListAdapter initialised");
        finishedListAdapter.notifyDataSetChanged();
        Log.e("Finished", "notifyDataSetChanged called");
        finishedRecyclerView.setAdapter(finishedListAdapter);
        Log.e("Finished", "setAdapter finished");
    }
}
