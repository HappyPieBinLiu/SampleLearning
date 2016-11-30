package com.happypiebinliu.samplelearning.UI.AdapterView;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.happypiebinliu.samplelearning.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 */
public class ListViewFromSimpleAdapterActivity extends AppCompatActivity {

    private String[] names = new String[]{
            "左手", "离愁", "天马行空", "大鹏展翅", "小二黑"
    };

    private String[] signInfo = new String[]{
            "左手右手一个慢动作", "离愁渐远渐行", "天马行空为我横行", "大鹏展翅比成功", "小二黑娶媳妇"
    };
    private int[] imageIds = new  int[]{
            R.drawable.listview_images1,
            R.drawable.listview_images2,
            R.drawable.listview_images3,
            R.drawable.listview_images4,
            R.drawable.listview_images5
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_from_simple_adapter);
        // List 集合的创建
        List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < names.length; i++){
            Map<String, Object> listItem = new HashMap<>();
            listItem.put("headerImage", imageIds[i]);
            listItem.put("name", names[i]);
            listItem.put("signInfo", signInfo[i]);
            listItems.add(listItem);
        }
        // SimpleAdapter创建
        SimpleAdapter simpleAdapter = new SimpleAdapter(this,
                // List 内容
                listItems,
                // 列表布局
                R.layout.simple_item,
                //　Ｌｉｓｔ中Ｍａｐ的那些Ｋｅｙ作为显示对象　Ｓｔｒｉｎｇ的Ｋｅｙ
                new String[]{"name", "headerImage", "signInfo"},
                //　布局上的那些组件将被填充
                new int[]{R.id.name, R.id.headerImage, R.id.signInfo} );

        ListView listView = (ListView) findViewById(R.id.ListView);
        listView.setAdapter(simpleAdapter);

        /**
         * 邦定监听　单击
         */
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                System.out.println(names[position] + "is on click!!");
            }
        });

        /**
         * 邦定监听　选中
         */
        listView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                System.out.println(names[position] + "is selected!!");
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
