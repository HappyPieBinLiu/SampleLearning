package com.happypiebinliu.samplelearning.ActivityEvent;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.happypiebinliu.samplelearning.R;

/**
 * 外部类作为监听类
 */
public class SendSmsActivity extends AppCompatActivity {

    EditText address, content;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_sms);
        address = (EditText) findViewById(R.id.edit1);
        content = (EditText) findViewById(R.id.edit2);
        Button button = (Button) findViewById(R.id.btn1);
        button.setOnClickListener((View.OnClickListener) new SendSmsListener(this, address, content));

    }
}
