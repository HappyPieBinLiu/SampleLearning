package com.happypiebinliu.samplelearning.ActivityUI.Others;

import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import com.happypiebinliu.samplelearning.R;

public class DateTimePickerActivity extends AppCompatActivity {

    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_time_picker);

        final DatePicker datePicker = (DatePicker) findViewById(R.id.datePicker);
        TimePicker timePicker = (TimePicker) findViewById(R.id.timePicker);
        Calendar calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        hour = calendar.get(Calendar.HOUR);
        minute = calendar.get(Calendar.MINUTE);

        datePicker.init(year, month, day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int i, int i1, int i2) {
                DateTimePickerActivity.this.year = i;
                DateTimePickerActivity.this.month = i1;
                DateTimePickerActivity.this.day = i2;
                showDate(year, month, day, hour, minute);
            }
        });
        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker timePicker, int i, int i1) {
                DateTimePickerActivity.this.hour = i;
                DateTimePickerActivity.this.minute = i1;
                showDate(year, month, day, hour, minute);
            }
        });
    }

    private void showDate(int year, int month, int day, int hour, int minute) {
        EditText editText = (EditText) findViewById(R.id.show);
        editText.setText(year + "/" + (month+1) + "/" + day + "  " + hour + ":" + minute);
    }
}
