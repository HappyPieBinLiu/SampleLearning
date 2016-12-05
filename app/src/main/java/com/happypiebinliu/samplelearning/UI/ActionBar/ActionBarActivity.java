package com.happypiebinliu.samplelearning.UI.ActionBar;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.happypiebinliu.samplelearning.R;

public class ActionBarActivity extends Activity {

    android.app.ActionBar actionBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_bar);
        actionBar = getActionBar();
    }
    public void showActionBar(View view){
        actionBar.show();
    }
    public void hideActionBar(View view){
        actionBar.hide();
    }
}
