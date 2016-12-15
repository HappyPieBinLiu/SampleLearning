package com.happypiebinliu.samplelearning.ActivityUI.ViewAnimator;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import com.happypiebinliu.samplelearning.R;

/**
 * 继承了ＶｉｅｗＳｗｉｔｃｈｅｒ
 */
public class TextSwitcherActivity extends AppCompatActivity {

    TextSwitcher textSwitcher;
    String[] strings = new String[]{
            "I love you.",
            "Yes, I love you so much.",
            "I will be happy....",
            "I am so smart."
    };
    int curStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_switcher);
        textSwitcher = (TextSwitcher) findViewById(R.id.textSwitcher);
        textSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                TextView textView = new TextView(TextSwitcherActivity.this);
                textView.setTextSize(40);
                textView.setTextColor(Color.MAGENTA);
                return textView;
            }
        });
        next(null);
    }

    public void next(View view) {
        textSwitcher.setText(strings[curStr++ % strings.length]);
    }
}
