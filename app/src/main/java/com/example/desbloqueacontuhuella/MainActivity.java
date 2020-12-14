package com.example.desbloqueacontuhuella;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    /** Called when the user taps the Send button */
    public void sendMessage(View view) {

        EditText etnombre = findViewById(R.id.etNombre),
                etEmail = findViewById(R.id.etEmail),
                etAsunto = findViewById(R.id.etAsunto),
                etMensaje = findViewById(R.id.etMensaje);


        final Intent enviarMensaje = new Intent(this, MainActivity2.class);
        String nombre = etnombre.getText().toString();
        String email = etEmail.getText().toString();
        String asunto = etAsunto.getText().toString();
        String mensaje = etMensaje.getText().toString();

        String message = "Nombre: " + nombre +
                "\nEmail: " + email +
                "\nAsunto: " + asunto +
                "\nMensaje" + mensaje;

        enviarMensaje.putExtra(EXTRA_MESSAGE, message);
        startActivity(enviarMensaje);

    }

    public void limpiarFormulario(View view){
        EditText etnombre = findViewById(R.id.etNombre),
                etEmail = findViewById(R.id.etEmail),
                etAsunto = findViewById(R.id.etAsunto),
                etMensaje = findViewById(R.id.etMensaje);

        etnombre.setText("");
        etEmail.setText("");
        etAsunto.setText("");
        etMensaje.setText("");
    }
}
