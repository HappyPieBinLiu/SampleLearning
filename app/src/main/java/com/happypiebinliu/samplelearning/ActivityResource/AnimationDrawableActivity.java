package com.happypiebinliu.samplelearning.ActivityResource;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.happypiebinliu.samplelearning.R;

public class AnimationDrawableActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_drawable);
        final ImageView imageView = (ImageView) findViewById(R.id.imageAnimation);
        // 加载动画资源
        final Animation animation = AnimationUtils.loadAnimation(this, R.anim.hyperspace_jump);
        //  设置动画结束后保留结束状态
        animation.setFillAfter(true);
        Button button = (Button) findViewById(R.id.buttonAnimation);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.startAnimation(animation);
            }
        });
    }
}
