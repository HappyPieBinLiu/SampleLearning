package com.happypiebinliu.samplelearning.ActivityUI.AdapterView;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.happypiebinliu.samplelearning.R;

/**
 * ArrayAdapter 是BaseAdapter的子类
 * 用于把数组或者List的值包装成为多个列表项
 * checked_item 需要布局文件
 */
public class ListViewFromArrayAdapterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_from_array_adapter);

        ListView redListView = (ListView) findViewById(R.id.redListView);
        ListView greenListView = (ListView) findViewById(R.id.greenListView);

        // 定义一个数组
        String[] array1 = new String[]{"B.LIU", "LIUBIN", "劉斌", "リュウヒン"};
        // 将数组包装成ArrayAdapter
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.array_item, array1);
        redListView.setAdapter(arrayAdapter);

        String[] array2 = new String[]{"女神", "女汉子", "女人", "女儿"};
        // 将数组包装成ArrayAdapter
        // 第二个参数将为生成的每一个列表项提供现实格式，也就是说，每一个列表项都是一个textView.
        ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<String>(this, R.layout.checked_item, array2);
        greenListView.setAdapter(arrayAdapter2);
    }
}
