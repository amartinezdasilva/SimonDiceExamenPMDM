package com.example.aaron.secuenciacolores;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.*;
import java.util.logging.Handler;
import java.util.logging.LogRecord;


public class MainActivity extends AppCompatActivity {

    MediaPlayer mp1,mp2,mp3,mp4;


    Button botonverde, botonamarillo, botonrojo, botonazul, jugar;


    TimerTask timerTarea;
    Timer timer;
    String txtfa="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Creamos el Intent
        Intent intent = new Intent(MainActivity.this, ActivityExamen.class);
        //Creamos la información a pasar entre actividades
        Bundle b = new Bundle();
        b.putString("resultado",txtfa.toString());
        //añadimos la informacion al intent
        intent.putExtras(b);
        //iniciamos la nueva actividad
        startActivity(intent);



        mp1 = MediaPlayer.create(this, R.raw.sonido1);
        mp2 = MediaPlayer.create(this, R.raw.sonido2);
        mp3 = MediaPlayer.create(this, R.raw.sonido3);
        mp4 = MediaPlayer.create(this, R.raw.sonido4);

        jugar = (Button) findViewById(R.id.jugar);
        botonverde = (Button) findViewById(R.id.verde);
        botonrojo = (Button) findViewById(R.id.rojo);
        botonazul = (Button) findViewById(R.id.azul);
        botonamarillo = (Button) findViewById(R.id.amarillo);

        botonverde.setEnabled(false);
        botonrojo.setEnabled(false);
        botonazul.setEnabled(false);
        botonamarillo.setEnabled(false);

    }
    ArrayList<Integer> elegirColor = new ArrayList();
    ArrayList<Integer> randomColor = new ArrayList();


       protected static int cont=0;

     void eventoBotonJugar(View j){

         cont=0;
         jugar.setText("JUGANDO...");
         empezarTimer();
         botonverde.setEnabled(true);
         botonrojo.setEnabled(true);
         botonazul.setEnabled(true);
         botonamarillo.setEnabled(true);

     }

    void eventoVerde(View ve){
        botonverde = (Button) findViewById(R.id.verde);
        mp1.start();
        elegirColor.add(0);
        botonverde.setBackgroundColor(Color.GREEN);

        final long changeTime = 200L;
        botonverde.postDelayed(new Runnable() {
            @Override
            public void run() {
                botonverde.setBackgroundColor(Color.parseColor("#1EA307"));

            }
        }, changeTime);
        cont++;
        Comprobar();

    }
    void eventoRojo(View r){
        final Button botonrojo = (Button) findViewById(R.id.rojo);
        mp2.start();
        elegirColor.add(1);
        botonrojo.setBackgroundColor(Color.RED);
        final long changeTime = 200L;
        botonrojo.postDelayed(new Runnable() {
            @Override
            public void run() {
                botonrojo.setBackgroundColor(Color.parseColor("#CD3813"));

            }
        }, changeTime);
        cont++;
        Comprobar();

    }
    void eventoAzul(View a){
        final Button botonazul = (Button) findViewById(R.id.azul);
        mp3.start();
        elegirColor.add(2);
        botonazul.setBackgroundColor(Color.BLUE);
        final long changeTime = 200L;
        botonazul.postDelayed(new Runnable() {
            @Override
            public void run() {
                botonazul.setBackgroundColor(Color.parseColor("#136CF1"));

            }
        }, changeTime);
        cont++;
        Comprobar();

    }

    void eventoAmarillo(View a){
        final Button botonamarillo = (Button) findViewById(R.id.amarillo);
        mp4.start();
        elegirColor.add(3);
        botonamarillo.setBackgroundColor(Color.YELLOW);
        final long changeTime = 200L;
        botonamarillo.postDelayed(new Runnable() {
            @Override
            public void run() {
                botonamarillo.setBackgroundColor(Color.parseColor("#D4E113"));

            }
        }, changeTime);
        cont++;
        Comprobar();

    }



    public void empezarTimer(){
        timer = new Timer();
        inicializarTimer();
        timer.schedule(timerTarea, 0, 1000);
    }
    public void pararTimer(){
        if (timer !=null){
            timer.cancel();
            timer= null;
        }
    }
    void inicializarTimer (){
        timerTarea = new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        int numero=aleatorio();
                        randomColor.add(numero);
                        if (numero == 0) {
                            botonverde.setBackgroundColor(Color.GREEN);
                            mp1.start();
                            botonverde.postDelayed(new Runnable() {
                                public void run() {
                                    botonverde.setBackgroundColor(Color.parseColor("#1EA307"));
                                }
                            }, 500);

                        }

                        if (numero == 1) {
                            botonrojo.setBackgroundColor(Color.RED);
                            mp2.start();
                            botonrojo.postDelayed(new Runnable() {
                                public void run() {
                                    botonrojo.setBackgroundColor(Color.parseColor("#CD3813"));
                                }
                            }, 500);


                        }
                        if (numero == 2) {
                            botonazul.setBackgroundColor(Color.BLUE);
                            mp3.start();
                            botonazul.postDelayed(new Runnable() {
                                public void run() {
                                    botonazul.setBackgroundColor(Color.parseColor("#136CF1"));
                                }
                            }, 500);

                        }
                        if (numero == 3) {
                            botonamarillo.setBackgroundColor(Color.YELLOW);
                            mp4.start();
                            botonamarillo.postDelayed(new Runnable() {
                                public void run() {
                                    botonamarillo.setBackgroundColor(Color.parseColor("#D4E113"));
                                }
                            }, 500);


                            }
                        cont++;
                        if(cont==4){
                            pararTimer();
                            cont=0;
                        }

                    }
                });

            }
        };


    }

    void Comprobar(){
            if(cont==4) {



                String x = randomColor.toString();
                String y = elegirColor.toString();

                if (x.equalsIgnoreCase(y)) {
                    txtfa="Acertaste";
                    jugar.setText("JUEGA OTRA VEZ");
                    Toast.makeText(getApplicationContext(), "HAS GANADO, JUEGA OTRA VEZ", Toast.LENGTH_SHORT).show();

                } else {
                    txtfa="fallo";
                    jugar.setText("INTENTALO DE NUEVO");
                    Toast.makeText(getApplicationContext(), "HAS PERDIDO, INTENTALO DE NUEVO", Toast.LENGTH_SHORT).show();
                }
                randomColor.clear();
                elegirColor.clear();

            }

    }


    public int aleatorio(){

            int numColor = (int) Math.floor(Math.random()*4);

            return numColor;


    }



}