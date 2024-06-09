package com.example.eplanetas_a;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class Lista_planetas extends AppCompatActivity {
    private ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_planetas);

        lista = findViewById(R.id.ListaView);

        String[] nombres = getResources().getStringArray(R.array.planetas_array);
        String[] descripciones = getResources().getStringArray(R.array.descripcionPlanetas);

        TypedArray images = getResources().obtainTypedArray(R.array.imagenesPlanetas);
        Integer[] image = new Integer[images.length()];
        for (int i = 0; i < images.length(); i++) {
            image[i] = images.getResourceId(i, -1);
        }
        images.recycle();

        AdaptadorPlanetas adapter = new AdaptadorPlanetas(this, nombres, descripciones, image);
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Iniciar la actividad Informacion y pasar la posición del planeta seleccionado
                Intent intent = new Intent(Lista_planetas.this, Informacion.class);
                intent.putExtra("position", position);
                startActivity(intent);
            }
        });
    }
}

