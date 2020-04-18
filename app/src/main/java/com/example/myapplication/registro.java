package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class registro extends AppCompatActivity {

    //creación de variables:
    EditText nombre;
    EditText apellido;
    EditText usuario;
    EditText email;
    EditText contrasenya;
    Button registro;


    @Override

    //Conectamos las variables con los elementos xml:

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        nombre=findViewById(R.id.txt_nombre);
        apellido=findViewById(R.id.txt_apellido);
        usuario=findViewById(R.id.txt_usuario);
        email=findViewById(R.id.txt_mail);
        contrasenya=findViewById(R.id.txt_contraseña);
        registro=findViewById(R.id.button_registro);

        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            registroUsuario();

            }
        });
    }

    //registro de usuarios:

    private void registroUsuario(){

        BaseDatos bd=new BaseDatos(this,"BaseDatos",null,1);
        bd.insetarDatos(nombre.getText().toString(),apellido.getText().toString(),usuario.getText().toString()
        ,email.getText().toString(),contrasenya.getText().toString());
        bd.obtenerDatos();
        Intent i=new Intent (this,MainActivity.class);
        startActivity(i);
    }


}
