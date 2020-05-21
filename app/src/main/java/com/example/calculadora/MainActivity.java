package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText numero_uno, numero_dos;
    private TextView resultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numero_uno = findViewById(R.id.txtNumeroUno);
        numero_dos = findViewById(R.id.txtNumeroDos);
        resultado = findViewById(R.id.lblResultado);

    }

    public void calcular(View v){
        int num_uno, num_dos;
        num_uno = Integer.parseInt(numero_uno.getText().toString());
        num_dos = Integer.parseInt(numero_dos.getText().toString());
        int suma = num_uno + num_dos;
        resultado.setText(""+suma);
    }
}
