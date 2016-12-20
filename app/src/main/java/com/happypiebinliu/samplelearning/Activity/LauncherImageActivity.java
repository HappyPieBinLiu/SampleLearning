package com.happypiebinliu.samplelearning.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.happypiebinliu.samplelearning.ActivityResource.ValuesResColorStringDimenActivity;
import com.happypiebinliu.samplelearning.R;

public class LauncherImageActivity extends LauncherActivity {

    String[]   names;

    Class<?>[] classes = {
            ValuesResColorStringDimenActivity.class,
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        names = getResources().getStringArray(R.array.ImageTestActivityListName);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, names);
        setListAdapter(adapter);
    }

    @Override
    protected Intent intentForPosition(int position) {
        return new Intent(LauncherImageActivity.this, classes[position]);
    }
}
