package com.lovishsoftware.chinmay.todoapp;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Pending.OnFragmentInteractionListener, Finished.OnFragmentInteractionListener {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;
    private SectionsPagerAdapter mSectionsPagerAdapter;
    private static final int code = 10;
    List<ItemList> list1 = new ArrayList();
    List<ItemList> list2 = new ArrayList();
    List<ItemList> pendingList = new ArrayList();
    List<ItemList> finishedList = new ArrayList();
    DbListHelper dbListHelper = new DbListHelper(this);
    ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("MainActivity", "Inside onCreate");


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Log.e("MainActivity", "setSupportActionBar finished");
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        Log.e("MainActivity", "mSectionsPagerAdapter finished");
        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        Log.e("MainActivity", "mViewPager finished");

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
        Log.e("MainActivity", "tabLayout finished");


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                Log.e("MainActivity", "Inside MainActivity");
                startActivityForResult(intent, code);
            }
        });

        list1.clear();
        pendingList.clear();
        list1 = dbListHelper.getPendingData();
        int pendingSize = list1.size();
        int pendingIndex = 0;
        Log.e("MainActivity", "size " + pendingSize);
        while (pendingIndex < pendingSize) {
            Log.e("MainActivity", "Inside while");
            pendingList.add(list1.get(pendingIndex));
            pendingIndex++;

        }

        list2.clear();
        finishedList.clear();
        list2 = dbListHelper.fetchFinishedData();
        int finishedSize = list2.size();
        int finishedIndex = 0;
        Log.e("MainActivity", "size " + finishedSize);
        while (finishedIndex < finishedSize) {
            Log.e("MainActivity", "Inside finished while");
            finishedList.add(list2.get(finishedIndex));
            finishedIndex++;

        }
        //dbListHelper
        /*Cursor cursor=  dbListHelper.getPendingData();
        while (cursor.moveToNext())
        {
            Log.e("MainActivity", "Inside While2");
            ItemList pendingListData = new ItemList();
            pendingListData.setListId(cursor.getInt(0));
            pendingListData.setDataList(cursor.getString(1));
            pendingListData.setDone(cursor.getInt(2));
            Log.e("Main activity", "ID: " + pendingListData.getListId());
            Log.e("Main activity", "Text: " + pendingListData.getDataList());
            Log.e("Main activity", "done: " + pendingListData.getDone());
            pendingItemList.add(pendingListData);
            Log.e("Main activity", "itemList add finished");

        }*/

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 10) {
            if (resultCode == Activity.RESULT_OK) {
                Log.e("MainActivity", "Inside onActivityResult");
                //dbListHelper =new DbListHelper(this);
                list1.clear();
                pendingList.clear();
                list1 = dbListHelper.getPendingData();
                int pendingSize = list1.size();
                int pendingIndex = 0;
                Log.e("MainActivity", "size " + pendingSize);
                while (pendingIndex < pendingSize) {
                    Log.e("MainActivity", "Inside pending while");
                    pendingList.add(list1.get(pendingIndex));
                    pendingIndex++;

                }

                list2.clear();
                finishedList.clear();
                list2 = dbListHelper.fetchFinishedData();
                int finishedSize = list2.size();
                int finishedIndex = 0;
                Log.e("MainActivity", "size " + finishedSize);
                while (finishedIndex < finishedSize) {
                    Log.e("MainActivity", "Inside finished while");
                    finishedList.add(list2.get(finishedIndex));
                    finishedIndex++;

                }

                /*while (cursor.moveToNext())
                {

                    Log.e("MainActivity", "Inside While2");
                    ItemList pendingListData = new ItemList();
                    pendingListData.setListId(cursor.getInt(0));
                    pendingListData.setDataList(cursor.getString(1));
                    pendingListData.setDone(cursor.getInt(2));
                    Log.e("Main activity", "ID: " + pendingListData.getListId());
                    Log.e("Main activity", "Text: " + pendingListData.getDataList());
                    Log.e("Main activity", "done: " + pendingListData.getDone());
                    pendingItemList.add(pendingListData);
                    Log.e("Main activity", "itemList add finished");

                }*/
            }
            if (resultCode == Activity.RESULT_CANCELED) {

            }
        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }


    /**
     * A placeholder fragment containing a simple view.
     */
  /*  public static class PlaceholderFragment extends Fragment {
        *//**
     * The fragment argument representing the section number for this
     * fragment.
     *//*
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        *//**
     * Returns a new instance of this fragment for the given section
     * number.
     *//*
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        *//*@Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
            textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
            return rootView;
        }*//*
    }*/

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            switch (position) {
                case 0:
                    Log.e("Main activity", "inside pending fragment");
                    Pending pending = new Pending();
                    pending.showPendingData(pendingList);
                    return pending;


                case 1:
                    Log.e("Main activity", "inside finished fragment");
                    Finished finished = new Finished();
                    finished.showFinishedData(finishedList);
                    return finished;
            }
            return null;
            //return PlaceholderFragment.newInstance(position + 1);

        }

        @Override
        public int getCount() {
            // Show 2 total pages.
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Pending";
                case 1:
                    return "Finished";
            }
            return null;
        }
    }
}
