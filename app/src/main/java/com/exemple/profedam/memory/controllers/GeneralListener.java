package com.exemple.profedam.memory.controllers;

import android.content.Intent;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;

import com.exemple.profedam.memory.model.Carta;
import com.exemple.profedam.memory.model.Partida;

import java.util.ArrayList;

public class GeneralListener implements AdapterView.OnItemClickListener, Runnable{

    private TaulerActivity tauler;
    private Carta cartaOnClick;
    private boolean isActive = true;
    private ArrayList<Carta> listaCartasFront;
    private int contador=0;

    public GeneralListener(TaulerActivity tauler) {
        this.tauler = tauler;
    }

    public int getContador() {
        return contador;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {


        Partida partida = tauler.getPartida();
        if (isActive) {
            //view.setVisibility(View.INVISIBLE);

            cartaOnClick = tauler.getPartida().getLlistaCartes().get(position);

            cartaOnClick.girar();

            tauler.refrescarTablero();

            listaCartasFront = partida.mostrarCartasFront();

            if (listaCartasFront.size() == 2 && listaCartasFront.get(0).getFrontImage() != listaCartasFront.get(1).getFrontImage()) {
                isActive = false;

                Handler delay = new Handler();
                delay.postDelayed(this, 1000);

            } else if (listaCartasFront.size() == 2) {
                listaCartasFront.get(0).setEstat(Carta.Estat.FIXED);
                listaCartasFront.get(1).setEstat(Carta.Estat.FIXED);
                comprovarFinal();
            }
        }
    }
    boolean comprovarFinal(){
        contador++;
        if (contador==tauler.getPartida().getNumeroCartes()/2){
            Intent i = new Intent(tauler, FormularioActivity.class);
            tauler.startActivity(i);
        }
    return true;
    }

    @Override
    public void run() {
        listaCartasFront.get(0).girar();
        listaCartasFront.get(1).girar();
        tauler.refrescarTablero();
        isActive = true;

    }
}

