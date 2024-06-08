package com.example.eplanetas_a;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText usuarioEditText;
    EditText passwordEditText;
    Button iniciarButton;
    SharedPreferences sharedPreferences;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usuarioEditText = findViewById(R.id.usuario);
        passwordEditText = findViewById(R.id.password);
        iniciarButton = findViewById(R.id.iniciar);

        iniciarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = usuarioEditText.getText().toString();
                String pass = passwordEditText.getText().toString();

                if(user.equals("Adriana") && pass.equals("planetas")) {
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("usuario", user);
                    editor.apply();

                    String mensajePersonalizado = "Bienvenido estimado " + user + "que disfrute el planetario";
                    Toast.makeText(MainActivity.this, mensajePersonalizado, Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(MainActivity.this, MainActivity.class);
                    intent.putExtra("usuario", user);
                    startActivity(intent);
                } else {
                        Toast.makeText(MainActivity.this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}