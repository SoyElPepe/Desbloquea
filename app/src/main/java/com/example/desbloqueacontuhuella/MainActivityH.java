package com.example.desbloqueacontuhuella;


import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.biometric.BiometricPrompt;
import androidx.core.content.ContextCompat;


import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.Executor;

public class MainActivityH extends AppCompatActivity {

    private TextView tvAuthStatus;
    private Button btnAuth;

    private Executor executor;
    private BiometricPrompt biometricPrompt;
    private androidx.biometric.BiometricPrompt.PromptInfo promptInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainh);

        tvAuthStatus = findViewById(R.id.tvAuthStatus);
        btnAuth = findViewById(R.id.btnAuth);

        executor = ContextCompat.getMainExecutor(this);
        biometricPrompt = new BiometricPrompt(MainActivityH.this, executor, new BiometricPrompt.AuthenticationCallback(){
            @Override
            public void onAuthenticationError(int errorCode, CharSequence errString) {
                super.onAuthenticationError(errorCode, errString);
                tvAuthStatus.setText("Error de autenticación");
                Toast.makeText(MainActivityH.this, "Error de autenticación: " + errString, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAuthenticationSucceeded(BiometricPrompt.AuthenticationResult result) {
                super.onAuthenticationSucceeded(result);
                tvAuthStatus.setText("Autenticación exitosa :)");
                Toast.makeText(MainActivityH.this, "Autenticación exitosa", Toast.LENGTH_SHORT).show();
                Intent ira2 = new Intent(MainActivityH.this, MainActivity.class);
                startActivity(ira2);
            }

            @Override
            public void onAuthenticationFailed() {
                super.onAuthenticationFailed();
                tvAuthStatus.setText("Autenticación fallida :|");
                Toast.makeText(MainActivityH.this, "Autenticación fallida :|", Toast.LENGTH_SHORT).show();
            }
        });

        promptInfo = new BiometricPrompt.PromptInfo.Builder()
                .setTitle("Autenticación con huella dactilar")
                .setSubtitle("Iniciar sesión usando huella")
                .setDescription("Coloca tu huella sobre el sensor de huellas dactilares de tu dispositivo")
                .setNegativeButtonText("Usar contraseña")
                .build();

        btnAuth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                biometricPrompt.authenticate(promptInfo);

            }
        });


    }
}