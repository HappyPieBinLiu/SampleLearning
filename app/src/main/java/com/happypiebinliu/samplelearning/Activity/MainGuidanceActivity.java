package com.happypiebinliu.samplelearning.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import com.happypiebinliu.samplelearning.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainGuidanceActivity extends AppCompatActivity {
    private GridView gridView;
    private int[] imageIds = new  int[]{
            R.drawable.guidance_activity_ui,
            R.drawable.guidance_activity_event,
            R.drawable.guidance_activity_fragment,
            R.drawable.guidance_activity_fra,
    };

    Class<?>[] classes = {
            LauncherActivity.class,
            LauncherActivity.class,
            LauncherActivityAndFragment.class,
            LauncherActivityAndFragment.class
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_guidance);

        List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < imageIds.length; i++){
            Map<String, Object> listItem = new HashMap<String, Object>();
            listItem.put("image", imageIds[i]);
            listItems.add(listItem);
        }
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, listItems, R.layout.cell, new String[]{"image"}, new int[]{R.id.Image});
        gridView = (GridView) findViewById(R.id.gridViewGuidance);
        gridView.setAdapter(simpleAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainGuidanceActivity.this, classes[position]);
                startActivity(intent);
            }
        });
        gridView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainGuidanceActivity.this, classes[position]);
                startActivity(intent);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
