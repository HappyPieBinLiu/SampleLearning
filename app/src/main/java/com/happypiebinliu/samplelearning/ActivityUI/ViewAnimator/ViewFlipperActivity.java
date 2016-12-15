package com.happypiebinliu.samplelearning.ActivityUI.ViewAnimator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ViewFlipper;

import com.happypiebinliu.samplelearning.R;

/**
 * AdapterViewFlipperActivity和这个比较相似，这个使用ａｄａｐｔｅｒ来完成子Ｖｉｅｗ的加载
 * ＶｉｅｗＦｌｉｐｐｅｒ是在ＸＭＬ中定义了　
 */
public class ViewFlipperActivity extends AppCompatActivity {

    ViewFlipper viewFlipper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_flipper);
        viewFlipper = (ViewFlipper) findViewById(R.id.details);
    }
    public void prev (View source){
        // 设定切换动画
        viewFlipper.setInAnimation(this, R.anim.slide_in_left);
        viewFlipper.setOutAnimation(this, R.anim.slide_in_right);
        // 显示上一个
        viewFlipper.showPrevious();
        // 停止自动播放
        viewFlipper.stopFlipping();
    }

    public void next (View source){
        // 设定切换动画
        viewFlipper.setInAnimation(this, R.anim.slide_in_left);
        viewFlipper.setOutAnimation(this, R.anim.slide_in_right);
        viewFlipper.showNext();
        viewFlipper.stopFlipping();
    }

    public void auto (View source){
        // 设定切换动画
        viewFlipper.setInAnimation(this, R.anim.slide_in_left);
        viewFlipper.setOutAnimation(this, R.anim.slide_in_right);
        viewFlipper.startFlipping();
    }
}
