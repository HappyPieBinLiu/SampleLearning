package com.happypiebinliu.samplelearning.ActivityUI.ActionBar;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;

import com.happypiebinliu.samplelearning.Fragment.DummyFragment;
import com.happypiebinliu.samplelearning.R;

/**
 * 这个是Android3.0 以前的版本 兼容的Fragment
 * 继承了android.v4.app.fragment 需要加入android-support-v4.jar这个包在libs里面
 * 添加第三方的jar包
 */
public class ActionBarOldVerActivity extends FragmentActivity implements android.support.v7.app.ActionBar.TabListener{

    ViewPager viewPager;
    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_bar_old_ver);
        actionBar = getActionBar();
        viewPager = (ViewPager) findViewById(R.id.pager);
        FragmentPagerAdapter fragmentPagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                Fragment fragment = new DummyFragment();
                Bundle args = new Bundle();
                args.putInt(DummyFragment.ARG_SELECTION_NUMBER, position + 1);
                fragment.setArguments(args);
                return fragment;
            }

            @Override
            public int getCount() {
                return 3;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                switch (position){
                    case 0:
                        return "第一页";
                    case 1:
                        return "第2页";
                    case 2:
                        return "第3页";
                }
                return null;
            }
        };
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        for (int i = 0; i < fragmentPagerAdapter.getCount(); i++){
            actionBar.addTab(actionBar.newTab()
            .setText(fragmentPagerAdapter.getPageTitle(i))
            .setTabListener((ActionBar.TabListener) this));
        }
        viewPager.setAdapter(fragmentPagerAdapter);
        viewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener(){
            @Override
            public void onPageSelected(int position) {
                actionBar.setSelectedNavigationItem(position);
            }

        });
    }


    @Override
    public void onTabSelected(android.support.v7.app.ActionBar.Tab tab, FragmentTransaction ft) {
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(android.support.v7.app.ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(android.support.v7.app.ActionBar.Tab tab, FragmentTransaction ft) {

    }
}
