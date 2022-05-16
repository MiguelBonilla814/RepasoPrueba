package com.example.repasoprueba;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class FinalActivity extends AppCompatActivity {

    private TextView text_nombre;
    private TextView text_base;

    private EditText edit_apellido;
    private EditText edit_exponente;
    private EditText edit_numero;

    String nombre, base;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        text_nombre = findViewById(R.id.editText_nombre_activity3);
        text_base = findViewById(R.id.editText_base_activity3);
        edit_apellido = findViewById(R.id.editText_apellido_activity3);
        edit_exponente = findViewById(R.id.editText_exponente_activity3);
        edit_numero = findViewById(R.id.editText_factorial_activity3);

        nombre = getIntent().getExtras().getString("nombre");
        base = getIntent().getExtras().getString("base");

        text_nombre.setText(nombre);
        text_base.setText(base);

    }

    public void CerrarActivity3(View view){
        String apellido, exponente, numero;

        apellido = edit_apellido.getText().toString();
        exponente = edit_exponente.getText().toString();
        numero = edit_numero.getText().toString();

        Intent intent = new Intent();
        intent.putExtra("nombre", nombre);
        intent.putExtra("apellido", apellido);
        intent.putExtra("base", base);
        intent.putExtra("exponente", exponente);
        intent.putExtra("numero", numero);

        setResult(Activity.RESULT_OK, intent);
        this.finish();
    }
}