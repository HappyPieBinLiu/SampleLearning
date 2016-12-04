package com.happypiebinliu.samplelearning.UI.Others;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.happypiebinliu.samplelearning.R;

/**
 * 这个Fragment派生而来
 * 它的作用就是添加滚动条
 * 它的里面只能又一个组件，她负责为这个组件添加垂直的滚动条
 * 水平滚动条 －－－》 HorizontalScrollView来负责
 * 两者类似
 */
public class ScrollViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_view);
    }
}
