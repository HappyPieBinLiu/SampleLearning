package com.happypiebinliu.samplelearning.UI.Others;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.happypiebinliu.samplelearning.R;

/**
 * notification是一个系统服务，他会向全局推送消息
 */
public class NotificationActivity extends AppCompatActivity {

    static final   int NOTIFICATION_ID = 0x123;
    NotificationManager notificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

    }
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void send (View view){

        Intent intent = new Intent(NotificationActivity.this, OtherActivity.class);
        PendingIntent pi = PendingIntent.getActivities(NotificationActivity.this, 0, new Intent[]{intent}, 0);
        Notification notification = new Notification.Builder(this)
                .setAutoCancel(true)
                .setTicker("Have a message")
                .setSmallIcon(R.drawable.adapterview_rightmark)
                .setContentTitle("Info New Look!!!")
                .setContentText("恭喜你，你加工资啦！！！！")
                .setDefaults(Notification.DEFAULT_SOUND)
                .setWhen(System.currentTimeMillis())
                .setContentIntent(pi)
                .build();
        notificationManager.notify(NOTIFICATION_ID, notification);
    }
    public void del(View v){
        notificationManager.cancel(NOTIFICATION_ID);
    }
}
