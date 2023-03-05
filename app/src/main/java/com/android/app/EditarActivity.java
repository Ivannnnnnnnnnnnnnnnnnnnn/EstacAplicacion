package com.android.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.app.db.DbContactos;
import com.android.app.entidades.Contactos;

public class EditarActivity extends AppCompatActivity {

    EditText txtEmail, txtNombre, txtApellido, txtDni, txtTelefono, txtDomicilio,txtPatente,txtModelo,txtMarca;
    Button btnGuardar,btnEditar;


    boolean correcto = false;


    Contactos contacto;
    int id = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver);

        btnGuardar = findViewById(R.id.btnGuardar);
        btnEditar= findViewById(R.id.btnEditar);



        txtEmail = findViewById(R.id.txtEmail);
        txtNombre = findViewById(R.id.txtNombre);
        txtApellido = findViewById(R.id.txtApellido);
        txtDni = findViewById(R.id.txtDni);
        txtDomicilio = findViewById(R.id.txtDomicilio);
        txtTelefono = findViewById(R.id.txtTelefono);

        txtPatente = findViewById(R.id.txtPatente);
        txtModelo = findViewById(R.id.txtModelo);
        txtMarca = findViewById(R.id.txtMarca);



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

       final DbContactos dbContactos = new DbContactos(EditarActivity.this);
        contacto = dbContactos.verContactos(id);
//------------------------------------------------------------------------

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

            btnEditar.setEnabled(false);


        }


        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!txtTelefono.getText().toString().equals("") && !txtPatente.getText().toString().equals("") &&
                        !txtDomicilio.getText().toString().equals("") && !txtEmail.getText().toString().equals("") && !txtPatente.getText().toString().equals("") && !txtModelo.getText().toString().equals("") && !txtMarca.getText().toString().equals("")) {

                  correcto =  dbContactos.editarContacto(id, txtEmail.getText().toString(), txtNombre.getText().toString(),
                            txtApellido.getText().toString(), txtDni.getText().toString(), txtDomicilio.getText().toString(),
                           txtTelefono.getText().toString(), txtPatente.getText().toString(),txtModelo.getText().toString(), txtMarca.getText().toString());

                    if (correcto){
                        Toast.makeText(EditarActivity.this, "Registro Modificado", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(view.getContext(), MainActivity2.class);
                        startActivityForResult(intent, 0);
                        verRegistro();
                    }else {
                        Toast.makeText(EditarActivity.this, "Error al modificar registro", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(view.getContext(), MainActivity2.class);
                        startActivityForResult(intent, 0);
                    }
                }else {
                    Toast.makeText(EditarActivity.this, "Debe Llenar los campos obligatorios", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(view.getContext(), MainActivity2.class);
                    startActivityForResult(intent, 0);
                }

                }



        });

    }

    private void verRegistro(){
        Intent intent = new Intent(this, Ver.class);
        intent.putExtra("ID", id);
        startActivity(intent);
    }

}