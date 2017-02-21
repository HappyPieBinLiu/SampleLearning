package com.happypiebinliu.samplelearning.View;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;

import com.happypiebinliu.samplelearning.R;

import java.util.Timer;
import java.util.TimerTask;

public class MoveActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyView(this));
    }
    class MyView extends View{

        // 背景位图的实际高度
        final int BACK_HEIGHT = 1700;
        final int WEITH = 640;
        final int HEIGHT = 880;
        private Bitmap backBitmap;
        private Bitmap planeBitmap;
        private Matrix matrix = new Matrix();
        // 图片开始的位置
        private int startY = BACK_HEIGHT -HEIGHT;

        public MyView(Context context) {
            super(context);
            backBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.imageview_image2);
            // 窗口管理器
            WindowManager windowManager = getWindowManager();
            Display display = windowManager .getDefaultDisplay();
            DisplayMetrics metrics = new DisplayMetrics();
            display.getMetrics(metrics);
            // 获得屏幕的宽度
            float screenWidth = metrics.widthPixels;
            float scale = screenWidth/WEITH;
            matrix.setScale(scale, scale);
            planeBitmap =  BitmapFactory.decodeResource(context.getResources(), R.drawable.planered);

            final Handler handler = new Handler(){
                @Override
                public void handleMessage(Message msg) {
                    if (msg.what == 0x123){
                        if (startY <=  3){
                            startY = BACK_HEIGHT -HEIGHT;
                        }
                        else
                            startY -= 3;
                    }
                    invalidate();
                }
            };
            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    handler.sendEmptyMessage(0x123);
                }
            }, 0, 100);

        }

        @Override
        protected void onDraw(Canvas canvas) {
            Bitmap bitmapNew = Bitmap.createBitmap(backBitmap, 0, startY, WEITH, HEIGHT, matrix, false);
            canvas.drawBitmap(bitmapNew, 0, 0, null);
            canvas.drawBitmap(planeBitmap, 320, 700, null);
        }
    }
}
