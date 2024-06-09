package com.example.eplanetas_a;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.BreakIterator;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Informacion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion);

        Intent intent = getIntent();
        if (intent != null) {
            int position = intent.getIntExtra("position", -1);
            if (position != -1) {

                String[] titulos = getResources().getStringArray(R.array.Titulo_planeta);
                String[] info1 = getResources().getStringArray(R.array.Info_1);
                String[] info2 = getResources().getStringArray(R.array.info_2);
                TypedArray imagen1 = getResources().obtainTypedArray(R.array.imagene_1);
                TypedArray imagen2 = getResources().obtainTypedArray(R.array.imagen2);

                TextView tituloInfo = findViewById(R.id.Tituloinfo);
                TextView textoIzquierdo = findViewById(R.id.texto_izquierdo);
                ImageView imagen1View = findViewById(R.id.imagen1);
                ImageView imagen2View = findViewById(R.id.imagen2);
                TextView textoCentrado = findViewById(R.id.texto_centrado);

                tituloInfo.setText(titulos[position]);
                textoIzquierdo.setText(info1[position]);
                imagen1View.setImageResource(imagen1.getResourceId(position, -1));
                imagen2View.setImageResource(imagen2.getResourceId(position, -1));
                textoCentrado.setText(info2[position]);

                imagen1.recycle();
                imagen2.recycle();
            }
        }
    }
}
