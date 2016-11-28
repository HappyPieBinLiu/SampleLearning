package com.happypiebinliu.samplelearning;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/***
 * 练习了表格布局方式，可输入框里面，进行了稍微的用户体验扩充
 * 1 Hint 自动提示要输入的内容
 * 2 自动切换键盘 数字键盘和英文键盘
 */
public class EditTextActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text);
    }
}
