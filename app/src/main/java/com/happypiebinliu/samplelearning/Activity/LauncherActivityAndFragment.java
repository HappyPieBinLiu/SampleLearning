package com.happypiebinliu.samplelearning.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class LauncherActivityAndFragment extends android.app.LauncherActivity {

    String[]   names = {
            "用LauncherActivity开发启动Activity的列表",
            "用ExpandableListActivity开发可展开的Activity",
            "用PreferenceActivity实现参数设置界面"
    };

    Class<?>[] classes = {
            LauncherActivity.class,
            ExpandableListActivity.class,
            PreferenceTestActivity.class,
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, names);
        setListAdapter(adapter);
    }

    @Override
    protected Intent intentForPosition(int position) {
        return new Intent(LauncherActivityAndFragment.this, classes[position]);
    }
}
