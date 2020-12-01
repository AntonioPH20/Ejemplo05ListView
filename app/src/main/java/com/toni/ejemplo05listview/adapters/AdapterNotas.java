package com.toni.ejemplo05listview.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.toni.ejemplo05listview.ModificaNotaActivity;
import com.toni.ejemplo05listview.R;
import com.toni.ejemplo05listview.modelos.Nota;

import java.security.acl.NotOwnerException;
import java.util.ArrayList;
import java.util.List;

public class AdapterNotas extends ArrayAdapter<Nota> {
    private Context context;
    private int resource;
    private ArrayList<Nota> objects;
    private final int MODIFICA_NOTA=1;

    public AdapterNotas(@NonNull Context context, int resource, @NonNull ArrayList<Nota> objects) {
        super(context, resource, objects);
        this.context=context;
        this.objects=objects;
        this.resource=resource;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View fila= LayoutInflater.from(context).inflate(resource,null);
        TextView txtTitulo= fila.findViewById(R.id.txtTituloFila);
        ImageButton btnEliminar=fila.findViewById(R.id.btnEliminarFila);
        final Nota nota = objects.get(position);

        txtTitulo.setText(nota.getTitulo());

        txtTitulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle= new Bundle();
                bundle.putParcelable("NOTA",nota);
                bundle.putInt("POS",position);
                Intent intent=new Intent(context, ModificaNotaActivity.class);
                intent.putExtras(bundle);
                ((Activity) context).startActivityForResult(intent,MODIFICA_NOTA);

            }
        });

        //falta onlcik del textview
        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                objects.remove(position);
                notifyDataSetChanged();
            }
        });

        return fila;
    }
}
