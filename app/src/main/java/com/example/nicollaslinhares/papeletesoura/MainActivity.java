package com.example.nicollaslinhares.papeletesoura;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selecionarPedra(View view){
        this.opcaoSelecionada("pedra");
    }

    public void selecionarPapel(View view){
        this.opcaoSelecionada("papel");
    }

    public void selecionarTesoura(View view){
        this.opcaoSelecionada("tesoura");
    }

    public void opcaoSelecionada(String escolhaUsuario){

        ImageView imageResultado = (ImageView) findViewById(R.id.imageResultado);
        TextView textoResultado = (TextView) findViewById(R.id.textResultado);

        System.out.println(escolhaUsuario);

        String[] opcoes = {"pedra", "tesoura", "papel"};
        int numero = new Random().nextInt(3);
        String escolhaApp = opcoes[numero];

        switch (escolhaApp){
            case "pedra":
                imageResultado.setImageResource(R.drawable.pedra);
                break;
            case "tesoura":
                imageResultado.setImageResource(R.drawable.tesoura);
                break;
            case "papel":
                imageResultado.setImageResource(R.drawable.papel);
                break;

        }

        if(
                (escolhaApp == "pedra" && escolhaUsuario == "tesoura") || (escolhaApp == "papel" && escolhaUsuario == "pedra") ||
                        (escolhaApp == "tesoura" && escolhaUsuario == "papel")
                ) {
            textoResultado.setText("Você perdeu");

        } else if(
                (escolhaUsuario == "pedra" && escolhaApp == "tesoura") || (escolhaUsuario == "papel" && escolhaApp == "pedra") ||
                        (escolhaUsuario == "tesoura" && escolhaApp == "papel")
                ){
            textoResultado.setText("Você ganhou");

        } else {
            textoResultado.setText("Empate");
        }
        System.out.println(escolhaApp);
    }


}
