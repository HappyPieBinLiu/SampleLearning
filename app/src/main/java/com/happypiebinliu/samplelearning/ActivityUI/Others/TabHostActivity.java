package com.happypiebinliu.samplelearning.ActivityUI.Others;

import android.app.TabActivity;
import android.os.Bundle;
import android.widget.TabHost;

import com.happypiebinliu.samplelearning.R;

public class TabHostActivity extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_host);

        TabHost tabHost = getTabHost();

        /*TabHost.TabSpec tabSpec1 = new TabHost.TabSpec("tab0001").setIndicator("AAAAA").setContent(R.id.tab1);
        tabHost.addView(tabSpec1);
        TabHost.TabSpec tabSpec2 = new TabHost.TabSpec("tab0002").setIndicator("BBBBB").setContent(R.id.tab2);
        tabHost.addView(tabSpec2);
        TabHost.TabSpec tabSpec3 = new TabHost.TabSpec("tab0003").setIndicator("CCCCC").setContent(R.id.tab3);
        tabHost.addView(tabSpec3);*/
    }
}
