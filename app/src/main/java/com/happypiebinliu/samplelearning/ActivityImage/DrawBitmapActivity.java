package com.happypiebinliu.samplelearning.ActivityImage;

import android.graphics.BlurMaskFilter;
import android.graphics.EmbossMaskFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.LinearLayout;

import com.happypiebinliu.samplelearning.View.DrawView;

public class DrawBitmapActivity extends AppCompatActivity {

    EmbossMaskFilter emboss;
    BlurMaskFilter blur;
    DrawView drawView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout linearLayout = new LinearLayout(this);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        // 获取创建的宽度和高度
        getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
        drawView = new DrawView(this, displayMetrics.widthPixels, displayMetrics.heightPixels);
        linearLayout.addView(drawView);
        setContentView(linearLayout);
        emboss = new EmbossMaskFilter(new float[]{1.5f, 1.5f , 1.5f}, 0.6f, 6, 1.2f);
        blur = new BlurMaskFilter(8, BlurMaskFilter.Blur.NORMAL);

    }

    /**
     * 负责创建选项菜单
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = new MenuInflater(this);
        return super.onCreateOptionsMenu(menu);
    }
}
