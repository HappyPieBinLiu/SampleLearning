package com.happypiebinliu.samplelearning.ActivityResource;

import android.graphics.drawable.ClipDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.happypiebinliu.samplelearning.R;

import java.util.Timer;
import java.util.TimerTask;

/**
 * ClipDrawable
 * 从其他位图中截取一个图片片断
 */
public class ClipDrawableActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clip_drawable);
        ImageView imageView = (ImageView) findViewById(R.id.imageClip);
        // 获取图片所显示的ClipDrawable对象 src  如果后面是backGround  imageview.getBackground();
        final ClipDrawable drawable = (ClipDrawable) imageView.getDrawable();
        final Handler handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                if (msg.what == 0x1233){
                    // 可以改变截取的大小0-10000
                    drawable.setLevel(drawable.getLevel() + 200);
                }
            }
        };
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Message message = new Message();
                message.what = 0x1233;
                handler.sendMessage(message);
                if (drawable.getLevel() >= 10000)
                    timer.cancel();
            }
        }, 0, 300);
    }
}
