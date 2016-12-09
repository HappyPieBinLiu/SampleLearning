package com.happypiebinliu.samplelearning.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.happypiebinliu.samplelearning.Event.ConfigurationActivity;
import com.happypiebinliu.samplelearning.UI.AdapterView.ExpandableListViewActivity;

public class LauncherActivity extends android.app.LauncherActivity {

    String[]   names = {
            "设置程序参数",
            "查看"
    };

    Class<?>[] classes = {
            ConfigurationActivity.class,
            ExpandableListViewActivity.class
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, names);
        setListAdapter(adapter);
    }

    @Override
    protected Intent intentForPosition(int position) {
        return new Intent(LauncherActivity.this, classes[position]);
    }
}
