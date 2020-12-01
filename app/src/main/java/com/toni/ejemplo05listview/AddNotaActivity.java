package com.toni.ejemplo05listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.toni.ejemplo05listview.modelos.Nota;

public class AddNotaActivity extends AppCompatActivity {
    private EditText txtTitulo, txtContenido;
    private Button btnGuardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_nota);

        txtContenido = findViewById(R.id.txtContenidoNotaAdd);
        txtTitulo = findViewById(R.id.txtTituloNotaAdd);
        btnGuardar = findViewById(R.id.btnSaveNotaAdd);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!txtTitulo.getText().toString().isEmpty() && !txtContenido.getText().toString().isEmpty()) {
                    Nota nota = new Nota(txtTitulo.getText().toString(), txtContenido.getText().toString());
                    Bundle bundle=new Bundle();
                    bundle.putParcelable("NOTA",nota);
                    Intent intent=new Intent();
                    intent.putExtras(bundle);
                    setResult(RESULT_OK,intent);
                    finish();
                }
            }
        });
    }
}