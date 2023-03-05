package com.android.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


import androidx.appcompat.app.AppCompatActivity;

import com.android.app.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity  {


    private ActivityMainBinding binding;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }




























    //LLama a Iniciar sesion
    public void irIniciar(View view){

        Intent i =new Intent(this , IniciarSesionActi.class);
        startActivity(i);
    }

    //Llamar a registrarse
    public void irRegistrarse(View view){

        Intent i =new Intent(this , RegistrarseActi.class);
        startActivity(i);

    }

    }
