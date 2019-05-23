package com.example.repruductor;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mirepo;
    MediaPlayer mirepo1;
    MediaPlayer mirepo2;
    MediaPlayer mirepo3;
    MediaPlayer mirepo4;
    MediaPlayer mirepo5;
    ImageView ivAlbum;
    int escuchando;
    int pop;
    String canciones[] = {"Cancion","hikaru nara","Get jinxed","Unshakeable","ignite","Cielo"};
    String autores[] = {"Desconocido","goose house","Illonka","Celldweller","Illonka","Aki-chan"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button btnplay = findViewById(R.id.btnplay);
        //final Button btnstop = findViewById(R.id.btnstop);
        final Button btnnext = findViewById(R.id.btnnext);
        final Button btnback = findViewById(R.id.btnback);
        //final Button btnpause = findViewById(R.id.btnPausa);
        ivAlbum = findViewById(R.id.imageView);
        final TextView txt1 = findViewById(R.id.textView);
        final TextView txt2 = findViewById(R.id.textView2);

        ivAlbum.setImageDrawable(getDrawable(R.drawable.ima));

        mirepo = MediaPlayer.create(MainActivity.this, R.raw.song);
        mirepo1 = MediaPlayer.create(MainActivity.this, R.raw.song1);
        mirepo2 = MediaPlayer.create(MainActivity.this, R.raw.song2);
        mirepo3 = MediaPlayer.create(MainActivity.this, R.raw.song3);
        mirepo4 = MediaPlayer.create(MainActivity.this, R.raw.song4);
        mirepo5 = MediaPlayer.create(MainActivity.this, R.raw.song5);

        btnplay.setBackgroundResource(R.drawable.playy);
        escuchando = 1;
        pop = 1;

        txt1.setText(""+canciones[escuchando-1]);
        txt2.setText(""+autores[escuchando-1]);

        btnplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(pop==1){
                    pop = 2;
                    Toast mensaje = Toast.makeText(getApplicationContext(),"Reproduciendo cancion "+escuchando,Toast.LENGTH_SHORT);
                    mensaje.show();
                    btnplay.setBackgroundResource(R.drawable.stop);
                    reproducir(escuchando);
                }else{
                    Toast mensaje = Toast.makeText(getApplicationContext(),"Pausando cancion "+escuchando,Toast.LENGTH_SHORT);
                    mensaje.show();
                    btnplay.setBackgroundResource(R.drawable.playy);
                    pop = 1;
                    pausar(escuchando);
                }

            }
        });



        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(escuchando>0){
                    escuchando--;
                    Toast mensaje = Toast.makeText(getApplicationContext(),"Reproduciendo cancion "+escuchando,Toast.LENGTH_SHORT);
                    mensaje.show();
                    btnplay.setBackgroundResource(R.drawable.stop);
                    pausar(escuchando+1);
                    txt1.setText(""+canciones[escuchando-1]);
                    txt2.setText(""+autores[escuchando-1]);
                    reproducir(escuchando);
                }else {
                    Toast mensaje = Toast.makeText(getApplicationContext(),"No hay mas canciones",Toast.LENGTH_SHORT);
                    mensaje.show();
                }

            }
        });

        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(escuchando<7){
                    escuchando++;
                    Toast mensaje = Toast.makeText(getApplicationContext(),"Reproduciendo cancion "+escuchando,Toast.LENGTH_SHORT);
                    mensaje.show();
                    btnplay.setBackgroundResource(R.drawable.stop);
                    pausar(escuchando-1);
                    txt1.setText(""+canciones[escuchando-1]);
                    txt2.setText(""+autores[escuchando-1]);
                    reproducir(escuchando);
                }else{
                    Toast mensaje = Toast.makeText(getApplicationContext(),"No hay mas canciones",Toast.LENGTH_SHORT);
                    mensaje.show();
                }

            }
        });

    }

    public void pausar (int cancion){
        switch (cancion){
            case 1:{
                mirepo.pause();
                break;
            }
            case 2:{
                mirepo1.pause();
                break;
            }
            case 3:{
                mirepo2.pause();
                break;
            }
            case 4:{
                mirepo3.pause();
                break;
            }
            case 5:{
                mirepo4.pause();
                break;
            }
            case 6:{
                mirepo5.pause();
                break;
            }
        }
    }

    public void detener (int cancion){
        switch (cancion){
            case 1:{
                mirepo.stop();
                break;
            }
            case 2:{
                mirepo1.stop();
                break;
            }
            case 3:{
                mirepo2.stop();
                break;
            }
            case 4:{
                mirepo3.stop();
                break;
            }
            case 5:{
                mirepo4.stop();
                break;
            }
            case 6:{
                mirepo5.stop();
                break;
            }
        }
    }

    public void reproducir (int cancion){
        switch (cancion){
            case 1:{
                ivAlbum.setImageDrawable(getDrawable(R.drawable.ima));
                mirepo.start();
                break;
            }
            case 2:{
                ivAlbum.setImageDrawable(getDrawable(R.drawable.ima1));
                mirepo1.start();
                break;
            }
            case 3:{
                ivAlbum.setImageDrawable(getDrawable(R.drawable.ima2));
                mirepo2.start();
                break;
            }
            case 4:{
                ivAlbum.setImageDrawable(getDrawable(R.drawable.ima3));
                mirepo3.start();
                break;
            }
            case 5:{
                ivAlbum.setImageDrawable(getDrawable(R.drawable.ima4));
                mirepo4.start();
                break;
            }
            case 6:{
                ivAlbum.setImageDrawable(getDrawable(R.drawable.ima5));
                mirepo5.start();
                break;
            }
        }
    }

}
