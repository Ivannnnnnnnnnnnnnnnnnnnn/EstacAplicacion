package com.android.app;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {


    Button btn_datos_personales,btn_info,btn_mapa, btn_reserva;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        btn_datos_personales=(Button)findViewById(R.id.btn_datos_personales);
        btn_info=(Button)findViewById(R.id.btn_info);
        btn_mapa=(Button)findViewById(R.id.btn_mapa);
        btn_reserva=(Button)findViewById(R.id.btn_reserva);


        btn_datos_personales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(), Principal.class);
                startActivityForResult(intent, 0);


            }
        });

        btn_mapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Mapa.class);
                startActivityForResult(intent, 0);
            }
        });

        btn_reserva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Reserva.class);
                startActivityForResult(intent, 0);
            }
        });
        btn_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), informacionn.class);
                startActivityForResult(intent, 0);
            }
        });



    }


    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_principal, menu);
        return true;
     }

     public  boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){

            case R.id.cerrar_sesion:
                cerrarsesion();

                return true;

            default:
                return super.onOptionsItemSelected(item);

        }
     }



    private void cerrarsesion() {

        new AlertDialog.Builder(this)

                .setTitle("¿Realmente desea cerrar la aplicación?")
                .setCancelable(false)
                .setNegativeButton(android.R.string.cancel, null)
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        android.os.Process.killProcess(android.os.Process.myPid());

                    }
                }).show();

    }


    @Override
    public void onBackPressed() {

        new AlertDialog.Builder(this)

                .setTitle("¿Realmente desea cerrar la aplicación?")
                .setCancelable(false)
                .setNegativeButton(android.R.string.cancel, null)
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        android.os.Process.killProcess(android.os.Process.myPid());

                    }
                }).show();


    }




}