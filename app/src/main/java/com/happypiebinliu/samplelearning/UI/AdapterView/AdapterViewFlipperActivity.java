package com.happypiebinliu.samplelearning.UI.AdapterView;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterViewFlipper;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.happypiebinliu.samplelearning.R;

public class AdapterViewFlipperActivity extends AppCompatActivity {

    private int[] imageIds = new  int[]{
            R.drawable.listview_images1,
            R.drawable.listview_images2,
            R.drawable.listview_images3,
            R.drawable.listview_images4,
            R.drawable.listview_images5,
            R.drawable.imageview_image1,
            R.drawable.imageview_image2,
            R.drawable.imageview_image3,
            R.drawable.imageview_image4
    };
    private AdapterViewFlipper adapterViewFlipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapter_view_flipper);
        adapterViewFlipper = (AdapterViewFlipper) findViewById(R.id.flipper);

        BaseAdapter baseAdapter = new BaseAdapter() {
            @Override
            public int getCount() {
                return imageIds.length;
            }

            @Override
            public Object getItem(int i) {
                return imageIds[i];
            }

            @Override
            public long getItemId(int i) {
                return i;
            }

            @Override
            public View getView(int i, View view, ViewGroup viewGroup) {
                ImageView imageView = new ImageView(AdapterViewFlipperActivity.this);
                imageView.setImageResource(imageIds[i]);
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
                // 这里要返回一个ＩｍａｇｅＶｉｅｗ
                return imageView;
            }
        };
        adapterViewFlipper.setAdapter(baseAdapter);

    }
    public void prev (View source){
        adapterViewFlipper.showPrevious();
        adapterViewFlipper.stopFlipping();
    }

    public void next (View source){
        adapterViewFlipper.showNext();
        adapterViewFlipper.stopFlipping();
    }

    public void auto (View source){
        adapterViewFlipper.startFlipping();
    }
}
