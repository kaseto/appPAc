package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this,getText(R.string.texto_bienvenida),Toast.LENGTH_SHORT).show();
    }

    //Método botón regristro

    public void registro(View view){

        Intent btn_registro=new Intent(this,registro.class);
        startActivity(btn_registro);
    }

    //Método botón inicio de sesión:

    public void inicio(View view){

        Intent btn_inicio_sesion=new Intent (this,Inicio_sesion.class);
        startActivity(btn_inicio_sesion);
    }
}
