package com.happypiebinliu.samplelearning.Event;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

import com.happypiebinliu.samplelearning.R;

/**
 * 飞机移动的组件Ｖｉｅｗ
 */
public class PlaneView extends View {

    public float currentX;
    public float currentY;
    Bitmap plane;
    Paint paint = new Paint();

    public PlaneView(Context context) {
        super(context);
        plane = BitmapFactory.decodeResource(context.getResources(), R.drawable.planered);
        setFocusable(true);
    }

    /**
     * 重写这个函数，可以动态的运行飞机
     * @param canvas
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(plane, currentX, currentY, paint);
    }
}
