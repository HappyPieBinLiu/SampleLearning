package com.happypiebinliu.samplelearning.UI.Menu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.view.MenuItem;
import android.view.View;

import com.happypiebinliu.samplelearning.R;

public class PopupMenuActivity extends AppCompatActivity {

    PopupMenu popupMenu = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_menu);
    }
    public void onPopupClick(View button){
        popupMenu = new PopupMenu(this, button);
        getMenuInflater().inflate(R.menu.menu_main, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.red:
                        popupMenu.dismiss();
                        break;
                }
                return true;
            }
        });
        popupMenu.show();
    }
}
