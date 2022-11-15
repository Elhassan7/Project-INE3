package com.chakouki.app_academic;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;

import android.Manifest;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.net.URI;

public class MainActivity1 extends AppCompatActivity {

    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void sendNotification(View view) {
        NotificationChannel mChannel;
        int importance = NotificationManager.IMPORTANCE_DEFAULT;
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this, "default");

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.rockstargames.com/gta-v"));
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        String CHANNEL_ID = "channel_1";
        mBuilder.setContentIntent(pendingIntent);
        mBuilder.setSmallIcon(R.drawable.ic_launcher_foreground);
        mBuilder.setContentTitle("My Notification");
        mBuilder.setContentText("Hello World!");
        mChannel = new NotificationChannel(CHANNEL_ID, this.getString(R.string.app_name), importance);

        mChannel.setDescription("notification");
        NotificationManager mNotificationManger = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManger.createNotificationChannel(mChannel);
        mBuilder.setChannelId(CHANNEL_ID);
        mNotificationManger.notify(001, mBuilder.build());
    }
}