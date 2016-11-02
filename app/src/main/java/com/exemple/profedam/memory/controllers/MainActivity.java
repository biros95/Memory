package com.exemple.profedam.memory.controllers;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.GridView;

import com.exemple.profedam.memory.R;
import com.exemple.profedam.memory.model.Partida;

public class MainActivity extends Activity {

    private GridView gv;
    private Partida partida;
    private ImageAdapter adapter;


    public GridView getGv() {
        return gv;
    }

    public void setGv(GridView gv) {
        this.gv = gv;
    }

    public Partida getPartida() {
        return partida;
    }

    public void setPartida(Partida partida) {
        this.partida = partida;
    }

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gv = (GridView) findViewById(R.id.gridViewMemory);

        this.partida = new Partida(12);
        adapter = new ImageAdapter(this, partida);
        GeneralListener listener = new GeneralListener(this);
        gv.setAdapter(adapter);
        gv.setOnItemClickListener(listener);

    }
    public void refrescarTablero()
    {
        gv.setAdapter(adapter);
        gv.refreshDrawableState();
    }

}


