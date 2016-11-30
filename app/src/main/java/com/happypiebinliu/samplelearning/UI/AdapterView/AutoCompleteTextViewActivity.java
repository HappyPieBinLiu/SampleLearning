package com.happypiebinliu.samplelearning.UI.AdapterView;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;

import com.happypiebinliu.samplelearning.R;

/**
 * 这是自动完成的文本框
 * 这个Ｖｉｅｗ是继承ＥｄｉｔＴｅｘｔ的组件，应为这里利用了Ａｄａｐｔｅｒ所以放在了这里
 * 它实际上是一个文本编辑框
 */
public class AutoCompleteTextViewActivity extends AppCompatActivity {

    private AutoCompleteTextView autoCompleteTextView;
    private MultiAutoCompleteTextView multiAutoCompleteTextView;

    private String[] array = new String[]{"n女神", "n女汉子", "n女性", "n女"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_complete_text_view);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, array);
        autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);
        multiAutoCompleteTextView = (MultiAutoCompleteTextView) findViewById(R.id.multiAutoCompleteTextView);
        autoCompleteTextView.setAdapter(arrayAdapter);
        multiAutoCompleteTextView.setAdapter(arrayAdapter);
        // 分隔符
        multiAutoCompleteTextView.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
    }
}
