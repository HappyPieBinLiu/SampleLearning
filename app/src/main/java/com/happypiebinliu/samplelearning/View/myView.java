package com.happypiebinliu.samplelearning.View;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

import com.happypiebinliu.samplelearning.R;

/**
 * Created by ope001 on 2016/12/21.
 */

public class myView extends View {
    public myView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 设定画布为白色
        canvas.drawColor(Color.WHITE);
        Paint paint = new Paint();
        // 去掉锯齿，对画笔样式进行设定
        paint.setAntiAlias(true);
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(4);
        int viewWidth = getWidth();

        // circle
        canvas.drawCircle(viewWidth/10+10, viewWidth/10+10,viewWidth/10,paint);
        // 正方形
        canvas.drawRect(10, viewWidth/5 +20,viewWidth/5 +10, viewWidth*2/5 +10, paint);
        // 矩矩形
        canvas.drawRect(10, viewWidth*2/5+30,viewWidth/5 +10, viewWidth/2 +30, paint);
        // 圆角矩形
        RectF rel = new RectF(10, viewWidth/2+40,viewWidth/5 +10, viewWidth*3/5 +40);
        canvas.drawRoundRect(rel, 15, 15, paint);
        // 绘制椭圆
        RectF rell = new RectF(10, viewWidth*3/5+50,viewWidth/5 +10, viewWidth*7/10 +50);
        canvas.drawOval(rell, paint);
        // 定义一个Path对象，三角形
        Path path1 = new Path();
        path1.moveTo(10, viewWidth*9/10+60);
        path1.lineTo(viewWidth/5+10, viewWidth*9/10+60);
        path1.lineTo(viewWidth/10+10, viewWidth*7/10+60);
        path1.close();
        canvas.drawPath(path1, paint);
        //------设置填充风格后绘制
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.BLUE);
        // 五角星
        Path path2 = new Path();
        path2.moveTo(20+viewWidth*4/15, viewWidth*9/10+70);
        path2.lineTo(20+viewWidth/3, viewWidth*9/10+70);
        path2.lineTo(20+viewWidth*2/5, viewWidth+70);
        path2.lineTo(20+viewWidth*3/10, viewWidth*11/10+70);
        path2.lineTo(20+viewWidth/5, viewWidth+70);
        path2.close();
        canvas.drawPath(path2, paint);
        //--------画笔设置了渐变
        Shader mShader = new LinearGradient(0,0,40,60,new int[]{Color.RED, Color.GREEN, Color.BLUE,Color.YELLOW}
        ,null ,Shader.TileMode.REPEAT);
        paint.setShader(mShader);
        // 阴影
        paint.setShadowLayer(25, 20, 20, Color.GRAY);
        // 五角星
        Path path3 = new Path();
        path3.moveTo(30+viewWidth*7/15, viewWidth*9/10+70);
        path3.lineTo(30+viewWidth*8/15, viewWidth*9/10+70);
        path3.lineTo(30+viewWidth*3/5, viewWidth+70);
        path3.lineTo(30+viewWidth/2, viewWidth*11/10+70);
        path3.lineTo(30+viewWidth*2/5, viewWidth+70);
        path3.close();
        canvas.drawPath(path3, paint);
        // -----------字符大小
        paint.setTextSize(48);
        paint.setShader(null);
        canvas.drawText(getResources().getString(R.string.circle), 60+viewWidth*3/5, viewWidth/10+10,paint);
        canvas.drawText(getResources().getString(R.string.square), 60+viewWidth*3/5, viewWidth*3/10+20,paint);
        canvas.drawText(getResources().getString(R.string.rect), 60+viewWidth*3/5, viewWidth/2+20,paint);
        canvas.drawText(getResources().getString(R.string.round_rect), 60+viewWidth*3/5, viewWidth*3/5+30,paint);
        canvas.drawText(getResources().getString(R.string.oval), 60+viewWidth*3/5, viewWidth*7/10+30,paint);
        canvas.drawText(getResources().getString(R.string.triangle), 60+viewWidth*3/5, viewWidth*9/10+30,paint);
        canvas.drawText(getResources().getString(R.string.pentagon), 60+viewWidth*3/5, viewWidth*11/10+30,paint);



    }
}
