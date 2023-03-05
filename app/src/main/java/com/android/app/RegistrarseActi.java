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

    public class RegistrarseActi extends AppCompatActivity {

    private FirebaseAuth mAuth;

    private EditText id_usuario;
    private EditText id_contrasena;
    private EditText id_contrasenaVeri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);

        mAuth = FirebaseAuth.getInstance();

        id_usuario = findViewById(R.id.id_usuario);
        id_contrasena = findViewById(R.id.id_contrasena);
        id_contrasenaVeri = findViewById(R.id.id_contrasenaVeri);


    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();

        //updateUI(currentUser);
    }

        public void registrarUsuario(View view){


            if(id_contrasena.getText().toString().trim().equals(id_contrasenaVeri.getText().toString().trim())){


                mAuth.createUserWithEmailAndPassword(id_usuario.getText().toString(), id_contrasena.getText().toString())
                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override

                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    //Log.d(TAG, "createUserWithEmail:success");

                                    Toast.makeText(getApplicationContext(), "Usuario Creado con exito",
                                            Toast.LENGTH_SHORT).show();
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    //CORRECTO
                                    Intent i = new Intent( getApplicationContext(), MainActivity.class);
                                    startActivity(i);
                                    //updateUI(user);


                                } else {
                                    // If sign in fails, display a message to the user.
                                   //Log.w(TAG, "createUserWithEmail:failure", task.getException());
                                    Toast.makeText(getApplicationContext(), "Authentication fallida.",
                                             Toast.LENGTH_SHORT).show();
                                    //updateUI(null);
                                }

                                // ...
                            }
                        });
            }else{

                Toast.makeText(this, "Las contraseñas no coiciden", Toast.LENGTH_SHORT).show();
                
            }






        }
}