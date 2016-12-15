package com.happypiebinliu.samplelearning.ActivityUI.ActionBar;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import com.happypiebinliu.samplelearning.Fragment.DummyFragment;
import com.happypiebinliu.samplelearning.R;

public class ActionBarTabActivity extends AppCompatActivity implements ActionBar.TabListener{

    private final static String SELECTED_ITEM = "selected_item";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_bar_tab);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        actionBar.addTab(actionBar.newTab().setText("Tab1").setTabListener(this));
        actionBar.addTab(actionBar.newTab().setText("Tab2").setTabListener(this));
        actionBar.addTab(actionBar.newTab().setText("Tab3").setTabListener(this));
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        Fragment fragment = new DummyFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(DummyFragment.ARG_SELECTION_NUMBER, tab.getPosition() + 1);
        fragment.setArguments(bundle);
        FragmentTransaction ftt = getSupportFragmentManager().beginTransaction();
        ftt.replace(R.id.activity_action_bar_tab, fragment);
        ftt.commit();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(SELECTED_ITEM, getSupportActionBar().getSelectedNavigationIndex());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        if (savedInstanceState.containsKey(SELECTED_ITEM)){
            getSupportActionBar().setSelectedNavigationItem(savedInstanceState.getInt(SELECTED_ITEM));
        }
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }
}
