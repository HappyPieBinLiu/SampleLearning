package com.happypiebinliu.samplelearning.ActivityImage;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.happypiebinliu.samplelearning.R;

/**
 * bitmap 位图
 * bitmapDrawable 构造器
 * bitmapFactory
 */
public class BitmapActivity extends AppCompatActivity {

    String[]  images = null;
    AssetManager assetManager ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bitmap);
    }
}
