package com.happypiebinliu.samplelearning.ActivityImage;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.happypiebinliu.samplelearning.R;

public class DrawTextOnPathActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new TextView(this));

    }


    class TextView extends View{

        Path[] paths = new Path[3];
        Paint paint;

        public TextView(Context context) {
            super(context);
            paths[0] = new Path();
            paths[0].moveTo(0, 0);
            for (int i = 0; i < 20; i++){
                paths[0].lineTo(i * 30, (float) (Math.random() * 30));
            }
            paths[1] = new Path();
            RectF rectF = new RectF(0, 0, 600, 360);
            paths[1].addOval(rectF, Path.Direction.CCW);
            paths[2] = new Path();
            paths[2].addArc(rectF, 60, 180);
            // paint
            paint = new Paint();
            paint.setAntiAlias(true);
            paint.setColor(Color.RED);
            paint.setStrokeWidth(1);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            canvas.drawColor(Color.WHITE);
            canvas.translate(40, 40);
            paint.setTextAlign(Paint.Align.RIGHT);
            paint.setTextSize(20);
            paint.setStyle(Paint.Style.STROKE);
            canvas.drawPath(paths[0], paint);
            paint.setTextSize(40);
            paint.setStyle(Paint.Style.FILL);
            canvas.drawTextOnPath(String.valueOf(R.string.drawtextonpath), paths[0], -8, 20, paint);

            canvas.translate(0, 60);
            paint.setStyle(Paint.Style.STROKE);
            canvas.drawPath(paths[1], paint);
            paint.setTextSize(40);
            paint.setStyle(Paint.Style.FILL);
            canvas.drawTextOnPath(String.valueOf(R.string.drawtextonpath), paths[1], -20, 20, paint);

            canvas.translate(0, 360);
            paint.setStyle(Paint.Style.STROKE);
            canvas.drawPath(paths[2], paint);
            paint.setTextSize(40);
            paint.setStyle(Paint.Style.FILL);
            canvas.drawTextOnPath(String.valueOf(R.string.drawtextonpath), paths[2], -10, 20, paint);



        }
    }
}
