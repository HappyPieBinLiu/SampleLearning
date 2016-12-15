package com.happypiebinliu.samplelearning.ActivityUI.ActionBar;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.happypiebinliu.samplelearning.R;

public class ActionBarActivity extends AppCompatActivity {

    ActionBar actionBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_bar);
        actionBar = getSupportActionBar();
    }
    public void showActionBar(View view){
        actionBar.show();
    }
    public void hideActionBar(View view){
        actionBar.hide();
    }
}
