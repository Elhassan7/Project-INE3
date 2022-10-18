package com.chakouki.app_academic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "Activite est cree", Toast.LENGTH_SHORT).show();
        Log.i("onCreate()", "Activite est cree");

        int DELAY = 3000;
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(MainActivity.this, First_Activity.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        }, DELAY);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "Activite est demaree", Toast.LENGTH_SHORT).show();
        Log.i("onStart()","Activite est demaree");
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, "Activite est redemaree", Toast.LENGTH_SHORT).show();
        Log.i("onRestart()","Activite est redemaree");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "Activite est reprise", Toast.LENGTH_SHORT).show();
        Log.i("onResume()","Activite est reprise");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "Activite est en pause", Toast.LENGTH_SHORT).show();
        Log.i("onPause()","Activite est en pause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "Activite est onStop", Toast.LENGTH_SHORT).show();
        Log.i("onStop()","Activite est onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Activite est onStop", Toast.LENGTH_SHORT).show();
        Log.i("onDestroy()","Activite est detruite");
    }
}