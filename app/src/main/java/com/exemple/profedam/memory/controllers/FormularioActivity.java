package com.exemple.profedam.memory.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;

import com.exemple.profedam.memory.R;
import com.exemple.profedam.memory.controllers.TaulerActivity;

public class FormularioActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);
        (findViewById(R.id.btn_BotonEmpezar)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(FormularioActivity.this, TaulerActivity.class);
                i.putExtra("cartas",calcularCartasDificultad());

                startActivity(i);
            }
        });
    }


    private int calcularCartasDificultad (){
        int numCartas;
        if (((RadioButton)findViewById(R.id.radio_muydificil)).isChecked()){
            numCartas=24;
        }
        else if (((RadioButton)findViewById(R.id.radio_dificil)).isChecked()){
            numCartas=18;
        }
        else if (((RadioButton)findViewById(R.id.radio_medio)).isChecked()){
            numCartas=12;
        }
        else {
            numCartas=8;
        }

        return numCartas;
    }
}
