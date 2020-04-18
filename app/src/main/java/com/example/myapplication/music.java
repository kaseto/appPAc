package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static android.media.MediaPlayer.*;

public class music extends AppCompatActivity {

        //Creación de variable MediaPlayer:

    private MediaPlayer reproductor;
    TextView tvNombre;
    TextView tvContraseña;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

            //Iniciación del reproductor:

        reproductor = MediaPlayer.create(this, R.raw.song);
        reproductor.setLooping(true);
        reproductor.start();

        tvNombre=findViewById(R.id.nombre_pasado);
        tvContraseña=findViewById(R.id.contraseña_pasada);

            //Datos recibidos:

        Bundle extras=getIntent().getExtras();
        if (extras!=null){
            tvNombre.setText(extras.getString("1"));
            tvContraseña.setText(extras.getString("2"));
        }
    }

         //Métodos Play y Pause del reproductor:

    public void play (View view){
        reproductor.start();
    }
    public void pause(View view){
        reproductor.pause();
    }
}
