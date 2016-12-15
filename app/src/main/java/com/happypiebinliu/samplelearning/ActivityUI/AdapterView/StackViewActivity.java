package com.happypiebinliu.samplelearning.ActivityUI.AdapterView;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.SimpleAdapter;
import android.widget.StackView;

import com.happypiebinliu.samplelearning.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 程序容许拖动
 * 以堆的形式进行显示
 */
public class StackViewActivity extends AppCompatActivity {

    int[] images = new  int[]{
            R.drawable.listview_images1,
            R.drawable.listview_images2,
            R.drawable.listview_images3,
            R.drawable.listview_images4,
            R.drawable.listview_images5
    };

    StackView stackView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stack_view);
        stackView = (StackView) findViewById(R.id.mStackView);
        List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();

        for (int i = 0; i < images.length; i++){
            Map<String, Object> listItem = new HashMap<String, Object>();
            listItem.put("image", images[i]);
            listItems.add(listItem);
        }

        SimpleAdapter simpleAdapter = new SimpleAdapter(this, listItems, R.layout.cell, new String[]{"image"}, new int[]{R.id.image});
        stackView.setAdapter(simpleAdapter);
    }
    public void prev (View v){
        stackView.showPrevious();
    }

    public void next (View v){
        stackView.showNext();
    }
}
