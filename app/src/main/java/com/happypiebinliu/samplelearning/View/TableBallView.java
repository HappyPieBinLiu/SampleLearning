package com.happypiebinliu.samplelearning.View;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

import java.util.Random;

/**
 * Created by ope001 on 2017/01/06.
 * 弹球游戏的View
 */

public class TableBallView extends View {

    Random random = new Random();
    public boolean isLose = false;
    public int tableWidth = 0;
    public int tableHeight = 0;

    public int racketX = random.nextInt(200);
    public int racketY;
    public int ballX = random.nextInt(200) + 20;
    public int ballY = random.nextInt(10) + 20;
    public final int RACKET_HEIGHT = 30;
    public final int RACKET_WIDTH = 90;
    public final int BALL_SIZE = 16;


    Paint paint = new Paint();

    public TableBallView(Context context) {
        super(context);
        setFocusable(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        paint.setStyle(Paint.Style.FILL);
        // 设置去掉锯齿
        paint.setAntiAlias(true);
        if (isLose){
            paint.setColor(Color.RED);
            paint.setTextSize(50);
            canvas.drawText("Game Over!!!", tableWidth / 2 - 120, 200, paint);
        }else {
            // 绘制小球
            paint.setColor(Color.rgb(255, 0, 0));
            canvas.drawCircle(ballX, ballY, BALL_SIZE, paint);

            // 绘制球拍
            paint.setColor(Color.rgb(80, 80, 200));
            canvas.drawRect(racketX, racketY, racketX + RACKET_WIDTH, racketY + RACKET_HEIGHT, paint);
        }
    }
}
