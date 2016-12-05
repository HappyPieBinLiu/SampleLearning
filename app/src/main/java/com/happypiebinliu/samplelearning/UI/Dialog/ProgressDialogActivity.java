package com.happypiebinliu.samplelearning.UI.Dialog;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.happypiebinliu.samplelearning.R;

public class ProgressDialogActivity extends AppCompatActivity {

    final static int MAX_PROGRESS = 100;
    private int[] data = new int[50];
    private int progressStatic = 0;
    private int hasData = 0;
    ProgressDialog pd1, pd2;
    // 定义一个处理器，来处理更新进度
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 0x123){
                pd2.setProgress(progressStatic);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_dialog);
    }
    public void showSpinner(View view){
        ProgressDialog.show(this, "任务执行中", "任务执行中，请等待", false, true);
    }

    public void showIndeterminate(View view){
        pd1 = new ProgressDialog(ProgressDialogActivity.this);
        pd1.setTitle("任务正在执行中");
        pd1.setMessage("任务正在执行中，请等待");
        pd1.setCancelable(true);
        pd1.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        pd1.setIndeterminate(true);
        pd1.show();
    }

    public void showProgress(View view){
        progressStatic = 0;
        hasData = 0;
        pd2 = new ProgressDialog(ProgressDialogActivity.this);
        pd2.setMax(MAX_PROGRESS);
        pd2.setTitle("任务完成百分比");
        pd2.setMessage("耗时任务的完成百分比。。。");
        pd2.setCancelable(false);
        pd2.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        pd2.setIndeterminate(false);
        pd2.show();
        new Thread(){
            @Override
            public void run() {
                while (progressStatic < MAX_PROGRESS){
                    progressStatic = MAX_PROGRESS * doWork() / data.length;
                    handler.sendEmptyMessage(0x123);
                }
                if (progressStatic >= MAX_PROGRESS){
                    pd2.dismiss();
                }
            }
        }.start();

    }
    // 模拟一个耗时操作
    public int doWork(){
        data[hasData++] = (int) Math.random() * 100;
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return hasData;
    }
}
