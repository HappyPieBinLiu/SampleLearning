package com.happypiebinliu.samplelearning.Event;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.happypiebinliu.samplelearning.R;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Android 启动的时候就默认的启动一个主线程，Main Thread
 *  主线程主要用来处理与UI相关的事件，所以主线程通常又叫做UI线程。
 * 用户的按键事件，触摸屏等等事件
 * 在新线程中不容许对Activity的界面组件进行更改，所以只能在新
 *  *
 * Handler消息传递机制  其实它实现的是线程之间的通信
 * 在新启动的线程中发送消息
 * 在主线程中获取处理消息
 */
public class HandlerActivity extends AppCompatActivity {

    int[] images = new int[] {
            R.drawable.imageview_image1,
            R.drawable.imageview_image2,
            R.drawable.imageview_image3,
            R.drawable.imageview_image4
    };
    int currentImage = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);
        final ImageView show = (ImageView) findViewById(R.id.show);
        final Handler myHandler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                if (msg.what == 0x1233){
                    show.setImageResource(images[currentImage++ % images.length]);
                }
            }
        };
        // 定义一个定时器，用来模拟生成定时的任务
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                myHandler.sendEmptyMessage(0x1233);
            }
        }, 0, 1200);
    }
}
