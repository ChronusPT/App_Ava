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

public class Cores extends AppCompatActivity {

        // declarar arrays com os nomes / tradução e imagens :

    private String [] nomesC = new String[] {"Vermelho", "Verde", "Preto", "Dourado"};
    private String [] traducaoC = new String[] {"Rauðr ", "Grœnn ", "Blakkr", "Gull"};
    private int [] imagensC = new int[] {R.drawable.red, R.drawable.green, R.drawable.black, R.drawable.gold};
    private String sonsC [] = new String [] {"raudr", "groenn", "blakk", "gull"};

        // Criar variaveis dos elementos do xml:

    private Spinner sp3;
    private ImageView View3;
    private TextView Trad3;
    private MediaPlayer mp;
    private int pos, id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cores);

        sp3 = findViewById(R.id.spn3);
        View3 = findViewById(R.id.view3);
        Trad3 = findViewById(R.id.txtCores);

        // construir array adapter e carregar no spinner
        ArrayAdapter<String> valores =
                new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,nomesC);

        //associar o array ao spinner
        sp3.setAdapter(valores);


        //aplicar codigo de erro aos eventos
        sp3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, android.view.View view, int i, long l) {
                if (i == 0){
                    View3.setImageResource(imagensC[0]);
                    Trad3.setText(traducaoC[0]);
                    pos = 0;
                }else if (i == 1){
                    View3.setImageResource(imagensC[1]);
                    Trad3.setText(traducaoC[1]);
                    pos = 1;
                }else if (i == 2) {
                    View3.setImageResource(imagensC[2]);
                    Trad3.setText(traducaoC[2]);
                    pos = 2;
                }else{
                    View3.setImageResource(imagensC[3]);
                    Trad3.setText(traducaoC[3]);
                    pos = 3;
                }

                Toast.makeText(com.example.app_ava.Cores.this, sp3.getSelectedItem()+"",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void ouvir (android.view.View v){
        //obter o id da musica
        String pkg = this.getPackageName();
        id = this.getResources().getIdentifier(sonsC[pos], "raw", pkg);
        //associar musica com class MediaPlayer para ser reproduzido
        this.mp = MediaPlayer.create(this,id);    mp.start();}

    // ---------------------------------------------------------------------------

    public void voltarMenu (View v){
        Intent it = new Intent(com.example.app_ava.Cores.this, Menu.class);
        startActivity(it);
        finish();
    }

    }
