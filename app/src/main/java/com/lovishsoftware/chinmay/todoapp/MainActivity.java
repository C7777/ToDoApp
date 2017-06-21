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
import java.util.List;

public class MainActivity extends AppCompatActivity /*implements Pending.OnFragmentInteractionListener, Finished.OnFragmentInteractionListener */{

    private static final int code = 10;
    List<ItemList> list1 = new ArrayList();
    List<ItemList> list2 = new ArrayList();
    List<ItemList> pendingList = new ArrayList();
    List<ItemList> finishedList = new ArrayList();
    DbListHelper dbListHelper = new DbListHelper(this);
    Pending pending;
    Finished finished;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("MainActivity", "Inside onCreate");


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Log.e("MainActivity", "setSupportActionBar finished");
        SectionsPagerAdapter mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        Log.e("MainActivity", "mSectionsPagerAdapter finished");
        ViewPager mViewPager = (ViewPager) findViewById(R.id.container);
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
        Log.e("MainActivity", "pendingListSize in onCreate " + pendingSize);
        while (pendingIndex < pendingSize) {
            Log.e("MainActivity", "Inside pendingList while block in onCreate");
            pendingList.add(list1.get(pendingIndex));
            pendingIndex++;

        }

        list2.clear();
        finishedList.clear();
        list2 = dbListHelper.fetchFinishedData();
        int finishedSize = list2.size();
        int finishedIndex = 0;
        Log.e("MainActivity", "finishedListSize in onCreate " + finishedSize);
        while (finishedIndex < finishedSize) {
            Log.e("MainActivity", "Inside finishedList while block in onCreate");
            finishedList.add(list2.get(finishedIndex));
            finishedIndex++;

        }

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 10) {
            if (resultCode == Activity.RESULT_OK) {
                Log.e("MainActivity", "Inside onActivityResult");
                list1.clear();
                pendingList.clear();
                list1 = dbListHelper.getPendingData();
                int pendingSize = list1.size();
                int pendingIndex = 0;
                Log.e("MainActivity", "pendingListSize in onActivityResult is " + pendingSize);
                while (pendingIndex < pendingSize) {
                    Log.e("MainActivity", "Inside pending while block in onActivityResult");
                    pendingList.add(list1.get(pendingIndex));
                    pendingIndex++;

                }

                list2.clear();
                finishedList.clear();
                list2 = dbListHelper.fetchFinishedData();
                int finishedSize = list2.size();
                int finishedIndex = 0;
                Log.e("MainActivity", "finishedListSize in onActivityResult is " + finishedSize);
                while (finishedIndex < finishedSize) {
                    Log.e("MainActivity", "Inside finished while block in onActivityResult");
                    finishedList.add(list2.get(finishedIndex));
                    finishedIndex++;

                }

            }
            if (resultCode == Activity.RESULT_CANCELED) {

            }
        }
    }

    public void showUpdatedPendingAndFinishedData() {

        Log.e("MainActivity", "Inside showUpdatedPendingAndFinishedData");

        list1.clear();
        pendingList.clear();
        list1 = dbListHelper.getPendingData();
        int pendingSize = list1.size();
        int pendingIndex = 0;
        Log.e("MainActivity", "pendingListSize inside showUpdatedPendingAndFinishedData method is " + pendingSize);
        while (pendingIndex < pendingSize) {
            Log.e("MainActivity", "Inside pending while block in showUpdatedPendingAndFinishedData");
            pendingList.add(list1.get(pendingIndex));
            pendingIndex++;

        }
       // pending=new Pending(pendingList);
        pending.showUpdatedPendingList(pendingList);

        list2.clear();
        finishedList.clear();
        list2 = dbListHelper.fetchFinishedData();
        int finishedSize = list2.size();
        int finishedIndex = 0;
        Log.e("MainActivity", "finishedListSize inside showUpdatedPendingAndFinishedData method is " + finishedSize);
        while (finishedIndex < finishedSize) {
            Log.e("MainActivity", "Inside finished while block in showUpdatedPendingAndFinishedData");
            finishedList.add(list2.get(finishedIndex));
            finishedIndex++;

        }
        //finished=new Finished(finishedList);
        finished.showUpdatedFinishedList(finishedList);

    }


    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    Log.e("Main activity", "inside pending fragment");
                     pending = new Pending(pendingList);
                    return pending;


                case 1:
                    Log.e("Main activity", "inside finished fragment");
                    finished = new Finished(finishedList);
                    return finished;
            }
            return null;

        }

        @Override
        public int getCount() {
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
