package com.happypiebinliu.samplelearning.ActivityUI.Dialog;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;

import com.happypiebinliu.samplelearning.R;

public class DateTimePickerDialogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_time_picker_dialog);
        Button dateBtn = (Button) findViewById(R.id.btnDatePicker);
        Button timeBtn = (Button) findViewById(R.id.btnTimePicker);

        //　Date
        dateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar c = Calendar.getInstance();
                new DatePickerDialog(DateTimePickerDialogActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                    }
                }, c.get(Calendar.YEAR)
                ,c.get(Calendar.MONTH)
                ,c.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        // Time
        timeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar c = Calendar.getInstance();

                new TimePickerDialog(DateTimePickerDialogActivity.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                            }
                        }
                        , c.get(Calendar.HOUR_OF_DAY)
                        , c.get(Calendar.MINUTE)
                        , true).show();
            }
        });
    }
}
