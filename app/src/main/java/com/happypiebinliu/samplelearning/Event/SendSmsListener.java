package com.happypiebinliu.samplelearning.Event;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by ope001 on 2016/12/06.
 */

public class SendSmsListener implements View.OnLongClickListener {

    private Activity act;
    private  EditText address, content;

    public SendSmsListener(Activity act, EditText address, EditText content){
        this.act = act;
        this.address = address;
        this.content = content;
    }
    @Override
    public boolean onLongClick(View v) {
        String addressStr = address.getText().toString();
        String contentStr = content.getText().toString();

        SmsManager smsManager = SmsManager.getDefault();
        PendingIntent pendingIntent = PendingIntent.getBroadcast(act, 0, new Intent(), 0);
        smsManager.sendTextMessage(addressStr, null, contentStr, pendingIntent, null);
        Toast.makeText(act,"短信发送成功！！！", Toast.LENGTH_LONG ).show();
        return false;
    }
}
