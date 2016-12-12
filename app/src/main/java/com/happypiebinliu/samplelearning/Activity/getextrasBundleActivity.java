package com.happypiebinliu.samplelearning.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.happypiebinliu.samplelearning.Bean.User;
import com.happypiebinliu.samplelearning.R;

public class getextrasBundleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_getextras_bundle);
        TextView name = (TextView) findViewById(R.id.name);
        TextView password = (TextView) findViewById(R.id.password);
        TextView gender = (TextView) findViewById(R.id.gender);
        Intent intent = getIntent();
        User user = (User) intent.getSerializableExtra("USER");
        name.setText("用户名" + user.getName().toString());
        password.setText("密码" + user.getPassword().toString());
        gender.setText("性别" + user.getGender().toString());

    }
}
