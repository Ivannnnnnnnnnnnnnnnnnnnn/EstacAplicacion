package com.android.app;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.app.adaptadores.listaContactosAdapter;
import com.android.app.db.DbContactos;
import com.android.app.db.DbHelper;
import com.android.app.entidades.Contactos;

import java.util.ArrayList;

public class Principal extends AppCompatActivity {



    public EditText txtEmail, txtNombre, txtApellido, txtDni, txtDomicilio,txtTelefono, txtPatente, txtMarca, txtModelo;
    Button btnGuardar,btnEditar;
    private ListView lv1;

    RecyclerView listaContactos;
    ArrayList<Contactos> listaArrayContactos;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);


        txtEmail = findViewById(R.id.txtEmail);
        txtNombre = findViewById(R.id.txtNombre);
        txtApellido = findViewById(R.id.txtApellido);
        txtDni = findViewById(R.id.txtDni);
        txtDomicilio = findViewById(R.id.txtDomicilio);
        txtTelefono = findViewById(R.id.txtTelefono);

        txtPatente = findViewById(R.id.txtPatente);
        txtMarca = findViewById(R.id.txtMarca);
        txtModelo = findViewById(R.id.txtModelo);

        btnEditar = findViewById(R.id.btnEditar);


             listaContactos = findViewById(R.id.id_lista_contactos);
           listaContactos.setLayoutManager(new LinearLayoutManager(this));


          DbContactos dbContactos = new DbContactos(Principal.this);

        listaArrayContactos = new ArrayList<>();

        listaContactosAdapter adapter = new listaContactosAdapter(dbContactos.mostrarContactos());
        listaContactos.setAdapter(adapter);




        btnGuardar = (Button) findViewById(R.id.btnGuardar);


        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Creamos la base de datos en SQLite

                DbHelper dbHelper= new DbHelper(Principal.this, "agenda", null, 1);
                SQLiteDatabase db = dbHelper.getWritableDatabase();

                if (db != null) {
                    Toast.makeText(Principal.this, "Base de datos creada", Toast.LENGTH_SHORT).show();


                }else {
                    Toast.makeText(Principal.this, "Base de datos fallida", Toast.LENGTH_SHORT).show();
                }

                //Guardamos los datos del usuario en una tabla de SQLite llamada t_contactos

                DbContactos dbContactos = new DbContactos(Principal.this);
               long id = dbContactos.guardarContactos(txtEmail.getText().toString(), txtNombre.getText().toString(), txtApellido.getText().toString(), txtDni.getText().toString(), txtDomicilio.getText().toString(), txtTelefono.getText().toString(), txtPatente.getText().toString(), txtModelo.getText().toString(), txtMarca.getText().toString());

               if (id > 0 ){
                   Toast.makeText(Principal.this, "Registro Persona Guardado", Toast.LENGTH_LONG).show();
                   Intent intent = new Intent(view.getContext(), MainActivity2.class);
                   startActivityForResult(intent, 0);
                   limpiar();
               }else {
                   Toast.makeText(Principal.this, "Error al guardar registro", Toast.LENGTH_LONG).show();

               }

            }
        })
        ;


        }


    ;

    private void limpiar() {
        txtEmail.setText("");
        txtNombre.setText("");
        txtApellido.setText("");
        txtDni.setText("");
        txtDomicilio.setText("");
        txtTelefono.setText("");

        txtPatente.setText("");
        txtModelo.setText("");
        txtMarca.setText("");
    };




    private void HideKeyboard(View view) {
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}




