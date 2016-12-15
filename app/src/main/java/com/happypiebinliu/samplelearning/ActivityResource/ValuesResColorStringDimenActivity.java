package com.happypiebinliu.samplelearning.ActivityResource;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

import com.happypiebinliu.samplelearning.R;

public class ValuesResColorStringDimenActivity extends AppCompatActivity {

    // 获取系统定义的系统资源
    private String[] allTheColors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_valuesres_color_string_dimen);
        allTheColors = getResources().getStringArray(R.array.allColorListName);
        //adapter
        BaseAdapter baseAdapter = new BaseAdapter() {
            @Override
            public int getCount() {
                return allTheColors.length;
            }

            @Override
            public Object getItem(int position) {
                return allTheColors[position];
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            /**
             * 重写该方法，设置GridView里面每一个单元格的样子（VIEW）
             * @param position
             * @param convertView
             * @param parent
             * @return
             */
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                TextView textView = new TextView(ValuesResColorStringDimenActivity.this);
                Resources resources = ValuesResColorStringDimenActivity.this.getResources();
                // 利用尺寸资源 设置文本框的长宽
                textView.setWidth((int) resources.getDimension(R.dimen.cell_width));
                textView.setHeight((int) resources.getDimension(R.dimen.cell_height));
                textView.setText(allTheColors[position]);
                TypedArray icons = resources.obtainTypedArray(R.array.allColors);
                textView.setBackground(icons.getDrawable(position));
                textView.setTextSize(20);
                return textView;
            }
        };
        GridView gridView = (GridView) findViewById(R.id.grid001);
        gridView.setAdapter(baseAdapter);
    }
}
