package com.example.eplanetas_a;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

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
                Toast.makeText(getApplicationContext(), "Seleccionaste: " + nombres[position], Toast.LENGTH_LONG).show();
            }
        });
    }
}
