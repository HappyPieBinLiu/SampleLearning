package com.happypiebinliu.samplelearning.ActivityImage;

import android.content.res.AssetManager;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.happypiebinliu.samplelearning.R;

import java.io.IOException;
import java.io.InputStream;

/**
 * bitmap 位图
 * bitmapDrawable 构造器
 * bitmapFactory
 */
public class BitmapActivity extends AppCompatActivity {

    String[]  images = null;
    AssetManager assetManager = null;
    int curImage = 0;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bitmap);
        imageView = (ImageView) findViewById(R.id.imagebitmap);
        assetManager = getAssets();
        try {
            images = assetManager.list("");

        } catch (IOException e) {
            e.printStackTrace();
        }
        final Button bn = (Button) findViewById(R.id.button);
        bn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (curImage > images.length){
                    curImage = 0;
                }
                while (!images[curImage].endsWith(".png")
                        && !images[curImage].endsWith(".jpg")
                        && !images[curImage].endsWith(".gif"))
                {
                    curImage++;
                    if (curImage > images.length) curImage = 0;

                }
                InputStream assetFile = null;
                try {
                    assetFile = assetManager.open(images[curImage++]);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                BitmapDrawable bitmapDrawable = (BitmapDrawable) imageView.getDrawable();
                if (bitmapDrawable != null && !bitmapDrawable.getBitmap().isRecycled()){
                    bitmapDrawable.getBitmap().recycle();
                }
                // 改变ImageView的图片
                imageView.setImageBitmap(BitmapFactory.decodeStream(assetFile));
            }
        });
    }
}
