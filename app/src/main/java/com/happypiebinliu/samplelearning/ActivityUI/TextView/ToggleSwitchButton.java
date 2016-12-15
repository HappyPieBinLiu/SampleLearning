package com.happypiebinliu.samplelearning.ActivityUI.TextView;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.ToggleButton;

import com.happypiebinliu.samplelearning.R;

/**
 * ToggleButton and switch 也是有Button派生而来。
 * 状态开关按钮 和 开关
 * 通常用于切换程序中的两种状态
 */
public class ToggleSwitchButton extends AppCompatActivity {

    private ToggleButton aToggleButton;
    private Switch aSwitch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.toggle_switch_button);
        final LinearLayout linearLayout = (LinearLayout) findViewById(R.id.textLinear);
        aToggleButton = (ToggleButton) findViewById(R.id.toggleBtn);
        aSwitch = (Switch) findViewById(R.id.switchBtn);
        CompoundButton.OnCheckedChangeListener listener = new CompoundButton.OnCheckedChangeListener() {
            /**
             * 监听状态开关按钮
             * 监听开关按钮
             * 实现动态改变现行布局
             * @param buttonView
             * @param isChecked
             */
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked){
                    linearLayout.setOrientation(LinearLayout.VERTICAL);
                    aToggleButton.setChecked(true);
                    aSwitch.setChecked(true);
                } else {
                    linearLayout.setOrientation(LinearLayout.HORIZONTAL);
                    aToggleButton.setChecked(false);
                    aSwitch.setChecked(false);
                }
            }
        };

        aSwitch.setOnCheckedChangeListener(listener);
        aToggleButton.setOnCheckedChangeListener(listener);
    }
}
