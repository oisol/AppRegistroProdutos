package com.example.trabalho;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CadastrarProduto extends AppCompatActivity implements View.OnClickListener {


    private Button btnSalvar, btnApagar;
    private EditText edtNome, edtCategoria, edtDescricao, edtPreco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_produto);

        btnSalvar = findViewById(R.id.btnSalvar);
        btnApagar = findViewById(R.id.btnApagar);

        edtNome = findViewById(R.id.edtNome);
        edtCategoria = findViewById(R.id.edtCategoria);
        edtDescricao = findViewById(R.id.edtDescricao);
        edtPreco = findViewById(R.id.edtPreco);

        btnSalvar.setOnClickListener(this);
        btnApagar.setOnClickListener(this);
    }

    @Override
    public void onClick(View evento) {
        if (evento.getId() == R.id.btnApagar){
            edtNome.setText("");
            edtCategoria.setText("");
            edtDescricao.setText("");
            edtPreco.setText("");
        } else if (evento.getId() == R.id.btnSalvar){

            ContentValues cv = new ContentValues();
            cv.put("nome",  edtNome.getText().toString());
            cv.put("categoria",  edtCategoria.getText().toString());
            cv.put("descricao",  edtDescricao.getText().toString());
            cv.put("preco",  edtPreco.getText().toString());

            DatabaseHelper dh = new DatabaseHelper(this);

            String msg = "";
            if (dh.inserir(cv) > 0){
                msg = "Operação realizada com sucesso!";
                edtNome.setText("");
                edtCategoria.setText("");
                edtDescricao.setText("");
                edtPreco.setText("");

                edtNome.requestFocus();
            }

            Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
        }
    }
}