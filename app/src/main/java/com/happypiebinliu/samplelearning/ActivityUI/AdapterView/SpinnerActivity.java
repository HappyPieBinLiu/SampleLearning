package com.happypiebinliu.samplelearning.ActivityUI.AdapterView;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.happypiebinliu.samplelearning.R;

public class SpinnerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        String[] arr = new String[]{"Good Girl", "Perfect", "Smart", "I like you!"};
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, arr);
        spinner.setAdapter(arrayAdapter);
    }
}
