package com.example.eplanetas_a;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class AdaptadorPlanetas extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] nombres;
    private final String[] descripciones;
    private final Integer[] image;

    public AdaptadorPlanetas(@NonNull Activity context, String[] nombres, String[] descripciones, Integer[] image) {
        super(context, R.layout.item_planetas, nombres);
        this.context = context;
        this.nombres = nombres;
        this.descripciones = descripciones;
        this.image = image;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = context.getLayoutInflater();
            convertView = inflater.inflate(R.layout.item_planetas, parent, false);
        }

        TextView nombre = convertView.findViewById(R.id.nombre);
        TextView descripcion = convertView.findViewById(R.id.descripcion);
        ImageView imagen = convertView.findViewById(R.id.logo);

        nombre.setText(nombres[position]);
        descripcion.setText(descripciones[position]);
        imagen.setImageResource(image[position]);

        return convertView;
    }
}
