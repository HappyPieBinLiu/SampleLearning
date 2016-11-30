package com.happypiebinliu.samplelearning.UI.AdapterView;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.happypiebinliu.samplelearning.R;

/**
 * 继承自ＬｉｓｔＶｉｅｗ
 */
public class ExpandableListViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expandable_list_view);
        ExpandableListAdapter adapter = new BaseExpandableListAdapter() {
            int[] logos = new  int[]{
                    R.drawable.listview_images1,
                    R.drawable.listview_images2,
                    R.drawable.listview_images3,
                    R.drawable.listview_images4,
                    R.drawable.listview_images5
            };
            private String[] names = new String[]{
                    "左手", "离愁", "天马行空", "大鹏展翅", "小二黑"
            };
            private String[][] info = new String[][]{

                    { "离愁渐远渐行", "天马行空为我横行", "大鹏展翅比成功", "小二黑娶媳妇"},
                    { "左手右手一个慢动作", "天马行空为我横行", "大鹏展翅比成功", "小二黑娶媳妇"},
                    { "左手右手一个慢动作", "大鹏展翅比成功", "小二黑娶媳妇"},
                    { "左手右手一个慢动作", "离愁渐远渐行", "天马行空为我横行",  "小二黑娶媳妇"},
                    { "左手右手一个慢动作", "大鹏展翅比成功"}
            };
            @Override
            public int getGroupCount() {
                return names.length;
            }

            @Override
            public int getChildrenCount(int groupPosition) {
                return info[groupPosition].length;
            }

            @Override
            public Object getGroup(int groupPosition) {
                return names[groupPosition];
            }

            @Override
            public Object getChild(int groupPosition, int childPosition) {
                return info[groupPosition][childPosition];
            }

            @Override
            public long getGroupId(int groupPosition) {
                return groupPosition;
            }

            @Override
            public long getChildId(int groupPosition, int childPosition) {
                return childPosition;
            }

            @Override
            public boolean hasStableIds() {
                return true;
            }

            private TextView getTextView(){
                AbsListView.LayoutParams lp = new AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 64);
                TextView textView = new TextView(ExpandableListViewActivity.this);
                textView.setLayoutParams(lp);
                textView.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
                textView.setPadding(36, 0, 0, 0);
                textView.setTextSize(20);
                return textView;
            }
            /**
             * 每组的外观布局
             * @param groupPosition
             * @param isExpanded
             * @param convertView
             * @param parent
             * @return
             */
            @Override
            public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
                LinearLayout linearLayout = new LinearLayout(ExpandableListViewActivity.this);
                linearLayout.setOrientation(LinearLayout.HORIZONTAL);

                ImageView logo = new ImageView(ExpandableListViewActivity.this);
                logo.setMaxHeight(10);
                logo.setMaxWidth(20);
                logo.setImageResource(logos[groupPosition]);
                linearLayout.addView(logo);

                TextView textView = getTextView();
                textView.setText(getGroup(groupPosition).toString());
                linearLayout.addView(textView);
                return linearLayout;
            }

            /**
             * 组里面的子布局
             * @param groupPosition
             * @param childPosition
             * @param isLastChild
             * @param convertView
             * @param parent
             * @return
             */
            @Override
            public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
                TextView textView = getTextView();
                textView.setText(getChild(groupPosition, childPosition).toString());
                return textView;
            }

            @Override
            public boolean isChildSelectable(int groupPosition, int childPosition) {
                return true;
            }
        };
       ExpandableListView expandableListView = (ExpandableListView) findViewById(R.id.ListView);
        expandableListView.setAdapter(adapter);
    }
}
