package com.example.eplanetas_a;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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
                String[] info3 = getResources().getStringArray(R.array.info_3);
                TypedArray imagen1 = getResources().obtainTypedArray(R.array.imagene_1);
                TypedArray imagen2 = getResources().obtainTypedArray(R.array.imagen2);
                TypedArray imagen3 = getResources().obtainTypedArray(R.array.imagen3);

                TextView tituloInfo = findViewById(R.id.Tituloinfo);
                TextView textoIzquierdo = findViewById(R.id.texto_izquierdo);
                ImageView imagen1View = findViewById(R.id.imagen1);
                ImageView imagen2View = findViewById(R.id.imagen2);
                TextView textoCentrado = findViewById(R.id.texto_centrado);
                TextView textoIzquierdo2 = findViewById(R.id.texto_izquierdo2);
                ImageView imagen3View = findViewById(R.id.imagen3);

                tituloInfo.setText(titulos[position]);
                textoIzquierdo.setText(info1[position]);
                imagen1View.setImageResource(imagen1.getResourceId(position, -1));
                imagen2View.setImageResource(imagen2.getResourceId(position, -1));
                textoCentrado.setText(info2[position]);
                textoIzquierdo2.setText(info3[position]);
                imagen3View.setImageResource(imagen3.getResourceId(position, -1));

                imagen1.recycle();
                imagen2.recycle();
                imagen3.recycle();
            }
        }

        Button btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Informacion.this, MainActivity.class);
                startActivity(intent);
            }
        });

        Button btnRegresar = findViewById(R.id.btnRegresar);
        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}


