package com.chakouki.app_academic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class Service extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
    }

    // Start the service
    public void demarrerService(View view) {
        startService(new Intent(this, UnService.class));
    }
    // Stop the service
    public void arreterService(View view) {
        stopService(new Intent(this, UnService.class));
    }

    public class UnService extends Service {
        private static final String TAG = "MonService";
        private MediaPlayer lecteur;
        public UnService() {
        }
    }
}