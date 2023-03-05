package com.android.app;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.android.app.db.DbContactos;
import com.android.app.entidades.Contactos;

public class Ver extends AppCompatActivity {

    EditText txtEmail, txtNombre, txtApellido, txtDni, txtTelefono, txtDomicilio,txtPatente,txtModelo,txtMarca ;
    Button btnGuardar,btnEditar;


    Contactos contacto;
    int id = 0;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver);

        btnGuardar = findViewById(R.id.btnGuardar);

        txtEmail = findViewById(R.id.txtEmail);
        txtNombre = findViewById(R.id.txtNombre);
        txtApellido = findViewById(R.id.txtApellido);
        txtDni = findViewById(R.id.txtDni);
        txtDomicilio = findViewById(R.id.txtDomicilio);
        txtTelefono = findViewById(R.id.txtTelefono);

        txtPatente = findViewById(R.id.txtPatente);
        txtModelo = findViewById(R.id.txtModelo);
        txtMarca = findViewById(R.id.txtMarca);




        btnEditar = findViewById(R.id.btnEditar);


        if (savedInstanceState == null){
            Bundle extras = getIntent().getExtras();
            if (extras == null){
                id = Integer.parseInt(null);
            }else {
                id = extras.getInt("ID");
            }
        }else {
            id = (int) savedInstanceState.getSerializable("ID");
        }

        DbContactos dbContactos = new DbContactos(Ver.this);
        contacto = dbContactos.verContactos(id);

        if (contacto != null){
            txtEmail.setText(contacto.getEmail());
            txtNombre.setText(contacto.getNombre());
            txtApellido.setText(contacto.getApellido());
            txtDni.setText(contacto.getDni());
            txtDomicilio.setText(contacto.getDomicilio());
            txtTelefono.setText(contacto.getTelefono());

            txtPatente.setText(contacto.getPatente());
            txtModelo.setText(contacto.getModelo());
            txtMarca.setText(contacto.getMarca());


            btnGuardar.setEnabled(false);
            btnEditar.setEnabled(true);

            txtEmail.setInputType(InputType.TYPE_NULL);
            txtNombre.setInputType(InputType.TYPE_NULL);
            txtApellido.setInputType(InputType.TYPE_NULL);
            txtDni.setInputType(InputType.TYPE_NULL);
            txtDomicilio.setInputType(InputType.TYPE_NULL);
            txtTelefono.setInputType(InputType.TYPE_NULL);

            txtPatente.setInputType(InputType.TYPE_NULL);
            txtModelo.setInputType(InputType.TYPE_NULL);
            txtMarca.setInputType(InputType.TYPE_NULL);



        }

        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Ver.this, EditarActivity.class);
                intent.putExtra("ID", id);
                startActivity(intent);

            }
        });

    }
}