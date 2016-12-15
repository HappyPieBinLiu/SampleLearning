package com.happypiebinliu.samplelearning.ActivityUI.ActionBar;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;

import com.happypiebinliu.samplelearning.Fragment.DummyFragment;
import com.happypiebinliu.samplelearning.R;

public class ActionBarDropListActivity extends AppCompatActivity implements ActionBar.OnNavigationListener{
    private final static String SELECTED_ITEM = "selected_item";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_bar_drop_list);
        final ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
        // 为ＡｃｔｉｏｎＢａｒ设定ＡｒｒａｙＡｄａｐｔｅｒ
        actionBar.setListNavigationCallbacks(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
                android.R.id.text1, new String[]{"第一页", "第二页", "第三页"}), this);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        if (savedInstanceState.containsKey(SELECTED_ITEM)){
            getSupportActionBar().setSelectedNavigationItem(savedInstanceState.getInt(SELECTED_ITEM));
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(SELECTED_ITEM, getSupportActionBar().getSelectedNavigationIndex());
    }

    @Override
    public boolean onNavigationItemSelected(int itemPosition, long itemId) {
        Fragment fragment = new DummyFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(DummyFragment.ARG_SELECTION_NUMBER, itemPosition + 1);
        fragment.setArguments(bundle);
        FragmentTransaction ftt = getSupportFragmentManager().beginTransaction();
        ftt.replace(R.id.activity_action_bar_drop_list, fragment);
        ftt.commit();
        return true;
    }
}
