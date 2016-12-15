package com.happypiebinliu.samplelearning.ActivityUI.ProgressBar;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.RatingBar;

import com.happypiebinliu.samplelearning.R;

public class RatingBarActivity extends AppCompatActivity {
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating_bar);
        imageView = (ImageView) findViewById(R.id.image);
        RatingBar ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                imageView.setImageAlpha((int) (rating * 255/5));
            }
        });
    }
}
