package com.happypiebinliu.samplelearning.ActivityResource;

import android.animation.AnimatorInflater;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import com.happypiebinliu.samplelearning.R;

public class PropertyAnimationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_animation);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.container);
        linearLayout.addView(new MyAnimationView(this));

    }
    public class MyAnimationView extends View{
        public  MyAnimationView( Context context){
            super(context);
            // 加载动画资源
            ObjectAnimator colorAnimator = (ObjectAnimator) AnimatorInflater.loadAnimator(PropertyAnimationActivity.this, R.animator.color_anim);
            colorAnimator.setEvaluator(new ArgbEvaluator());
            colorAnimator.setTarget(this);
            colorAnimator.start();
        }
    }
}
