package com.happypiebinliu.samplelearning.UI.ViewAnimator;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import com.happypiebinliu.samplelearning.R;

import java.util.ArrayList;

/**
 * 分屏幕，左右滚动
 * 继承自FrameLayout所以可以层叠显示View
 */
public class ViewSwitcherActivity extends AppCompatActivity {

    public static final int NUMBER_PER_SCREEN = 12;
    public static class dataItem{

        public String dataName;
        public Drawable drawable;
    }

    // 保存系统中所有的应用程序的List
    private ArrayList<dataItem> items = new ArrayList<dataItem>();
    private int screenNo = -1;
    private int screenCount;
    ViewSwitcher viewSwitcher;
    LayoutInflater layoutInflater;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_switcher);
        viewSwitcher = (ViewSwitcher) findViewById(R.id.viewSwitcher);

        layoutInflater = LayoutInflater.from(ViewSwitcherActivity.this);
        for (int i = 0; i < 40; i++){
            String label = "" + i;
            Drawable drawable = getResources().getDrawable(R.drawable.listview_images5);
            dataItem item = new dataItem();
            item.dataName = label;
            item.drawable = drawable;
        }
        screenCount = items.size() % NUMBER_PER_SCREEN == 0 ?
                items.size()/NUMBER_PER_SCREEN :
                items.size()/NUMBER_PER_SCREEN +1 ;
        viewSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                return layoutInflater.inflate(R.layout.slidelistview, null);
            }
        });
        next(null);
    }

    public void next(View v) {
        if (screenNo < screenCount - 1){
            screenNo++;
            // 组件显示的动画
            viewSwitcher.setInAnimation(this, R.anim.slide_in_right);
            // 组件隐藏的时候的动画
            viewSwitcher.setOutAnimation(this, R.anim.slide_in_left);
            ((GridView)viewSwitcher.getNextView()).setAdapter(adapter);
            viewSwitcher.showNext();
        }
    }
    public void prev(View v) {
        if (screenNo > 0 ){
            screenNo--;
            // 组件显示的动画
            viewSwitcher.setInAnimation(this, R.anim.slide_in_right);
            // 组件隐藏的时候的动画
            viewSwitcher.setOutAnimation(this, R.anim.slide_in_left);
            ((GridView)viewSwitcher.getNextView()).setAdapter(adapter);
            viewSwitcher.showPrevious();
        }
    }
    private BaseAdapter adapter = new BaseAdapter() {
        @Override
        public int getCount() {
            if (screenNo == screenCount - 1
                    && items.size() % NUMBER_PER_SCREEN != 0){
                return items.size() % NUMBER_PER_SCREEN;
            }
            return NUMBER_PER_SCREEN;
        }

        @Override
        public dataItem getItem(int i) {
            return items.get(screenNo * NUMBER_PER_SCREEN + i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null){
                view = layoutInflater.inflate(R.layout.labelicon, null);
            }
            ImageView imageView = (ImageView) findViewById(R.id.imageView);
            imageView.setImageDrawable(getItem(i).drawable);
            TextView textView = (TextView) findViewById(R.id.textView);
            textView.setText(getItem(i).dataName);
            return view;
        }
    };
}
