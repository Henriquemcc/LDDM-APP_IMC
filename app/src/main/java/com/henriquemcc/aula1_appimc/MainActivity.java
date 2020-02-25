package com.henriquemcc.aula1_appimc;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
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

    /**
     * Funcao do metodo: Este metodo serve para rodar o calculo do IMC tendo como entrada e saida a interface grafica.
     * @param view
     */
    public void interfaceGraficaCalcularIMC(View view)
    {
        //Criando instancias de entrada e saida de dados na tela do usuario
        TextView textoIMC=findViewById(R.id.Titulo_IMC);
        EditText entradaPeso=findViewById(R.id.Entrada_Peso);
        EditText entradaAltura=findViewById(R.id.Entrada_Altura);
        TextView textoMensagem=findViewById(R.id.Mensagem);

        //Lendo o peso e a altura
        float peso=0, altura=0;
        boolean ocorreu_excecao_NumberFormatException=false;

        try
        {
            peso=Float.valueOf(entradaPeso.getText().toString());
            altura=Float.valueOf(entradaAltura.getText().toString());
        }
        catch(NumberFormatException e)
        {
            textoMensagem.setText("Uma exceção ocorreu: "+e.toString()+"\nNão foi digitado nenhum número.");
            textoMensagem.setTextColor(Color.RED);
            ocorreu_excecao_NumberFormatException=true;
        }

        //Calculando o IMC e imprimindo
        if(!ocorreu_excecao_NumberFormatException)
        {
            double imc=calcularIMC(peso, altura);
            textoIMC.setText(String.valueOf(imc));

            //Exibindo mensagem ao usuario
            if(altura==0)
            {
                textoMensagem.setText("Erro: Não foi possível dividir: "+peso+"/("+altura+"*"+altura+").\nNão existe divisão por zero.");
                textoMensagem.setTextColor(Color.RED);
            }
            else if(imc<16)
            {
                textoMensagem.setText("IMC < 16 -> Magreza grave");
                textoMensagem.setTextColor(Color.RED);
            }
            else if(imc>16 && imc<17)
            {
                textoMensagem.setText("16<IMC<17 -> Magreza moderada");
                textoMensagem.setTextColor(Color.rgb(255, 165, 0));
            }
            else if(imc>17 && imc<18.5)
            {
                textoMensagem.setText("16<IMC<17 -> Magreza leve");
                textoMensagem.setTextColor(Color.rgb(255, 165, 0));
            }
            else if(imc>18.5 && imc<25)
            {
                textoMensagem.setText("18,5<IMC<25 -> Saudável");
                textoMensagem.setTextColor(Color.GREEN);
            }
            else if(imc>25 && imc<30)
            {
                textoMensagem.setText("25<IMC<30 -> Sobrepeso");
                textoMensagem.setTextColor(Color.rgb(255, 165, 0));
            }
            else if(imc>30 && imc<35)
            {
                textoMensagem.setText("30<IMC<35 -> Obesidade Grau I");
                textoMensagem.setTextColor(Color.RED);
            }
            else if(imc>35 && imc<40)
            {
                textoMensagem.setText("30<IMC<35 -> Obesidade Grau II (severa)");
                textoMensagem.setTextColor(Color.RED);
            }
            else if(imc>40)
            {
                textoMensagem.setText("IMC>40 -> Obesidade Grau III (mórbida)");
                textoMensagem.setTextColor(Color.RED);
            }
        }
    }

    /**
     * Funcao do metodo: Este metodo serve para calcular o IMC
     * @param peso Peso da pessoa em kg.
     * @param altura Altura da pessoa em cm.
     * @return Indice de Massa Corporal.
     */
    public double calcularIMC(float peso, float altura)
    {
        altura/=100;
        return peso/(altura*altura);
    }

}
