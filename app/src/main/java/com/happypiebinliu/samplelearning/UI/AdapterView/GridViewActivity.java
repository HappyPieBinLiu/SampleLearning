package com.happypiebinliu.samplelearning.UI.AdapterView;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;

import com.happypiebinliu.samplelearning.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 和ＬｉｓｔＶｉｅｗ相似，ＧｒｉｄＶｉｅｗ有多列
 * ｌｉｓｔｖｉｅｗ只有一列　　
 * ＧｒｉｄＶｉｅｗ有多列，需要制定含有几列，默认一列
 */
public class GridViewActivity extends AppCompatActivity {

    private GridView gridView;
    private ImageView imageView;
    private int[] imageIds = new  int[]{
            R.drawable.listview_images1,
            R.drawable.listview_images2,
            R.drawable.listview_images3,
            R.drawable.listview_images4,
            R.drawable.listview_images5,
            R.drawable.imageview_image1,
            R.drawable.imageview_image2,
            R.drawable.imageview_image3,
            R.drawable.imageview_image4
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);

        List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < imageIds.length; i++){
            Map<String, Object> listItem = new HashMap<String, Object>();
            listItem.put("image", imageIds[i]);
            listItems.add(listItem);
        }
        imageView = (ImageView) findViewById(R.id.imageView);
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, listItems, R.layout.cell, new String[]{"image"}, new int[]{R.id.Image});
        gridView = (GridView) findViewById(R.id.gridView1);
        gridView.setAdapter(simpleAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                imageView.setImageResource(imageIds[position]);
            }
        });
        gridView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                imageView.setImageResource(imageIds[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
