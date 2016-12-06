package com.happypiebinliu.samplelearning.Event;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class KeyListenerActivity extends AppCompatActivity {

     int speed = 10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //去掉窗口标题
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        final PlaneView planeView = new PlaneView(this);
        setContentView(planeView);

        WindowManager windowManager = getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        // 获得屏幕宽和高
        display.getMetrics(metrics);
        // 飞机的初始位置
        planeView.currentX = metrics.widthPixels / 2;
        planeView.currentY = metrics.heightPixels / 2;
        // 给飞机邦定一个监听器
        planeView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
               switch (event.getKeyCode()){
                    // down
                    case KeyEvent.KEYCODE_S:
                        planeView.currentY += speed;
                        break;
                    // up
                    case KeyEvent.KEYCODE_W:
                        planeView.currentY -= speed;
                        break;
                    // left
                    case KeyEvent.KEYCODE_A:
                        planeView.currentX -= speed;
                        break;
                    // right
                    case KeyEvent.KEYCODE_D:
                        planeView.currentX += speed;
                        break;
                }
                planeView.invalidate();
                return true;
            }
        });
    }
}
