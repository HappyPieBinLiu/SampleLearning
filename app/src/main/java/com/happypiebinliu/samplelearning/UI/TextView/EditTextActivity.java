package com.happypiebinliu.samplelearning.UI.TextView;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.happypiebinliu.samplelearning.R;

/***
 * 练习了表格布局方式，可输入框里面，进行了稍微的用户体验扩充
 * 1 Hint 自动提示要输入的内容
 * 2 自动切换键盘 数字键盘和英文键盘
 * 他继承了TextView 实际是就是一个可以编辑的TextView
 */
public class EditTextActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text);
    }
}
