package com.example.trabalho;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText txtNome;
    private EditText txtSenha;
    private Button btnEsqueceu;
    private Button btnEntrar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Atribuiçaõ

        btnEntrar = findViewById(R.id.btnEntrar);
        btnEsqueceu = findViewById(R.id.btnEsqueceu);

        btnEsqueceu.setOnClickListener(this);
        btnEntrar.setOnClickListener(this);

        Intent intencaoo = new Intent (this, CadastrarProduto.class);


        // progressBar

        ProgressBar progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.INVISIBLE);


        btnEntrar.setOnClickListener (new View.OnClickListener(){
            @Override
            public void onClick(View v) {


                // Setar Login e Senha pelas Variaveis
                String Setlogin = "";
                String Setsenha = "";


                TextView tlogin = (TextView)  findViewById(R.id.txtNome);
                TextView tsenha = (TextView) findViewById(R.id.txtSenha);

                String login = tlogin.getText().toString();
                String senha = tsenha.getText().toString();


                if(login.equals(Setlogin)&& (senha.equals(Setsenha))&&v.getId()==R.id.btnEntrar) {

                    progressBar.setVisibility(View.VISIBLE);

                    Toast.makeText(getBaseContext(), "Entrando", Toast.LENGTH_LONG).show();
                    startActivity(intencaoo);
                    progressBar.setVisibility(View.GONE);
                    }else{
                    progressBar.setVisibility(View.VISIBLE);
                    Toast.makeText(getBaseContext(), "Erro! login ou senha incorretos", Toast.LENGTH_LONG).show();
                    progressBar.setVisibility(View.GONE);
                }

            }

         });


    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.btnEsqueceu){
            Intent intencao = new Intent (this,Esqueceu.class);
            startActivity(intencao);
        }
    }

}
