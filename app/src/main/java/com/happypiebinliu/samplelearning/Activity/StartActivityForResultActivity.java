package com.happypiebinliu.samplelearning.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.happypiebinliu.samplelearning.R;

public class StartActivityForResultActivity extends AppCompatActivity {

    Button button;
    EditText city;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_for_result);
        button = (Button) findViewById(R.id.selectBn);
        city = (EditText) findViewById(R.id.city);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartActivityForResultActivity.this, SelectCityActivity.class);
                startActivityForResult(intent, 0);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 0 && resultCode == 0){
            Bundle datas = data.getExtras();
            String cityre = datas.getString("city");
            city.setText(cityre.toString());
        }
    }
}
