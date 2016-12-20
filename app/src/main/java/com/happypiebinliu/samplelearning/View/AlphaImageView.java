package com.happypiebinliu.samplelearning.View;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.happypiebinliu.samplelearning.R;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by ope001 on 2016/12/20.
 */

public class AlphaImageView extends ImageView {
    // 图片透明度的改变粒度
    private int alphaDelta = 0;
    // 图片当前透明度
    private int curAlpha = 0;
    // 透明度的改变间隔
    private final int SPEED = 300;
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 0x123){
                curAlpha += alphaDelta;
                if (curAlpha > 255) curAlpha = 255;
                AlphaImageView.this.setAlpha(curAlpha);
            }
        }
    };

    public AlphaImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.AlphaImageView);
        int duration = typedArray.getInt(R.styleable.AlphaImageView_duration, 0);
        alphaDelta = 255 * SPEED/ 6000;
    }
    /**
     * 重写 自动进行改变
     */
    @Override
    protected void onDraw(Canvas canvas) {
        this.setImageAlpha(curAlpha);
        super.onDraw(canvas);
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Message message = new Message();
                message.what = 0x123;
                if (curAlpha >= 255){
                    timer.cancel();
                }else {
                    handler.sendMessage(message);
                }
            }
        }, 0, SPEED);
    }
}
