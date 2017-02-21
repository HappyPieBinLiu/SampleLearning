package com.happypiebinliu.samplelearning.ActivityImage;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.happypiebinliu.samplelearning.View.TableBallView;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class TableBallActivity extends Activity {

    // 小球的纵向运行速度
    private int ySpeed = 15;
    Random random = new Random();
    private double xyRate = random.nextDouble() - 0.5;

    // 小球的横向运行速度
    private int xSpeed = (int) (ySpeed * xyRate * 2);

    TableBallView tableBallView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        tableBallView = new TableBallView(this);
        setContentView(tableBallView);

        // 获取窗口管理器
        WindowManager windowManager = getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        display.getMetrics(displayMetrics);
        // 屏幕大小的获得
        tableBallView.tableWidth = displayMetrics.widthPixels;
        tableBallView.tableHeight = displayMetrics.heightPixels;
        tableBallView.racketY = tableBallView.tableHeight - 80;

        final Handler handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                if (msg.what == 0x123){
                    tableBallView.invalidate();
                }
            }
        };

        tableBallView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                switch (event.getKeyCode()){
                    // 挡板左移
                    case KeyEvent.KEYCODE_A:
                        if (tableBallView.racketX > 0) tableBallView.racketX -= 10;
                        break;
                    // 挡板右移
                    case KeyEvent.KEYCODE_D:
                        if (tableBallView.racketX < tableBallView.tableWidth - tableBallView.RACKET_WIDTH)
                            tableBallView.racketX += 10;
                        break;
                }
                // 通知重绘
                tableBallView.invalidate();
                return true;
            }
        });
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                // 小球碰倒边框
                if (tableBallView.ballX <= 0 || tableBallView.ballX >= tableBallView.tableWidth - tableBallView.BALL_SIZE)
                    xSpeed = - xSpeed;
                // 如果小球高度超出了球拍位置，且横向不再球拍范围之内，游戏结束
                if (tableBallView.ballY >= tableBallView.racketY - tableBallView.BALL_SIZE
                        && (tableBallView.ballX < tableBallView.racketX
                        || tableBallView.ballY > tableBallView.racketY + tableBallView.RACKET_HEIGHT))
                {
                    timer.cancel();
                    tableBallView.isLose = true;

                }
                // 小球在范围之内，且到达球拍位置，反弹
                else if ( tableBallView.ballY <= 0 ||
                        (tableBallView.ballY >= tableBallView.racketY - tableBallView.BALL_SIZE)
                        && tableBallView.ballX > tableBallView.racketX
                        && tableBallView.ballX <= tableBallView.racketX + tableBallView.RACKET_WIDTH)
                    ySpeed = -ySpeed;

                tableBallView.ballX += xSpeed;
                tableBallView.ballY += ySpeed;
                handler.sendEmptyMessage(0x123);
            }

        }, 0, 100);
    }
}
