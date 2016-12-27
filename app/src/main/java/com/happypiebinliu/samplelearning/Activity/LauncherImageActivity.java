package com.happypiebinliu.samplelearning.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.happypiebinliu.samplelearning.ActivityImage.BitmapActivity;
import com.happypiebinliu.samplelearning.ActivityImage.DrawPathActivity;
import com.happypiebinliu.samplelearning.ActivityImage.DrawTextOnPathActivity;
import com.happypiebinliu.samplelearning.ActivityImage.OnDrawActivity;
import com.happypiebinliu.samplelearning.R;

public class LauncherImageActivity extends LauncherActivity {

    String[]   names;

    Class<?>[] classes = {
            BitmapActivity.class,
            OnDrawActivity.class,
            DrawPathActivity.class,
            DrawTextOnPathActivity.class,
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
