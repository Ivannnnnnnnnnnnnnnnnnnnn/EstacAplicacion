package com.android.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class IniciarSesionActi extends AppCompatActivity {


    private FirebaseAuth mAuth;


    public EditText id_usuario;
    public EditText id_contrasena;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar_sesion);

        mAuth = FirebaseAuth.getInstance();

        id_usuario = findViewById(R.id.id_usuario);
        id_contrasena = findViewById(R.id.id_contrasena);



    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        //updateUI(currentUser);
    }

    public void iniciarUsuario(View view){

        mAuth.signInWithEmailAndPassword(id_usuario.getText().toString().trim(), id_contrasena.getText().toString().trim())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Cuando entramos al sistema correctamente

                            FirebaseUser user = mAuth.getCurrentUser();
                            Toast.makeText(getApplicationContext(), "Ya esta en el Sistema",
                                    Toast.LENGTH_SHORT).show();
                            Intent i = new Intent( getApplicationContext(), MainActivity2.class);
                            startActivity(i);

                            //updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.

                            Toast.makeText(getApplicationContext(), "Contraseña o Usuario Incorrectos",
                                    Toast.LENGTH_SHORT).show();
                          // updateUI(null);
                        }
                    }

                });
        limpiars();


    }

    private void limpiars() {
        id_usuario.setText("");
        id_contrasena.setText("");

    }
}