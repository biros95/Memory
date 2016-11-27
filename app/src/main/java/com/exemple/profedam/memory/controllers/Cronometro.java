package com.exemple.profedam.memory.controllers;

import android.content.Intent;
import android.os.CountDownTimer;
import android.widget.TextView;

import com.exemple.profedam.memory.R;

public class Cronometro extends CountDownTimer {
    private TaulerActivity tauler;
    private long SegonsRestants;

    public Cronometro(long millisInFuture, long countDownInterval, TaulerActivity tauler) {
        super(millisInFuture, countDownInterval);
        this.tauler = tauler;

    }


    public long getSegonsRestants() {
        return SegonsRestants;
    }

    @Override
    public void onTick(long millisUntilFinished) {

        rellenarTextView("seconds remaining: " + millisUntilFinished / 1000);
        SegonsRestants=millisUntilFinished;
    }

    @Override
    public void onFinish() {
        Intent i = new Intent(tauler, FormularioActivity.class);
        tauler.startActivity(i);
    }

    public void rellenarTextView (String frase)
    {
        TextView cronometro = (TextView) tauler.findViewById(R.id.textTimeLeft);
        cronometro.setText(frase);
    }
};

