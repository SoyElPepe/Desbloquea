package com.example.desbloqueacontuhuella;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView txtRecibeMensaje = findViewById(R.id.txtRecibeMensaje);
        Intent recibeMensaje = getIntent();
        String mesaje = recibeMensaje.getStringExtra(MainActivity.EXTRA_MESSAGE);
        txtRecibeMensaje.setText(mesaje);
    }
}