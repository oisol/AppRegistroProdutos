package com.example.trabalho;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.content.Context;

public class Esqueceu extends AppCompatActivity implements View.OnClickListener {
    private TextView txtEmail;
    private Button btnEnviar;
    private Button btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_esqueceu);

        txtEmail = findViewById(R.id.txtEmail);
        btnEnviar = findViewById(R.id.btnEnviar);
        btnVoltar = findViewById(R.id.btnVoltar);

        btnEnviar.setOnClickListener(this);
        btnVoltar.setOnClickListener(this);
    }

    @Override
    public void onClick(View evento) {
        if(evento.getId()==R.id.btnVoltar){
            onBackPressed();

        }else if(evento.getId()==R.id.btnEnviar){

            // VALIDAÇÃO DE EMAIL VALIDO
           // Toast.makeText(getBaseContext(),"Enviado: \n" + txtEmail.getText(),Toast.LENGTH_LONG).show();
            if (txtEmail.getText().toString().equals("") || txtEmail.getText().toString().indexOf("@") == -1 ||
                    txtEmail.getText().toString().indexOf(".com") == -1) {
                Toast.makeText(getBaseContext(),"Seu E-mail é invalido",Toast.LENGTH_LONG).show();
            } else {
                AlertDialog.Builder builder = new AlertDialog.Builder(Esqueceu.this);
                builder.setMessage("E-mail enviado para " + txtEmail.getText().toString())
                        .setPositiveButton("Ok", null);

                AlertDialog alerta = builder.create();
                alerta.show();

            }
        }

    }
}
