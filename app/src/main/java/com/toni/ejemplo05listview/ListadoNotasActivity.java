package com.toni.ejemplo05listview;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.toni.ejemplo05listview.adapters.AdapterNotas;
import com.toni.ejemplo05listview.modelos.Nota;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Adapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListadoNotasActivity extends AppCompatActivity {
    //contenedor
    private ListView contenedor;
    // Plantilla
    private int fila;
    // Conjunto de datos
    private ArrayList<Nota> listaNotas;
    //adapter
    private AdapterNotas notasAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_notas);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        contenedor=findViewById(R.id.contenedorNotas);
        fila=R.layout.fila_nota;
        listaNotas=new ArrayList<>();
        notasAdapter=new AdapterNotas(this,fila,listaNotas);
        contenedor.setAdapter(notasAdapter);

        crearNotasInicial();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void crearNotasInicial() {
        for (int i = 0; i < 10; i++) {
            Nota nota=new Nota("Titulo "+i,"Contenido");
            listaNotas.add(nota);

        }
        notasAdapter.notifyDataSetChanged();
    }
}