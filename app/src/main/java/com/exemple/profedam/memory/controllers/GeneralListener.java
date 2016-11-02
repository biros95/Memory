package com.exemple.profedam.memory.controllers;

import android.content.Intent;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.exemple.profedam.memory.model.Carta;


/**
 * Created by ALUMNEDAM on 02/02/2016.
 */
public class GeneralListener implements AdapterView.OnItemClickListener{

    private MainActivity tauler;


    public GeneralListener(MainActivity tauler) {
        this.tauler = tauler;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

             Carta cartaOnClick = tauler.getPartida().getLlistaCartes().get(position);
        cartaOnClick.girar();
        tauler.refrescarTablero();



        Toast.makeText (tauler, "position" + position, Toast.LENGTH_SHORT).show();

            }
    }

