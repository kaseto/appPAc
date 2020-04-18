package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Callable;


public class Inicio_sesion extends AppCompatActivity {

    EditText nombre;
    EditText contrasenya;
    Button btninicio;

    BaseDatos helper=new BaseDatos(this,"BaseDatos",null,1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_sesion);

        btninicio=(Button)findViewById(R.id.boton_inicio);
        btninicio.setOnClickListener(new View.OnClickListener() {
           @Override
            public void onClick(View v) {
                nombre = (EditText) findViewById(R.id.txt_nombre2);
                contrasenya = (EditText) findViewById(R.id.txt_contraseña2);

                    //cursor que consulta si el usuario y contraseña son correctos:

                    try {
                        Cursor cursor = helper.consultarUsPas(nombre.getText().toString(), contrasenya.getText().toString());
                        if (cursor.getCount() > 0) {

                            //intent y datos que pasamos a la Activity Music mediante un Bundle:

                            Intent i = new Intent(Inicio_sesion.this, music.class);
                            i.putExtra("1", nombre.getText().toString());
                            i.putExtra("2", contrasenya.getText().toString());
                            startActivity(i);

                            //MEnsaje de Logueo correcto:

                            Toast.makeText(getApplicationContext(), getText(R.string.toast_registro), Toast.LENGTH_SHORT).show();

                        } else {

                            //MEnsaje de Logueo incorrecto:

                            Toast.makeText(getApplicationContext(), getText(R.string.toast_registro_incorrecto), Toast.LENGTH_SHORT).show();

                            //Vaciamos los EditText:

                            nombre.setText("");
                            contrasenya.setText("");
                            nombre.findFocus();
                      }

                    }catch (SQLException e){
                        e.printStackTrace();
                    }
            }
        });
        }



}
