package com.andrei.test.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.andrei.test.EventoItem;
import com.andrei.test.R;

import java.net.URL;
import java.util.ArrayList;

public class EventosAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private ArrayList<EventoItem> eventos;
    
    public EventosAdapter(Context context, int layout, ArrayList<EventoItem> eventos){
        this.context = context;
        this.layout = layout;
        this.eventos = eventos;
    }

    @Override
    public int getCount() {
        return this.eventos.size();
    }

    @Override
    public Object getItem(int position) {
        return this.eventos.get(position);
    }

    @Override
    public long getItemId(int id) {
        return id;
    }

    @Override

    public View getView(int position, View convertView, ViewGroup viewGroup) {
        View v = convertView;
        LayoutInflater layoutInflater = LayoutInflater.from(this.context);
        v= layoutInflater.inflate(R.layout.item_eventos_list, null);
        String titulo  = eventos.get(position).getTitulo();
        String contenido  = eventos.get(position).getContenido();
        String imagePath  = eventos.get(position).getImagePath();
        String coicidencia   = eventos.get(position).getProcentajeRecomendacion();
        TextView tituloTv = (TextView) v.findViewById(R.id.titulotxt);
        TextView recomendacionTv = (TextView) v.findViewById(R.id.porcentaje_text);
        TextView contenidoTv = (TextView) v.findViewById(R.id.conttxt);
        ImageView imagen = (ImageView) v.findViewById(R.id.imagenEvento);


        try{
            URL url = new URL(imagePath);
            Bitmap bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            imagen.setImageBitmap(bmp);
        }catch (Exception e ){
            e.printStackTrace();
        }
         //TextView textView = (TextView) v.findViewById(R.id.porcentaje_text);
        tituloTv.setText(titulo);
        recomendacionTv.setText(coicidencia);
        contenidoTv.setText(contenido);
        return v;
    }
}
