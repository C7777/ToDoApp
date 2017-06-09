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


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Finished.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class Finished extends Fragment {

    private RecyclerView finishedRecyclerView;
    private FinishedListAdapter finishedListAdapter;
    private OnFragmentInteractionListener mListener;

    public Finished() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.e("Finished", "Inside onCreateView");
        View view= inflater.inflate(R.layout.fragment_finished, container, false);
        finishedRecyclerView= (RecyclerView)view.findViewById(R.id.finishedRecyclerView);
        RecyclerView.LayoutManager iLayoutManager = new LinearLayoutManager(getActivity());
        finishedRecyclerView.setLayoutManager(iLayoutManager);
        Log.e("Finished", "setLayoutManager finished");
        finishedRecyclerView.setAdapter(finishedListAdapter);
        Log.e("Finished", "setAdapter finished");
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public void showFinishedData(List<ItemList> finishedList) {

        Log.e("Finished", "Inside showPendingData method");
        finishedListAdapter = new FinishedListAdapter(getActivity(), finishedList);
        Log.e("Finished", "finishedListAdapter finished");
        finishedListAdapter.notifyDataSetChanged();
        Log.e("Finished", "notifyDataSetChanged finished");
    }
    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
