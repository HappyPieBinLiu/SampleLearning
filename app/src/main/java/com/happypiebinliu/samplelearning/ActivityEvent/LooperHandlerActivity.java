package com.happypiebinliu.samplelearning.ActivityEvent;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.happypiebinliu.samplelearning.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 解决在UI线程中耗时操作，阻塞UI，用户界面失去响应
 * 关于Looper主线程中已经默认生成一个，所以Handler可以直接使用
 * 但是新的线程中，必须先定义一个Looper才能用Handler
 * looper---->messageQueue----->handler
 */
public class LooperHandlerActivity extends AppCompatActivity {

    static final String UPPER_NUM = "upper";
    EditText editTextNum;
    CalThread calThread;

    class CalThread extends Thread{
        public Handler handler;
        public void run(){
            Looper.prepare();
            handler = new Handler(){
                @Override
                public void handleMessage(Message msg) {
                    if (msg.what == 0x123){
                        int upper = msg.getData().getInt(UPPER_NUM);
                        List<Integer> nums = new ArrayList<Integer>();

                        outer:
                        // 从2开始计算，到upper所有的质数。
                        for (int i = 2; i <= upper; i++){
                            for (int j = 2; j <= Math.sqrt(i); j++){
                                if (i != 2 && i%j == 0){
                                    continue outer;
                                }
                            }
                            nums.add(i);
                        }
                        Toast.makeText(LooperHandlerActivity.this, nums.toString(), Toast.LENGTH_LONG).show();
                    }
                }
            };
            Looper.loop();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_looper_handler);
        editTextNum = (EditText) findViewById(R.id.editNum);
        calThread = new CalThread();
        calThread.start();
    }
    public void cal(View view){
        Message msg = new Message();
        msg.what = 0x123;
        Bundle bundle = new Bundle();
        bundle.putInt(UPPER_NUM, Integer.parseInt(editTextNum.getText().toString()));
        msg.setData(bundle);
        calThread.handler.sendMessage(msg);
    }
}
