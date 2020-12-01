package com.toni.ejemplo05listview;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.toni.ejemplo05listview.adapters.AdapterNotas;
import com.toni.ejemplo05listview.modelos.Nota;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Adapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.IllegalFormatCodePointException;

public class ListadoNotasActivity extends AppCompatActivity {
    //contenedor
    private ListView contenedor;
    // Plantilla
    private int fila;
    // Conjunto de datos
    private ArrayList<Nota> listaNotas;
    //adapter
    private AdapterNotas notasAdapter;
    private final int ADD_NOTA=0,MODIFICAR_NOTA=1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_notas);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        contenedor=findViewById(R.id.contenedorNotas);
        //XML plantilla
        fila=R.layout.fila_nota;
        listaNotas=new ArrayList<>();
        notasAdapter=new AdapterNotas(this,fila,listaNotas);
        contenedor.setAdapter(notasAdapter);

        //crearNotasInicial();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               startActivityForResult(new Intent(ListadoNotasActivity.this, AddNotaActivity.class),ADD_NOTA);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==ADD_NOTA && resultCode == RESULT_OK){
            if (data!=null){
                Nota nota=data.getExtras().getParcelable("NOTA");
                listaNotas.add(nota);
                notasAdapter.notifyDataSetChanged();
            }
        }

        if (requestCode==MODIFICAR_NOTA && resultCode == RESULT_OK){
            Nota nota= data.getExtras().getParcelable("NOTA");
            int posicion= data.getExtras().getInt("POS");
            if (nota!=null){
                listaNotas.set(posicion,nota);
                notasAdapter.notifyDataSetChanged();
            }
        }
    }

    private void crearNotasInicial() {
        for (int i = 0; i < 30; i++) {
            Nota nota=new Nota("Titulo "+i,"Contenido");
            listaNotas.add(nota);

        }
        notasAdapter.notifyDataSetChanged();
    }
}