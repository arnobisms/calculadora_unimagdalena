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

    public void calcular (View v){

        if(validar()) {
            int num_uno, num_dos, suma;
            num_uno = Integer.parseInt(numero_uno.getText().toString());
            num_dos = Integer.parseInt(numero_dos.getText().toString());
            suma = num_uno + num_dos;
            resultado.setText("" + suma);
        }
    }

    public void aux_limpiar(View v){
        numero_uno.setText("");
        numero_dos.setText("");
        resultado.setText("");
        numero_uno.requestFocus();
    }

    public boolean validar(){
        if(numero_uno.getText().toString().isEmpty()){
            numero_uno.setError("Digite el numero uno");
            numero_uno.requestFocus();
            return false;
        }else{
            if(numero_dos.getText().toString().isEmpty()) {
                numero_uno.setError("Digite el numero dos");
                numero_uno.requestFocus();
                return false;
            }
        }
        return true;
    }
}