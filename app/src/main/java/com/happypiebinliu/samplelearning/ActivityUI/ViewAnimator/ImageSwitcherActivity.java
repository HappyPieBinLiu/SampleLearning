package com.happypiebinliu.samplelearning.ActivityUI.ViewAnimator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.ViewSwitcher;

import com.happypiebinliu.samplelearning.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 支持动画的图片浏览效果
 * 继承了ＶｉｅｗＳｗｉｔｃｈｅｒ
 */
public class ImageSwitcherActivity extends AppCompatActivity {

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
    private ImageSwitcher imageSwitcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_switcher);
        // 图片设定
        List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < imageIds.length; i++){
            Map<String, Object> listItem = new HashMap<String, Object>();
            listItem.put("image", imageIds[i]);
            listItems.add(listItem);
        }
        imageSwitcher = (ImageSwitcher) findViewById(R.id.imageSwitcher);
        // 设定切换的动画效果
        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                // ImageView
                ImageView imageView = new ImageView(ImageSwitcherActivity.this);
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                // 这里必须返回一个Ｖｉｅｗ组件
                return imageView;
            }
        });

        SimpleAdapter simpleAdapter = new SimpleAdapter(this, listItems, R.layout.cell, new String[]{"image"}, new int[]{R.id.Image});
        GridView gridView = (GridView) findViewById(R.id.gridView1);
        gridView.setAdapter(simpleAdapter);
        gridView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // 显示被选中的图片
                imageSwitcher.setImageResource(imageIds[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // 显示被选中的图片
                imageSwitcher.setImageResource(imageIds[position]);
            }
        });
    }
}
