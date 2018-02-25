package com.example.levie.levie_1202152324_m3;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //membuat toast
        Toast.makeText(this, "Levie Syafiraliany_1202152324", Toast.LENGTH_LONG).show();
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(), Login.class)); //pindah halaman ke login dengan menggunakan intent
            }
        }, 3000L); //untuk lama toast yang akan muncuk
    }
}