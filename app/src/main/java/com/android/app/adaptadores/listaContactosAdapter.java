package com.android.app.adaptadores;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.app.R;
import com.android.app.Ver;
import com.android.app.entidades.Contactos;

import java.util.ArrayList;

public class listaContactosAdapter extends RecyclerView.Adapter<listaContactosAdapter.ContactoViewHolder> {


    ArrayList<Contactos> listaContactos;

    public listaContactosAdapter(ArrayList<Contactos> listaContactos){
        this.listaContactos = listaContactos;
    }


    @NonNull
    @Override
    public ContactoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_item_contactos, null, false);
       return new ContactoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactoViewHolder holder, int position) {

        holder.viewEmail.setText(listaContactos.get(position).getEmail());

    }

    @Override
    public int getItemCount() {

        return listaContactos.size();
    }

    public class ContactoViewHolder extends RecyclerView.ViewHolder {

        TextView viewEmail;



        public ContactoViewHolder(@NonNull View itemView) {
            super(itemView);

            viewEmail = itemView.findViewById(R.id.viewEmail);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Context context = view.getContext();
                    Intent intent = new Intent(context, Ver.class);
                    intent.putExtra("ID", listaContactos.get(getAdapterPosition()).getId());
                    context.startActivity(intent);

                    
                }
            });


        }
    }
}
