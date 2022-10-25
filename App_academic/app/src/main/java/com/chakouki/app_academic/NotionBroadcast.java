package com.chakouki.app_academic;

import androidx.appcompat.app.AppCompatActivity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.os.Bundle;

public class NotionBroadcast extends AppCompatActivity {

    private BroadcastReceiver monReceiver;

    /**
     * Appele lorsque l activite est creee.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__broadcast);
        IntentFilter filtre = new IntentFilter();
        filtre.addAction("com.aseds.CUSTOM_INTENT");
        monReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                Toast.makeText(context, "Intent Détecté.", Toast.LENGTH_LONG).show();
            }
        };
        registerReceiver(monReceiver, filtre);
    }

    // diffuser un intent particulier
    public void broadcastIntent(View view) {
        Intent intent = new Intent();
        intent.setAction("com.aseds.CUSTOM_INTENT");
        sendBroadcast(intent);
    }

    public void onDestroy() {
        super.onDestroy();
        if (monReceiver != null)
            unregisterReceiver(monReceiver);
        monReceiver = null;
    }
}