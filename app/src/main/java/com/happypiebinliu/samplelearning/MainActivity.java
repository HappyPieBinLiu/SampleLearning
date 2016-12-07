package com.happypiebinliu.samplelearning;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.happypiebinliu.samplelearning.Event.HandlerActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.btn_test);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case  R.id.btn_test:
                Intent intent = new Intent(this, HandlerActivity.class);
                startActivity(intent);
                break;
        }
    }
}