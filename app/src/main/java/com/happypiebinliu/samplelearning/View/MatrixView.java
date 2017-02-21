package com.happypiebinliu.samplelearning.View;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;

import com.happypiebinliu.samplelearning.R;

/**
 * Created by ope001 on 2017/02/01.
 */

public class MatrixView extends View {
    // 初始的图片资源
    private Bitmap bitmap;
    // Matrix
    private Matrix matrix = new Matrix();
    // 倾斜度
    private float sx = 0.0f;
    private int width , height;
    private float scale = 1.0f;
    // 判断是缩放还是旋转
    private boolean isScale = false;


    public MatrixView(Context context, AttributeSet attrs) {
        super(context, attrs);

        // 获得位图
        bitmap = ((BitmapDrawable)context.getResources().getDrawable(R.drawable.imageview_image1)).getBitmap();
        width = bitmap.getWidth();
        height = bitmap.getHeight();
        this.setFocusable(true);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 重设置Matrix
        matrix.reset();
        if (isScale)
            // 缩放
            matrix.setScale(scale, scale);
        else
           // 旋转
            matrix.setSkew(sx, 0);

        // 组建新的位图图片
        Bitmap bitmap1 = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
        canvas.drawBitmap(bitmap1, matrix, null);

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode){
            // 左箭头
            case KeyEvent.KEYCODE_DPAD_LEFT:
                isScale = false;
                sx += 0.1;
                postInvalidate();
                break;
            // 右箭头
            case KeyEvent.KEYCODE_DPAD_RIGHT:
                isScale = false;
                sx -= 0.1;
                postInvalidate();
                break;
            // 上箭头
            case KeyEvent.KEYCODE_DPAD_UP:
                isScale = true;
                if (scale < 2.0)
                    scale += 0.1;
                postInvalidate();
                break;
            // 下箭头
            case KeyEvent.KEYCODE_DPAD_DOWN:
                isScale = true;
                if (scale > 0.5)
                    scale -= 0.1;
                postInvalidate();
                break;
        }
        return super.onKeyDown(keyCode, event);
    }
}
