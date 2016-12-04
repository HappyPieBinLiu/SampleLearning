package com.happypiebinliu.samplelearning.UI.Others;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.NumberPicker;
import android.widget.Toast;

import com.happypiebinliu.samplelearning.R;

public class NumberPickerActivity extends AppCompatActivity {

    int minPrice = 25, maxPrice = 75;
    NumberPicker numberPicker1, numberPicker2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number_picker);
        numberPicker1 = (NumberPicker) findViewById(R.id.numberPicker1);
        numberPicker1.setMinValue(10);
        numberPicker1.setMaxValue(60);
        numberPicker1.setValue(minPrice);
        numberPicker1.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int oldVal, int newVal) {
                minPrice = newVal;
                showSelectPrice();
            }
        });

        numberPicker2 = (NumberPicker) findViewById(R.id.numberPicker2);
        numberPicker2.setMinValue(60);
        numberPicker2.setMaxValue(100);
        numberPicker2.setValue(maxPrice);
        numberPicker2.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int oldVal, int newVal) {
                maxPrice = newVal;
                showSelectPrice();
            }
        });

    }

    private void showSelectPrice() {
        Toast.makeText(NumberPickerActivity.this, "MinPrice is *:::" + minPrice + "MaxPrice is ::::"+ maxPrice , Toast.LENGTH_LONG).show();
    }
}
