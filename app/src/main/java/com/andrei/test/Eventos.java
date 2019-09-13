 package com.andrei.test;

 import android.content.Intent;
 import android.os.Bundle;
 import android.os.StrictMode;
 import android.util.Log;
 import android.view.View;
 import android.widget.AdapterView;
 import android.widget.ListView;

 import androidx.appcompat.app.AppCompatActivity;

 import com.andrei.test.adapters.EventosAdapter;
 import com.google.gson.Gson;

 import java.util.ArrayList;

 public class Eventos extends AppCompatActivity {

     @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.eventos);
         StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
         StrictMode.setThreadPolicy(policy);

         ListView listview = findViewById(R.id.eventosLisView);
         final ArrayList<EventoItem> events = new ArrayList<EventoItem>() ;
         EventoItem evento1 = new EventoItem();
         evento1.procentajeRecomendacion = "90% recomendado";
         evento1.imagePath = "https://www.clubamerica.com.mx/portal/wp-content/themes/cfamerica/img/header/ClubAmericaLogo.png";
         evento1.titulo  = "museo X";
         evento1.contenido = "texto";
         EventoItem evento2 = new EventoItem();
         evento2.procentajeRecomendacion = "45% recomendado";
         evento2.imagePath = "https://www.clubamerica.com.mx/portal/wp-content/themes/cfamerica/img/header/ClubAmericaLogo.png";
         evento2.titulo  = "GRAN GALERIA X";
         evento2.contenido = "texto";
         events.add(evento1);
         events.add(evento2);
         events.add(evento1);
         events.add(evento2);
         events.add(evento1);
         events.add(evento2);
         events.add(evento1);
         events.add(evento2);
         EventosAdapter eventosAdapter = new EventosAdapter(this, R.layout.item_eventos_list, events);
         listview.setAdapter(eventosAdapter);
         listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
             @Override
             public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                 Intent intent = new Intent(Eventos.this, DescripcionEventos.class);
                 String evento = new Gson().toJson(events.get(position));
                 intent.putExtra("eventData",evento);
                 startActivity(intent);             }
         });

     }
 }
