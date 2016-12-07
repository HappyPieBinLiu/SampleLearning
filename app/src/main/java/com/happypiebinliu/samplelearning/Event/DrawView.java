package com.happypiebinliu.samplelearning.Event;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class DrawView extends View {

    public float currentX = 40;
    public float currentY = 50;
    Paint paint = new Paint();

    public DrawView(Context context, AttributeSet set) {
        super(context, set);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(Color.RED);
        canvas.drawCircle(currentX, currentY, 15, paint);
    }

    // 采用回调的方式来处理这个触摸事件

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        currentX = event.getX();
        currentY = event.getY();
        this.invalidate();
        // 这里表明处理方法已经处理该事件，不会向外传播
        return true;
    }
}
