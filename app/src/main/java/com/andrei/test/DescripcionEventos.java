package com.andrei.test;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

public class DescripcionEventos  extends AppCompatActivity  {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.eventos_descripcion_layout);
        String eventoJSON = getIntent().getStringExtra("eventData");
        EventoItem evento = new Gson().fromJson(eventoJSON,EventoItem.class);

        TextView porcentaje = findViewById(R.id.porcentaje);
        TextView titulo = findViewById(R.id.titulo);
        TextView contenido  = findViewById(R.id.contenido);
        porcentaje.setText(evento.procentajeRecomendacion);
        titulo.setText(evento.titulo);
        contenido.setText(evento.contenido);


    }

}
