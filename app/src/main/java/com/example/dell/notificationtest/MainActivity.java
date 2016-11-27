package com.example.dell.notificationtest;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.
        OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button notification = (Button) findViewById(R.id.notification);
        notification.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        NotificationManager notificationManager = (NotificationManager)
                getSystemService(NOTIFICATION_SERVICE);
        Intent intent = new Intent(this,NotificationActivty.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent,
                0);
        Notification notification = new Notification.Builder(this)
                .setAutoCancel(true)
                .setContentTitle("This is content title")
                .setContentText("this is content text")
                .setTicker("this is ticker text")
                //Ticker没有看见在哪出现
                .setSmallIcon(R.mipmap.ic_launcher)
                .setWhen(System.currentTimeMillis())
                .setContentIntent(pendingIntent).build();
                //在新的api中使用.build()来代替.getNotification()
        notificationManager.notify(0,notification);
        //前面的id传入任意的值就可

    }
}
