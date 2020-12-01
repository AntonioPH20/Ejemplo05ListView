package com.toni.ejemplo05listview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.toni.ejemplo05listview.modelos.Nota;

public class ModificaNotaActivity extends AppCompatActivity {

    private EditText txtTitulo, txtContenido;
    private Nota nota;
    private Button btnGuardar;
    private int posicion;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_nota);
        txtContenido = findViewById(R.id.txtContenidoNotaAdd);
        txtTitulo = findViewById(R.id.txtTituloNotaAdd);
        btnGuardar = findViewById(R.id.btnSaveNotaAdd);

        nota=getIntent().getExtras().getParcelable("NOTA");
        posicion=getIntent().getExtras().getInt("POS");

        txtTitulo.setText(nota.getTitulo());
        txtContenido.setText(nota.getContenido());

        btnGuardar.setText("ACTUALIZAR");

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!txtTitulo.getText().toString().isEmpty() &&
                        !txtContenido.getText().toString().isEmpty()){
                    nota.setTitulo(txtTitulo.getText().toString());
                    nota.setContenido(txtContenido.getText().toString());
                    Bundle bundle= new Bundle();
                    bundle.putParcelable("NOTA",nota);
                    bundle.putInt("POS",posicion);
                    Intent intent=new Intent();
                    intent.putExtras(bundle);
                    setResult(RESULT_OK,intent);
                    finish();
                }
            }
        });

    }
}
