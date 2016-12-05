package com.happypiebinliu.samplelearning.UI.Menu;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.happypiebinliu.samplelearning.R;
import com.happypiebinliu.samplelearning.UI.Others.OtherActivity;

public class SubMenuActivity extends AppCompatActivity {

    // 字体大小的菜单标识
    final int FONT_10 = 0x111;
    final int FONT_12 = 0x112;
    final int FONT_14 = 0x113;
    final int FONT_16 = 0x114;
    final int FONT_18 = 0x115;

    final int PLAIN_ITEM = 0x11b;

    final int FONT_RED = 0x116;
    final int FONT_BLUE = 0x117;
    final int FONT_GREEN = 0x118;

    private TextView editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_menu);
        editText = (TextView) findViewById(R.id.txt);
    }

    /**
     * 用户单击Menu时，触发这个方法
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        SubMenu subMenu = menu.addSubMenu("字体大小");
        subMenu.setIcon(R.drawable.font);
        subMenu.setHeaderIcon(R.drawable.font);
        subMenu.setHeaderTitle("选择字体大小");
        subMenu.add(0, FONT_10, 0, "10");
        subMenu.add(0, FONT_12, 0, "12");
        subMenu.add(0, FONT_14, 0, "14");
        subMenu.add(0, FONT_16, 0, "16");
        subMenu.add(0, FONT_18, 0, "18");
        menu.add(0, PLAIN_ITEM, 0, "普通菜单项");

        // Color
        SubMenu colorMenu = menu.addSubMenu("字体颜色");
        colorMenu.setIcon(R.drawable.color);
        colorMenu.setHeaderIcon(R.drawable.color);
        colorMenu.setHeaderTitle("选择字体颜色");
        colorMenu.add(0, FONT_RED, 0, "RED");
        colorMenu.add(0, FONT_BLUE, 0, "BLUE");
        colorMenu.add(0, FONT_GREEN, 0, "GREEN");

        // 用来启动其他的Activity
        SubMenu prog = menu.addSubMenu("启动程序TEST");
        prog.setHeaderIcon(R.drawable.tool);
        prog.setHeaderTitle("选择你要启动的程序。");
        MenuItem item = prog.add("LOOK other activity");
        item.setIntent(new Intent(this, OtherActivity.class));

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case FONT_10:
                editText.setTextSize(10 * 2);
                break;
            case FONT_12:
                editText.setTextSize(12 * 2);
                break;
            case FONT_14:
                editText.setTextSize(14 * 2);
                break;
            case FONT_16:
                editText.setTextSize(16 * 2);
                break;
            case FONT_18:
                editText.setTextSize(18 * 2);
                break;
            case FONT_RED:
                editText.setTextColor(Color.RED);
                break;
            case FONT_BLUE:
                editText.setTextSize(Color.BLUE);
                break;
            case FONT_GREEN:
                editText.setTextSize(Color.GREEN);
                break;
            case PLAIN_ITEM:
                Toast.makeText(SubMenuActivity.this, "普通菜单选项", Toast.LENGTH_LONG).show();
                break;
        }
        return true;
    }
}
