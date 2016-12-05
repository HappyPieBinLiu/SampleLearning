package com.happypiebinliu.samplelearning.UI.Menu;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.happypiebinliu.samplelearning.R;

public class MenuFromXMLActivity extends AppCompatActivity {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_from_xml);
        textView = (TextView) findViewById(R.id.txt);
        registerForContextMenu(textView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = new MenuInflater(this);
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater inflater = new MenuInflater(this);
        inflater.inflate(R.menu.context, menu);
        menu.setHeaderTitle("Select the backgroun color");
        menu.setHeaderIcon(R.drawable.tool);
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.red:
                item.setChecked(true);
                textView.setBackgroundColor(Color.RED);
                break;
            case R.id.green:
                item.setChecked(true);
                textView.setBackgroundColor(Color.GREEN);
                break;
            case R.id.blue:
                item.setChecked(true);
                textView.setBackgroundColor(Color.BLUE);
                break;
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.isCheckable()){
            item.setCheckable(true);
        }
        switch (item.getItemId()){
            case R.id.font10:
                textView.setTextSize(10 * 2);
                break;
            case R.id.font12:
                textView.setTextSize(12 * 2);
                break;
            case R.id.font14:
                textView.setTextSize(14 * 2);
                break;
            case R.id.font16:
                textView.setTextSize(16 * 2);
                break;
            case R.id.font18:
                textView.setTextSize(18 * 2);
                break;
            case R.id.red:
                textView.setTextColor(Color.RED);
                break;
            case R.id.blue:
                textView.setTextSize(Color.BLUE);
                break;
            case R.id.green:
                textView.setTextSize(Color.GREEN);
                break;
            case R.id.plainItem:
                Toast.makeText(MenuFromXMLActivity.this, "普通菜单选项", Toast.LENGTH_LONG).show();
                break;
        }
        return true;
    }
}
