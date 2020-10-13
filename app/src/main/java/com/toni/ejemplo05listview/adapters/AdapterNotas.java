package com.toni.ejemplo05listview.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.toni.ejemplo05listview.R;
import com.toni.ejemplo05listview.modelos.Nota;

import java.security.acl.NotOwnerException;
import java.util.ArrayList;
import java.util.List;

public class AdapterNotas extends ArrayAdapter<Nota> {
    private Context context;
    private int resource;
    private ArrayList<Nota> objects;

    public AdapterNotas(@NonNull Context context, int resource, @NonNull ArrayList<Nota> objects) {
        super(context, resource, objects);
        this.context=context;
        this.objects=objects;
        this.resource=resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View fila= LayoutInflater.from(context).inflate(resource,null);
        TextView txtTitulo= fila.findViewById(R.id.txtTituloFila);
        ImageButton btnEliminar=fila.findViewById(R.id.btnEliminarFila);
        Nota nota = objects.get(position);

        txtTitulo.setText(nota.getTitulo());

        //falta onlcik del textview

        return fila;
    }
}
