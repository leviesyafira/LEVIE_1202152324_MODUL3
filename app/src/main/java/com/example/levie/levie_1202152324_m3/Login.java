package com.example.levie.levie_1202152324_m3;

import android.content.Intent;
import android.graphics.LightingColorFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    private EditText a,b;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //inisiasi EditText menggunakan id
        a = (EditText) findViewById(R.id.username);
        b = (EditText) findViewById(R.id.password);

    }

    //button login
    public void loginButton(View view) {
        String Username = a.getText().toString();
        String Password = b.getText().toString();
        String message; //untuk method message

        //permisalan untuk login jika berhasil dengan username EAD dan password MOBILE
        if (a.getText().toString().equals("EAD") && b.getText().toString().equals("MOBILE")) {
            message = "Login berhasil!";
            startActivity(new Intent(this, DaftarMinuman.class)); //pindah halaman ke daftar minuman
        } else { //permisalan login gagal
            message = "Login Gagal, Password atau Username salah";
            finish();
            startActivity(getIntent()); //memulai kembali ke halaman login
        }
        Toast.makeText(this, message, Toast.LENGTH_LONG).show(); //membuat toast untuk message
    }
}
