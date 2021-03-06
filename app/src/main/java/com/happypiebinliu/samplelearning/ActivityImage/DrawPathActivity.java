package com.happypiebinliu.samplelearning.ActivityImage;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ComposePathEffect;
import android.graphics.CornerPathEffect;
import android.graphics.DashPathEffect;
import android.graphics.DiscretePathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathDashPathEffect;
import android.graphics.PathEffect;
import android.graphics.SumPathEffect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class DrawPathActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new pathView(this));
    }

    // ----------------------------------------------------------
    class pathView extends View{

        float phase;
        PathEffect[] effects = new PathEffect[7];
        int[] colors;
        private Paint paint;
        Path path;

        public pathView(Context context) {
            super(context);
            // paint
            paint = new Paint();
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(4);
            // path
            path = new Path();
            path.moveTo(0, 0);
            // 随机生成40个点
            for (int i = 0; i < 40; i++){
                path.lineTo(i * 20, (float) (Math.random() * 60));
            }
            // color
            colors = new int[] {
                    Color.BLACK, Color.BLUE,Color.CYAN,Color.GREEN,Color.MAGENTA,Color.RED,Color.YELLOW
            };
        }

        @Override
        protected void onDraw(Canvas canvas) {
            canvas.drawColor(Color.WHITE);
            // 不使用路径效果
            effects[0] = null;
            // 6
            effects[1] = new CornerPathEffect(10);
            effects[2] = new DiscretePathEffect(3.0f, 5.0f);
            effects[3] = new DashPathEffect(new float[]{20, 10, 5, 10}, phase);
            Path  p = new Path();
            p.addRect(0, 0, 8, 8 , Path.Direction.CCW);
            effects[4] = new PathDashPathEffect(p, 12, phase, PathDashPathEffect.Style.ROTATE);
            effects[5] = new ComposePathEffect(effects[2], effects[4]);
            effects[6] = new SumPathEffect(effects[4], effects[3]);
            // 将画布移动到（8，8）开始绘画
            canvas.translate(8, 8);
            for (int i = 0; i < effects.length; i++){
                paint.setPathEffect(effects[i]);
                paint.setColor(colors[i]);
                canvas.drawPath(path, paint);
                canvas.translate(0, 60);
            }
            phase += 1;
            // 通知重新画（在UI线程。如果非UI线程需要用postInvalidate）
            invalidate();

        }
    }
}
