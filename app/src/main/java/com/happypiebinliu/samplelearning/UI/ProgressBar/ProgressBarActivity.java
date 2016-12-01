package com.happypiebinliu.samplelearning.UI.ProgressBar;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ProgressBar;

import com.happypiebinliu.samplelearning.R;

public class ProgressBarActivity extends AppCompatActivity {

    private int[] data = new int[100];
    int hasData = 0;
    int status = 0;
    ProgressBar bar, myBar;

    Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 0x111){
                bar.setProgress(status);
                myBar.setProgress(status);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 已经不推荐使用了，显示进度条的话，还需要更改主题
        requestWindowFeature(Window.FEATURE_PROGRESS);
        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);

        setContentView(R.layout.activity_progress_bar);

        bar = (ProgressBar) findViewById(R.id.bar);
        myBar = (ProgressBar) findViewById(R.id.mybar);
        new Thread(){
            @Override
            public void run() {
                while (status < 100){
                    status = doWork();
                    mHandler.sendEmptyMessage(0x111);
                }
            }
        }.start();

        Button btn1 = (Button) findViewById(R.id.btn1);
        Button btn2 = (Button) findViewById(R.id.btn2);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setProgressBarIndeterminateVisibility(true);
                setProgressBarVisibility(true);
                setProgress(4500);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setProgressBarIndeterminateVisibility(false);
                setProgressBarVisibility(false);
            }
        });
    }

    private int doWork() {
        data[hasData++] = (int) (Math.random() * 100);
        try{
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return hasData;
    }
}
