package com.happypiebinliu.samplelearning.Activity;

import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ExpandableListAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.happypiebinliu.samplelearning.R;

public class ExpandableListActivity extends android.app.ExpandableListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ExpandableListAdapter expandableListAdapter = new ExpandableListAdapter() {

            int[] logos = new  int[]{
                    R.drawable.listview_images1,
                    R.drawable.listview_images2,
                    R.drawable.listview_images3,
                    R.drawable.listview_images4,
                    R.drawable.listview_images5
            };
            private String[] group = new String[]{
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
            public void registerDataSetObserver(DataSetObserver observer) {

            }

            @Override
            public void unregisterDataSetObserver(DataSetObserver observer) {

            }

            @Override
            public int getGroupCount() {
                return group.length;
            }

            @Override
            public int getChildrenCount(int groupPosition) {
                return info[groupPosition].length;
            }

            @Override
            public Object getGroup(int groupPosition) {
                return group[groupPosition];
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
                TextView textView = new TextView(ExpandableListActivity.this);
                textView.setLayoutParams(lp);
                textView.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
                textView.setPadding(36, 0, 0, 0);
                textView.setTextSize(20);
                return textView;
            }
            @Override
            public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
                LinearLayout linearLayout = new LinearLayout(ExpandableListActivity.this);
                linearLayout.setOrientation(LinearLayout.HORIZONTAL);
                ImageView imageView = new ImageView(ExpandableListActivity.this);
                imageView.setImageResource(logos[groupPosition]);
                // 这个是用来设定imageView的长宽的
                AbsListView.LayoutParams lp = new AbsListView.LayoutParams(64, 64);
                imageView.setLayoutParams(lp);

                TextView textView = getTextView();
                textView.setText(getGroup(groupPosition).toString());
                linearLayout.addView(imageView);
                linearLayout.addView(textView);
                return linearLayout;
            }

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

            @Override
            public boolean areAllItemsEnabled() {
                return true;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public void onGroupExpanded(int groupPosition) {

            }

            @Override
            public void onGroupCollapsed(int groupPosition) {

            }

            @Override
            public long getCombinedChildId(long groupId, long childId) {
                return 0;
            }

            @Override
            public long getCombinedGroupId(long groupId) {
                return 0;
            }

        };
        setListAdapter(expandableListAdapter);
    }
}
