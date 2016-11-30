package com.happypiebinliu.samplelearning.UI.AdapterView;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.happypiebinliu.samplelearning.R;

public class ListViewExtendBaseAdapterActivity extends AppCompatActivity {

    private ListView baseListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_extend_base_adapter);
        baseListView = (ListView) findViewById(R.id.ListView);
        // 重新扩展ＢａｓｅＡｄａｐｔｅｒ
        BaseAdapter baseAdapter = new BaseAdapter() {
            /**
             * 一共可以包含多少列表项
             * @return
             */
            @Override
            public int getCount() {
                return 20;
            }

            @Override
            public Object getItem(int position) {
                return null;
            }

            /**
             * 重写本方法
             * 把位置作为列表项的ＩＤ
             * @param position
             * @return
             */
            @Override
            public long getItemId(int position) {
                return position;
            }

            /**
             * 返回的就是列表框
             * 我们根据自己的要求在这个里面进行私人定制
             * @param position
             * @param convertView
             * @param parent
             * @return
             */
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                LinearLayout linearLayout = new LinearLayout(ListViewExtendBaseAdapterActivity.this);
                linearLayout.setOrientation(LinearLayout.HORIZONTAL);

                ImageView imageView = new ImageView(ListViewExtendBaseAdapterActivity.this);
                imageView.setImageResource(R.drawable.adapterview_rightmark);

                TextView textView = new TextView(ListViewExtendBaseAdapterActivity.this);
                textView.setText("第" + (position+1) + "Row!!");
                textView.setTextSize(20);
                textView.setTextColor(Color.RED);
                linearLayout.addView(imageView);
                linearLayout.addView(textView);
                return linearLayout;
            }
        };
        baseListView.setAdapter(baseAdapter);
    }
}
