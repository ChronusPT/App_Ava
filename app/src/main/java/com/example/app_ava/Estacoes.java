package com.example.app_ava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Estacoes extends AppCompatActivity {

        // declarar arrays com os nomes / tradução e imagens :

        private String [] nomesE = new String[] {"Primavera", "Verão", "Outono", "Inverno"};
        private String [] traducaoE = new String[] {"Vår", "Sumarr", "Høst", "Wetz̠"};
        private int [] imagensE = new int[] {R.drawable.spring, R.drawable.summer, R.drawable.autumn, R.drawable.winter};
        private String sonsE [] = new String [] {"var", "sumarr", "host", "wetz"};

        // Criar variaveis dos elementos do xml:

        private Spinner sp4;
        private ImageView View4;
        private TextView Trad4;
        private MediaPlayer mp;
        private int pos, id;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_estacoes);

            sp4 = findViewById(R.id.spn4);
            View4 = findViewById(R.id.view4);
            Trad4 = findViewById(R.id.txtEstacao);

            // construir array adapter e carregar no spinner
            ArrayAdapter<String> valores =
                    new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,nomesE);

            //associar o array ao spinner
            sp4.setAdapter(valores);


            //aplicar codigo de erro aos eventos
            sp4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, android.view.View view, int i, long l) {
                    if (i == 0){
                        View4.setImageResource(imagensE[0]);
                        Trad4.setText(traducaoE[0]);
                        pos = 0;
                    }else if (i == 1){
                        View4.setImageResource(imagensE[1]);
                        Trad4.setText(traducaoE[1]);
                        pos = 1;
                    }else if (i == 2) {
                        View4.setImageResource(imagensE[2]);
                        Trad4.setText(traducaoE[2]);
                        pos = 2;
                    }else{
                        View4.setImageResource(imagensE[3]);
                        Trad4.setText(traducaoE[3]);
                        pos = 3;
                    }

                    Toast.makeText(com.example.app_ava.Estacoes.this, sp4.getSelectedItem()+"",Toast.LENGTH_LONG).show();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });
        }

        public void ouvir (android.view.View v){
            //obter o id da musica
            String pkg = this.getPackageName();
            id = this.getResources().getIdentifier(sonsE[pos], "raw", pkg);
            //associar musica com class MediaPlayer para ser reproduzido
            this.mp = MediaPlayer.create(this,id);    mp.start();}

        // ---------------------------------------------------------------------------

        public void voltarMenu (View v){
            Intent it = new Intent(com.example.app_ava.Estacoes.this, Menu.class);
            startActivity(it);
            finish();
        }

    }
