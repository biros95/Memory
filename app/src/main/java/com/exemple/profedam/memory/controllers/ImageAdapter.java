package com.exemple.profedam.memory.controllers;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.exemple.profedam.memory.R;
import com.exemple.profedam.memory.model.Carta;
import com.exemple.profedam.memory.model.Partida;

import java.util.ArrayList;

public class ImageAdapter extends BaseAdapter {

    private Context mContext;
    private int numColumnas, anchoColumna, alturaColumna;
    private Partida partida;
   /* private Integer[] imatges = {
            R.drawable.c0, R.drawable.c1,
            R.drawable.c2, R.drawable.c3,
            R.drawable.c4, R.drawable.c5,
            R.drawable.c6, R.drawable.c7,
            R.drawable.c8, R.drawable.c9,
            R.drawable.c10, R.drawable.c11


    };
    */

    public ImageAdapter(Context c, Partida p) {

        mContext = c;
        this.partida = p;

    }


    public int getCount() {
        /* Devuelve el número de cartas a cargar o el número
        de elementos que tiene que mostrar el gridView
         */
        return partida.getNumeroCartes();
    }

    public Object getItem(int position) {
        return null;
    }




    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {  // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(280,320));
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setPadding(8, 8, 8, 8);
            imageView.setImageResource(partida.getLlistaCartes().get(position).getActive());
        } else {
            imageView = (ImageView) convertView;
        }

        return imageView;
    }

















}
