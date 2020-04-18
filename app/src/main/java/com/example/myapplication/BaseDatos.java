package com.example.myapplication;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.strictmode.SqliteObjectLeakedViolation;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//clase que extiende de SQLiteOpenhelper

public class BaseDatos extends SQLiteOpenHelper {

    //constructor

    public BaseDatos(@Nullable Context context,
                     @Nullable String name,
                     @Nullable SQLiteDatabase.CursorFactory factory,
                     int version) {
        super(context, name, factory, version);
    }

    //Funciones que crean la base de datos y la que la actualiza

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE usuarios ("+
                "id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "nombre TEXT,"+
                "apellido TEXT,"+
                "usuario TEXT,"+
                "email TEXT,"+
                "contrasenya TEXT);";
        db.execSQL(createTable);
    }

    //Funcion para insertar datos:

    public void insetarDatos(String nombre, String apellido, String usuario,String email,String contrasenya){
        SQLiteDatabase escribir=getWritableDatabase();
        String insert= "INSERT INTO usuarios(nombre,apellido,usuario,email,contrasenya)"+" VALUES(\""+nombre+
                "\"," + "\""+apellido+"\""+",\""+usuario+"\""+",\""+email+"\""+",\""+contrasenya+"\");";
        escribir.execSQL(insert);
        escribir.close();
    }

    // Funcion para conultar si el usuario y contraseña son correctos:

        public Cursor consultarUsPas(String usuario,String contrasenya)throws SQLException {
            Cursor cursor1=null;
            cursor1=this.getReadableDatabase().query("usuarios",new String[]{"id","nombre", "apellido","usuario","email","contrasenya"},"nombre like '"+usuario+
                    "'and contrasenya like '"+contrasenya+"'",null,null,null,null);
            return cursor1;
        }

    // Código utilizado para comprobar que la BBDD funcionaba correctamente:

         public  void obtenerDatos(){

        SQLiteDatabase leer=getReadableDatabase();
        String sql="SELECT *FROM usuarios";
        Cursor cursor= leer.rawQuery(sql,null);

        //cursor para recorrer los usuarios:

        cursor.moveToFirst();
        List<Usuario>usuarios=new ArrayList<>();
        do{
            //almacenamos los datos de cada usuario en un arrayList:

            usuarios.add(new Usuario(cursor.getInt(0),cursor.getString(1),
                    cursor.getString(2),cursor.getString(3)
                    ,cursor.getString(4),cursor.getString(5)));

        }while(cursor.moveToNext());
        Iterator it=usuarios.iterator();
        while(it.hasNext()){

            System.out.println(it.next().toString());

        }
        leer.close();
    }
}
