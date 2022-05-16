package com.example.repasoprueba;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityIngresarNombreBase extends AppCompatActivity {

    private int LAUNCH_ACTIVITY_3 = 1;
    private EditText edit_nombre;
    private EditText edit_base;
    private Button button_cerrar_Activity2;

    String nombre = "", apellido, base = "", exponente, numero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingresar_nombre_base);

        edit_nombre = findViewById(R.id.editText_nombre_activity2);
        edit_base = findViewById(R.id.editText_base_Activity2);
        button_cerrar_Activity2 = findViewById(R.id.button_cerrar_Activity2);

        if(nombre.equals(""))
            button_cerrar_Activity2.setEnabled(false);

    }
    //Hola

    public void AbrirActivity3(View view){
        Intent intent = new Intent(this, FinalActivity.class);
        intent.putExtra("nombre", edit_nombre.getText().toString());
        intent.putExtra("base", edit_base.getText().toString());
        startActivityForResult(intent, LAUNCH_ACTIVITY_3);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == LAUNCH_ACTIVITY_3){
            if(resultCode == Activity.RESULT_OK){
                nombre = data.getStringExtra("nombre");
                apellido = data.getStringExtra("apellido");
                base = data.getStringExtra("base");
                exponente = data.getStringExtra("exponente");
                numero = data.getStringExtra("numero");

                /*
                Toast.makeText(this, nombre, Toast.LENGTH_SHORT).show();
                Toast.makeText(this, apellido, Toast.LENGTH_SHORT).show();
                Toast.makeText(this, base, Toast.LENGTH_SHORT).show();
                Toast.makeText(this, exponente, Toast.LENGTH_SHORT).show();
                Toast.makeText(this, numero, Toast.LENGTH_SHORT).show();*/

                if(!nombre.equals(""))
                    button_cerrar_Activity2.setEnabled(true);

            }

            if(resultCode == Activity.RESULT_CANCELED){

            }
        }
    }


    public void CerrarActivity2(View view){
        Intent intent = new Intent();
        intent.putExtra("nombre", nombre);
        intent.putExtra("apellido", apellido);
        intent.putExtra("base", base);
        intent.putExtra("exponente", exponente);
        intent.putExtra("numero", numero);

        setResult(Activity.RESULT_OK, intent);

        this.finish();;
    }



}