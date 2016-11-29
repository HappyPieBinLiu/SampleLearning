package com.happypiebinliu.samplelearning;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

/**
 * RadioButton 和 CheckBox都是Button的子类
 * android：checked 决定初始化的时候是否被选中
 * 注意
 *     单选按钮🔘要没有XML中的按钮，都要加Android：id
 *
 */

public class RadioAndCheckBox extends AppCompatActivity {
    private RadioGroup rg;
    private TextView show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.radio_and_checkbox);
        rg = (RadioGroup) findViewById(R.id.radioGroup);
        show = (TextView) findViewById(R.id.show);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                String tip = i == R.id.male? "You are male." : "you are female.";
                show.setText(tip);

            }
        });
    }
}
