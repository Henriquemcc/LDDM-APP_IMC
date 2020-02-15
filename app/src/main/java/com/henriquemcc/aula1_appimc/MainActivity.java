package com.henriquemcc.aula1_appimc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calcular_IMC(View view)
    {
        TextView txtIMC=findViewById(R.id.Titulo_IMC);
        EditText edtPeso=findViewById(R.id.Entrada_Peso);
        EditText edtAltura=findViewById(R.id.Entrada_Altura);

        float peso=Float.valueOf(edtPeso.getText().toString());
        float altura=Float.valueOf(edtAltura.getText().toString());
        float imc=Math.round(peso/(altura*altura));

        txtIMC.setText(String.valueOf(imc));
    }



}
