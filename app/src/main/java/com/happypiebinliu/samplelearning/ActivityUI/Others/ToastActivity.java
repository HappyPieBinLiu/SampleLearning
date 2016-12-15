package com.happypiebinliu.samplelearning.ActivityUI.Others;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.happypiebinliu.samplelearning.R;

/**
 *　不获取焦点，自动消失
 * 　一般适合简单的文本提示内容
 * 　但是也支持图片和自定义Ｖｉｅｗ组件
 */
public class ToastActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);
        Button simpleBtn = (Button) findViewById(R.id.btnA);
        Button multiBtn = (Button) findViewById(R.id.btnB);

        simpleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(ToastActivity.this, "TEST简单Ｔｏａｓｔ", Toast.LENGTH_LONG);
                toast.show();
            }
        });

        multiBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = new Toast(ToastActivity.this);
                //显示位置
                toast.setGravity(Gravity.CENTER, 0, 0);

                //自定义自己的显示布局Ｖｉｅｗ
                // 我们也可以把这个定义成为一个ＸＭＬ，复用
                LinearLayout linearLayout = new LinearLayout(ToastActivity.this);
                ImageView imageView = new ImageView(ToastActivity.this);
                imageView.setImageResource(R.drawable.adapterview_rightmark);
                linearLayout.addView(imageView);
                TextView textView = new TextView(ToastActivity.this);
                textView.setText("TEST带图片Ｔｏａｓｔ");
                textView.setTextSize(24);
                textView.setTextColor(Color.MAGENTA);
                linearLayout.addView(textView);

                //把自定义Ｖｉｅｗ设定给Ｔｏａｓｔ
                toast.setView(linearLayout);
                // 设定显示时间
                toast.setDuration(Toast.LENGTH_LONG);
                toast.show();
            }
        });

    }
}
