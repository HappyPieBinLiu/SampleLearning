package com.happypiebinliu.samplelearning.UI.AdapterView;

import android.os.Bundle;
import android.widget.ArrayAdapter;

/**
 * 直接继承ListActivity
 * setContentView也不需要
 */
public class ListActivity extends android.app.ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 定义一个数组
        String[] array1 = {"B.LIU", "LIUBIN", "劉斌", "リュウヒン"};
        // 将数组包装成ArrayAdapter
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, array1);
        setListAdapter(arrayAdapter);
    }
}
