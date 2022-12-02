package com.example.app_ava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class Menu extends AppCompatActivity {

    Button btnSair;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btnSair = findViewById(R.id.btnSAIR);

        btnSair.setOnClickListener(new View.OnClickListener () {
            @Override
            public void onClick(View v) {finish (); }
        });
    }

    public void vaiParaAnimais(View v){
        Intent it = new Intent(Menu.this, Animais.class);
        startActivity(it);
        finish();
    }

    public void vaiParaReinos(View v){
        Intent it = new Intent(Menu.this, Reinos.class);
        startActivity(it);
        finish();
    }

    public void vaiParaCores(View v){
        Intent it = new Intent(Menu.this, Cores.class);
        startActivity(it);
        finish();
    }

    public void vaiParaEstacao(View v){
        Intent it = new Intent(Menu.this, Estacoes.class);
        startActivity(it);
        finish();
    }

    public void SAIR(View v){
        Intent it = new Intent(Menu.this, Menu.class);
        startActivity(it);
        finish();
    }

}

