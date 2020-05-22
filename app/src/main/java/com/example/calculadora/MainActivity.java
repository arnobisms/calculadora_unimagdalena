package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText numero_uno, numero_dos;
    private TextView resultado;
    private Spinner seleccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numero_uno = findViewById(R.id.txtNumeroUno);
        numero_dos = findViewById(R.id.txtNumeroDos);
        resultado = findViewById(R.id.lblResultado);
        seleccion = findViewById(R.id.seleccionOperacion);

        String [] opciones = {"Sumar", "Restar", "Multiplicar", "Dividir"};
        ArrayAdapter <String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opciones);
        seleccion.setAdapter(adaptador);


    }

    public void calcular(View v){
        int num_uno, num_dos, resul=0,aux=0;
        String n1 = numero_uno.getText().toString();
        String n2 = numero_dos.getText().toString();

        String sele = seleccion.getSelectedItem().toString();

      if((n1.length()==0)||(n2.length()==0)){
          resultado.setText("Digite todos los numeros");
      }
      else{
          num_uno = Integer.parseInt(numero_uno.getText().toString());
          num_dos = Integer.parseInt(numero_dos.getText().toString());

          if (sele == "Sumar") {
              resul = num_uno + num_dos;
          }

          if (sele == "Restar") {
              resul = num_uno - num_dos;
          }

          if (sele == "Multiplicar") {
              resul = num_uno * num_dos;
          }

          if (sele == "Dividir") {
              if (num_dos != 0) {
                  resul = num_uno / num_dos;
              } else {
                  aux=1;
              }
          }

          if (aux == 1) {
              resultado.setText("Error divicion por 0");
          } else {
              resultado.setText("" + resul);
          }
      }
    }

    public void aux_limpiar(View v){
        numero_uno.setText("");
        numero_dos.setText("");
        resultado.setText("");
        numero_uno.requestFocus();

    }
}
