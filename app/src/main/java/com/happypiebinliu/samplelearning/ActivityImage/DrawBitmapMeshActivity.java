package com.happypiebinliu.samplelearning.ActivityImage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import static android.R.attr.x;

public class DrawBitmapMeshActivity extends AppCompatActivity {

    private Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    private class MyView extends View{

        // 图片的划分
        private final int WIDTH = 20;
        private final int HEIGHT = 20;
        // 划分后的顶点
        private final int COUNT = (WIDTH + 1) * (HEIGHT + 1);
        // 保存顶点坐标
        private final float[] verts = new float[COUNT * 2];
        // 扭曲后的坐标
        private final float[] origs = new float[COUNT * 2];

        public MyView(Context context, AttributeSet attrs, int drawableId) {
            super(context);
            setFocusable(true);
            // 根据指定资源加载图片
            bitmap = BitmapFactory.decodeResource(getResources(), drawableId);
            // 获取图片的高与宽
            float bitmapWidth = bitmap.getWidth();
            float bitmapHeight = bitmap.getHeight();
            int index = 0;

            for (int y = 0; y <= HEIGHT; y++){
                float fy = bitmapHeight * y / HEIGHT;
                for (int i = 0 ; i <= WIDTH; i++){
                    float fx = bitmapWidth * x / WIDTH;
                    origs[index * 2 + 0] = verts[index * 2 +0 ] = fx;
                    origs[index * 2 + 1] = verts[index * 2 + 1 ] = fx;
                    index += 1;
                }
            }
            // 设置背景颜色
            setBackgroundColor(Color.WHITE);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            // 对图片按照verts数组坐标进行扭曲
            canvas.drawBitmapMesh(bitmap, WIDTH, HEIGHT, verts, 0, null, 0, null);
        }

        private void warp ( float cx, float cy){
            for (int i = 0; i < COUNT * 2; i += 2){
                float dx = cx - origs[i];
                float dy = cy -origs[i + 1];
                float dd = dx * dx + dy * dy;
                // 计算每一个坐标点和当前点（cx,cy）的距离
                float d = (float) Math.sqrt(dd);
                // 计算扭曲度，距离当前点距离越近扭曲度越小
                float pull  = 80000 / (dd * d);
                // 重新对verts数组进行赋值
                if (pull >= 1){
                    verts[i] = cx;
                    verts[i + 1] = cy;
                }
                else {
                    // 控制个顶点向触摸事件发生点偏移
                    verts[i] = origs[i] + dx * pull;
                    verts[i + 1] = origs[i + 1] + dy * pull;
                }
            }
            invalidate();
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            warp(event.getX(), event.getY());
            return true;
        }
    }

}
