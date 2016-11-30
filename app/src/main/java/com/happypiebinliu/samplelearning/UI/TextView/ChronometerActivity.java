package com.happypiebinliu.samplelearning.UI.TextView;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

import com.happypiebinliu.samplelearning.R;

/**
 * 计时器
 */
public class ChronometerActivity extends AppCompatActivity {

    private Chronometer chronometer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chronometer);
        chronometer = (Chronometer) findViewById(R.id.chronometer);
        final Button startBtn = (Button) findViewById(R.id.startBtn);
        final Button endBtn = (Button) findViewById(R.id.endBtn);

        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chronometer.setBase(SystemClock.elapsedRealtime());
                chronometer.start();
                startBtn.setEnabled(false);
            }
        });

        endBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chronometer.stop();
                startBtn.setEnabled(true);
            }
        });

        chronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                if (SystemClock.elapsedRealtime() - chronometer.getBase() > 10*1000){
                    chronometer.stop();
                    startBtn.setEnabled(true);
                }
            }
        });
    }
}
