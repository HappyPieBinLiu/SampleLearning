package com.happypiebinliu.samplelearning.ActivityResource;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.happypiebinliu.samplelearning.R;

/**
 * 主体风格也可以对单个的Activity进行设定
 * 也可以对整体来设定
 * 但是不能想Style Theme是不能对单个的View进行设定的
 */
public class StyleThemeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.MyThemeTest);
        setContentView(R.layout.activity_style_theme);
    }
}
