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

public class Reinos extends AppCompatActivity {

    // declarar arrays com os nomes / tradução e imagens :

    private String [] nomesR = new String[] {"Asgard", "Alfheim ", "Jotunheim ", "Midgard"};
    private String [] traducaoR = new String[] {"Ásgarðr", "Álfheimr ", "Jötunheimr", "Miðgarðr "};
    private int [] imagensR = new int[] {R.drawable.asgard, R.drawable.alfheim, R.drawable.jotun, R.drawable.midgard};
    private String sonsR [] = new String [] {"asgard", "alfheim", "jhotun", "midgard"};

    // Criar variaveis dos elementos do xml:
    private Spinner sp2;
    private ImageView View2;
    private TextView Trad2;
    private MediaPlayer mp;
    private int pos, id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reinos);

        sp2 = findViewById(R.id.spn2);
        View2 = findViewById(R.id.viewer2);
        Trad2 = findViewById(R.id.trdReino);

        // construir array adapter e carregar no spinner
        ArrayAdapter<String> valores =
                new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,nomesR);

        //associar o array ao spinner
        sp2.setAdapter(valores);


        //aplicar codigo de erro aos eventos
        sp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, android.view.View view, int i, long l) {
                if (i == 0){
                    View2.setImageResource(imagensR[0]);
                    Trad2.setText(traducaoR[0]);
                    pos = 0;
                }else if (i == 1){
                    View2.setImageResource(imagensR[1]);
                    Trad2.setText(traducaoR[1]);
                    pos = 1;
                }else if (i == 2) {
                    View2.setImageResource(imagensR[2]);
                    Trad2.setText(traducaoR[2]);
                    pos = 2;
                }else{
                    View2.setImageResource(imagensR[3]);
                    Trad2.setText(traducaoR[3]);
                    pos = 3;
                }

                Toast.makeText(Reinos.this, sp2.getSelectedItem()+"",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void ouvir (android.view.View v){
        //obter o id da musica
        String pkg = this.getPackageName();
        id = this.getResources().getIdentifier(sonsR[pos], "raw", pkg);
        //associar musica com class MediaPlayer para ser reproduzido
        this.mp = MediaPlayer.create(this,id);    mp.start();}

    // ---------------------------------------------------------------------------

    public void voltarMenu (View v){
        Intent it = new Intent(Reinos.this, Menu.class);
        startActivity(it);
        finish();
    }

}
