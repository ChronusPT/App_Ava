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

public class Animais extends AppCompatActivity {

    // declarar arrays com os nomes / tradução e imagens :

    private String [] nomesA = new String[] {"Corvo", "Urso", "Lobo", "Veado"};
    private String [] traducaoA = new String[] {"Hrafn ", "Björn", "Vargr ", "Dýr"};
    private int [] imagensA = new int[] {R.drawable.corvo, R.drawable.bear, R.drawable.wolf, R.drawable.veado};
    private String sonsA [] = new String [] {"hrafn", "bjorn", "vargr", "dyr"};

    // Criar variaveis dos elementos do xml:
    private Spinner sp;
    private ImageView View;
    private TextView Trad;
    private MediaPlayer mp;
    private int pos, id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animais);

        sp = findViewById(R.id.spinA);
        View = findViewById(R.id.Viewer);
        Trad = findViewById(R.id.txtTrad);

        // construir array adapter e carregar no spinner
        ArrayAdapter<String> valores =
                new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,nomesA);

        //associar o array ao spinner
        sp.setAdapter(valores);


        //aplicar codigo de erro aos eventos
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, android.view.View view, int i, long l) {
                if (i == 0){
                    View.setImageResource(imagensA[0]);
                    Trad.setText(traducaoA[0]);
                    pos = 0;
                }else if (i == 1){
                    View.setImageResource(imagensA[1]);
                    Trad.setText(traducaoA[1]);
                    pos = 1;
                }else if (i == 2) {
                    View.setImageResource(imagensA[2]);
                    Trad.setText(traducaoA[2]);
                    pos = 2;
                }else{
                    View.setImageResource(imagensA[3]);
                    Trad.setText(traducaoA[3]);
                    pos = 3;
                }

                Toast.makeText(Animais.this, sp.getSelectedItem()+"",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void ouvir (View v){
        //obter o id da musica
        String pkg = this.getPackageName();
        id = this.getResources().getIdentifier(sonsA[pos], "raw", pkg);
        //associar musica com class MediaPlayer para ser reproduzido
        this.mp = MediaPlayer.create(this,id);    mp.start();}

// ---------------------------------------------------------------------------

    public void voltarMenu (View v){
        Intent it = new Intent(Animais.this, Menu.class);
        startActivity(it);
        finish();
    }
}


