package com.happypiebinliu.samplelearning.Event;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.happypiebinliu.samplelearning.R;

/**
 * 解决在UI线程中耗时操作，阻塞UI，用户界面失去响应
 * 关于Looper主线程中已经默认生成一个，所以Handler可以直接使用
 * 但是新的线程中，必须先定义一个Looper才能用Handler
 * looper---->messageQueue----->handler
 */
public class LooperHandlerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_looper_handler);
    }
}
