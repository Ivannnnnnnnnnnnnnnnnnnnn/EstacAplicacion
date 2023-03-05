package com.android.app.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.android.app.entidades.Contactos;

import java.util.ArrayList;

public class DbContactos extends DbHelper {


    Context context;




    public DbContactos(@Nullable Context context){
        super(context, "agenda", null, 1);
        this.context = context;
    }



    public long guardarContactos(String email, String nombre, String apellido, String dni, String domicilio, String telefono,String patente,String modelo,String marca){

     long id = 0;
     try{
         DbHelper dbHelper = new DbHelper(context, "agenda", null, 1);
         SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("Email", email);
        values.put("Nombre", nombre);
        values.put("Apellido", apellido);
        values.put("Dni", dni);
        values.put("Domicilio", domicilio);
        values.put("Telefono", telefono);
         values.put("Patente",patente);
         values.put("Modelo",modelo);
        values.put("Marca",marca);

        id = db.insert(TABLE_CONTACTOS, null, values);

     }catch (Exception ex) {
            ex.toString();
     }
            return id;
    }


    public ArrayList<Contactos> mostrarContactos(){

        DbHelper dbHelper = new DbHelper(context, "agenda", null, 1);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ArrayList<Contactos> listaContactos = new ArrayList<>();
        Contactos contacto = null;
        Cursor cursorContactos = null;

        cursorContactos = db.rawQuery("SELECT * FROM " + TABLE_CONTACTOS, null);

        if (cursorContactos.moveToFirst()){
            do {
                contacto = new Contactos();
                contacto.setId(cursorContactos.getInt(0));
                contacto.setEmail(cursorContactos.getString(1));
                contacto.setNombre(cursorContactos.getString(2));
                contacto.setApellido(cursorContactos.getString(3));
                contacto.setDni(cursorContactos.getString(4));
                contacto.setDomicilio(cursorContactos.getString(5));
                contacto.setTelefono(cursorContactos.getString(6));
                contacto.setPatente(cursorContactos.getString(7));
                contacto.setModelo(cursorContactos.getString(8));
                contacto.setMarca(cursorContactos.getString(9));


                listaContactos.add(contacto);
            }while (cursorContactos.moveToNext());

        }

        cursorContactos.close();
        return listaContactos;
    }

    public Contactos verContactos(int id){

        DbHelper dbHelper = new DbHelper(context, "agenda", null, 1);
        SQLiteDatabase db = dbHelper.getWritableDatabase();


        Contactos contacto = null;
        Cursor cursorContactos = null;

        cursorContactos = db.rawQuery("SELECT * FROM " + TABLE_CONTACTOS + " WHERE id = " + id + " LIMIT 1 " , null);

        if (cursorContactos.moveToFirst()){

                contacto = new Contactos();
                contacto.setId(cursorContactos.getInt(0));
                contacto.setEmail(cursorContactos.getString(1));
                contacto.setNombre(cursorContactos.getString(2));
                contacto.setApellido(cursorContactos.getString(3));
                contacto.setDni(cursorContactos.getString(4));
                contacto.setDomicilio(cursorContactos.getString(5));
                contacto.setTelefono(cursorContactos.getString(6));

               contacto.setPatente(cursorContactos.getString(7));
               contacto.setModelo(cursorContactos.getString(8));
               contacto.setMarca(cursorContactos.getString(9));


        }

        cursorContactos.close();

        return contacto;
    }



    public boolean editarContacto(int id, String email, String nombre, String apellido, String dni, String domicilio, String telefono, String patente, String modelo, String marca){

      boolean correcto = false;

        DbHelper dbHelper = new DbHelper(context, "agenda", null, 1);
        SQLiteDatabase db = dbHelper.getWritableDatabase();


        try{
            db.execSQL("UPDATE " + TABLE_CONTACTOS + " SET Email = '"+email+"', nombre = '"+nombre+"', " +
                    "apellido = '"+apellido+"', dni = '"+dni+"', domicilio = '"+domicilio+"', telefono = '"+telefono+"', patente = '"+patente+"', modelo = '"+modelo+"', marca = '"+marca+"' WHERE id='"+ id +"' ");

            correcto = true;


        }catch (Exception ex) {
            ex.toString();
            correcto = false;
        }finally {
            db.close();
        }
        return correcto;
    }

}



