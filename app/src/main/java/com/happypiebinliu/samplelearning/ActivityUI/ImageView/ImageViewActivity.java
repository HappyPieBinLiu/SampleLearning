package com.happypiebinliu.samplelearning.ActivityUI.ImageView;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.happypiebinliu.samplelearning.R;

/**
 * 图片浏览器
 * 上面用于查看照片整体，下面用于查看照片局部
 */
public class ImageViewActivity extends AppCompatActivity {

    // 访问一个图片数组
    int[] images = new int[] {
            R.drawable.imageview_image1,
            R.drawable.imageview_image2,
            R.drawable.imageview_image3,
            R.drawable.imageview_image4
    };
    int currentImage = 2;
    private  int alpha = 255;
    private Button plus, minus, next;
    private ImageView imageViewTop, imageViewSmall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);
        plus = (Button) findViewById(R.id.plusBtn);
        minus = (Button) findViewById(R.id.minusBtn);
        next = (Button) findViewById(R.id.nextBtn);
        imageViewTop = (ImageView) findViewById(R.id.imageViewTop);
        imageViewSmall = (ImageView) findViewById(R.id.imageViewSmall);

        next.setOnClickListener(new View.OnClickListener() {
            /**
             * 循环显示下一张图片
             * @param v
             */
            @Override
            public void onClick(View v) {
                imageViewTop.setImageResource(images[++ currentImage % images.length]);
            }
        });

        View.OnClickListener listener = new View.OnClickListener() {

            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                if (v == plus) alpha += 20;
                if (v == minus) alpha -= 20;
                if (alpha >= 255) alpha = 255;
                if (alpha <= 0) alpha = 0;
                imageViewTop.setImageAlpha(alpha);
            }
        };
        plus.setOnClickListener(listener);
        minus.setOnClickListener(listener);

        imageViewTop.setOnTouchListener(new View.OnTouchListener() {

            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                // 得到位图
                BitmapDrawable bitmapDrawable = (BitmapDrawable) imageViewTop.getDrawable();
                Bitmap bitmap = bitmapDrawable.getBitmap();
                double scale = 1.0 * bitmap.getHeight()/bitmap.getWidth();

                // 得到触点位置
                int X = (int) (event.getX() * scale);
                int Y = (int) (event.getY() * scale);

                // 显示区域的设定
                if (X + 120 > bitmap.getWidth()) X = bitmap.getWidth() -120;
                if (Y + 120 > bitmap.getHeight()) Y = bitmap.getHeight() - 120;

                // 显示
                imageViewSmall.setImageBitmap(Bitmap.createBitmap(bitmap, X, Y, 120, 120));
                imageViewSmall.setImageAlpha(alpha);

                return false;
            }
        });
    }
}
