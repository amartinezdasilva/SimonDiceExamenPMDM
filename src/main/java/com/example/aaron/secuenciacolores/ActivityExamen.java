package com.example.aaron.secuenciacolores;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Aaron on 16/12/2016.
 */

public class ActivityExamen extends MainActivity{// extendemos de la MainActivity para poder acceder a todos sus metodos
    private TextView txtfalloacierto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_examen);

        //Localizar los controles
        txtfalloacierto = (TextView)findViewById(R.id.txtfalloacierto);


        //Recuperamos la información pasada en el intent
        Bundle bundle = this.getIntent().getExtras();

        //Construimos el mensaje a mostrar
        txtfalloacierto.setText(bundle.getString("resultado"));
    }
}


