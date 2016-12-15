package com.happypiebinliu.samplelearning.ActivityEvent;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.happypiebinliu.samplelearning.R;

public class ConfigurationActivity extends AppCompatActivity {

    EditText ori, navigation, touch, mnc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuration);
        ori = (EditText) findViewById(R.id.ori);
        navigation = (EditText) findViewById(R.id.navigation);
        touch = (EditText) findViewById(R.id.touch);
        mnc = (EditText) findViewById(R.id.mnc);
        Button bn = (Button) findViewById(R.id.bn);
        bn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 获取系统的configration对象
                Configuration configuration = getResources().getConfiguration();
                String screen = configuration.orientation == Configuration.ORIENTATION_LANDSCAPE
                        ? "横向屏幕":"纵向屏幕";
                ori.setText(screen);

                String mncCode = configuration.mnc + "";
                mnc.setText(mncCode);

                String naviName = configuration.navigation == Configuration.NAVIGATION_NONAV
                        ? "没有方向控制": configuration.navigation == Configuration.NAVIGATION_DPAD
                        ? "方向键控制方向": configuration.navigation == Configuration.NAVIGATION_WHEEL
                        ? "滚轮控制方向": "轨迹控制方向";
                navigation.setText(naviName);

                String touchName = configuration.touchscreen == Configuration.TOUCHSCREEN_NOTOUCH
                        ? "无触摸屏":"支持触摸";
                touch.setText(touchName);
            }
        });


        Button changeBn = (Button) findViewById(R.id.change);
        changeBn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Configuration configuration = getResources().getConfiguration();
                // 判断当前屏幕状况
                if (configuration.orientation == Configuration.ORIENTATION_LANDSCAPE){
                    ConfigurationActivity.this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                }
                if (configuration.orientation == Configuration.ORIENTATION_PORTRAIT){
                    ConfigurationActivity.this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                }

            }
        });
    }

    /**
     * 回调方式，系统设置是否更改
     * @param newConfig
     */
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        String screen = newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE
                ? "横向屏幕":"纵向屏幕";
        Toast.makeText(this, "系统屏幕方向发生改变" + "\n修改后的屏幕方向：" + screen, Toast.LENGTH_LONG);
    }
}
