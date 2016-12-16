package com.happypiebinliu.samplelearning.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.happypiebinliu.samplelearning.ActivityResource.AnimationDrawableActivity;
import com.happypiebinliu.samplelearning.ActivityResource.ClipDrawableActivity;
import com.happypiebinliu.samplelearning.ActivityResource.LayerListActivity;
import com.happypiebinliu.samplelearning.ActivityResource.ShapeDrawableActivity;
import com.happypiebinliu.samplelearning.ActivityResource.StateListDrawableActivity;
import com.happypiebinliu.samplelearning.ActivityResource.ValuesResColorStringDimenActivity;
import com.happypiebinliu.samplelearning.ActivityUI.ProgressBar.SeekBarActivity;
import com.happypiebinliu.samplelearning.R;

public class LauncherIntentResourceActivity extends android.app.LauncherActivity {

    String[]   names;

    Class<?>[] classes = {
            ValuesResColorStringDimenActivity.class,
            StateListDrawableActivity.class,
            SeekBarActivity.class,
            LayerListActivity.class,
            ShapeDrawableActivity.class,
            ClipDrawableActivity.class,
            AnimationDrawableActivity.class,
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        names = getResources().getStringArray(R.array.IntentResActivityListName);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, names);
        setListAdapter(adapter);
    }

    @Override
    protected Intent intentForPosition(int position) {
        return new Intent(LauncherIntentResourceActivity.this, classes[position]);
    }
}
