package com.happypiebinliu.samplelearning.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import com.happypiebinliu.samplelearning.Bean.User;
import com.happypiebinliu.samplelearning.R;

public class PutextrasBundleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_putextras_bundle);
        Button button = (Button) findViewById(R.id.bn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText name = (EditText) findViewById(R.id.name);
                EditText password = (EditText) findViewById(R.id.password);
                RadioButton male = (RadioButton) findViewById(R.id.male);
                String gender = male.isChecked() ? "男" : "女";
                User user = new User(name.toString(), password.toString(), gender);
                Bundle bundle = new Bundle();
                bundle.putSerializable("USER",  user);
                Intent intent = new Intent(PutextrasBundleActivity.this, getextrasBundleActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}
