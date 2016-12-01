package com.happypiebinliu.samplelearning.UI.ViewAnimator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.happypiebinliu.samplelearning.R;

/**
 * 分屏幕，左右滚动
 * 继承自FrameLayout所以可以层叠显示View
 */
public class ViewSwitcherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_switcher);
    }
}
