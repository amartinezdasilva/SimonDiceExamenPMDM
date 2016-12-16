package com.example.aaron.secuenciacolores;

import android.widget.Toast;

/**
 * Created by Aaron on 16/12/2016.
 */

public class ActivityExamen extends MainActivity{
    void Comprobar(){
        if(cont==4) {
            String x = randomColor.toString();
            String y = elegirColor.toString();

            if (x.equalsIgnoreCase(y)) {

                Toast.makeText(getApplicationContext(), "ACERTASTE", Toast.LENGTH_SHORT).show();

            } else {
                Toast.makeText(getApplicationContext(), "FALLO", Toast.LENGTH_SHORT).show();
            }

        }
    }
}
