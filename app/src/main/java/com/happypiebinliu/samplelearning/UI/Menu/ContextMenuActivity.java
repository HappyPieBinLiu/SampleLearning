package com.happypiebinliu.samplelearning.UI.Menu;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.happypiebinliu.samplelearning.R;

public class ContextMenuActivity extends AppCompatActivity {

    final int MENU1 = 0x111;
    final int MENU2 = 0x112;
    final int MENU3 = 0x113;
    private TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_context_menu);
        textView = (TextView) findViewById(R.id.txt);
        // 为文本框注册上下文菜单
        registerForContextMenu(textView);

    }

    /**
     * 长按文本框的时候会生成菜单
     * @param menu
     * @param v
     * @param menuInfo
     */
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        menu.add(0, MENU1, 0 ,"RED");
        menu.add(0, MENU2, 0 ,"GREEN");
        menu.add(0, MENU3, 0 ,"BLUE");
        menu.setGroupCheckable(0, true, true);
        menu.setHeaderIcon(R.drawable.tool);
        menu.setHeaderTitle("选择背景颜色");
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case MENU1:
                item.setChecked(true);
                textView.setBackgroundColor(Color.RED);
                break;
            case MENU2:
                item.setChecked(true);
                textView.setBackgroundColor(Color.GREEN);
                break;
            case MENU3:
                item.setChecked(true);
                textView.setBackgroundColor(Color.BLUE);
                break;
        }
        return true;
    }
}
