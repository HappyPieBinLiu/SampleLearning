package com.happypiebinliu.samplelearning;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 * analogClock 继承了View组件  模拟
 *             but This widget is no longer supported, from api23
 * textClock 继承了textView组件  文本
 */
public class ClockAnalogText extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.clock_analog_text);
    }
}
