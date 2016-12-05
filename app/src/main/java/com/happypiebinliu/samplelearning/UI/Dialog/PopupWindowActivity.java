package com.happypiebinliu.samplelearning.UI.Dialog;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.PopupWindow;

import com.happypiebinliu.samplelearning.R;

public class PopupWindowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_window);
        // 加载一个Popup的View
        View root = this.getLayoutInflater().inflate(R.layout.popup, null);
        final PopupWindow popupWindow = new PopupWindow(root, 560, 720);
        Button button = (Button) findViewById(R.id.btnPopup);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.showAsDropDown(v);
                // 	showAtLocation(View parent, int gravity, int x, int y)
                popupWindow.showAtLocation(findViewById(R.id.btnPopup), Gravity.CENTER, 20, 20);
            }
        });
        root.findViewById(R.id.btnClose).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
    }
}
