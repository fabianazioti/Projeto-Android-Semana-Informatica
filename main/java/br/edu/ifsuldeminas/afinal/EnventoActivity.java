package br.edu.ifsuldeminas.afinal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class EnventoActivity extends AppCompatActivity {

    TextView eventoName;
    ImageView eventoPhoto;
    TextView eventoDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_envento);

        eventoName = (TextView) findViewById(R.id.evento_nome);
        eventoPhoto = (ImageView) findViewById(R.id.evento_photo);
        eventoDesc = (TextView) findViewById(R.id.evento_descri);

        eventoName.setText("Semana de Informatica");
        eventoPhoto.setImageResource(R.drawable.seminfolo);
        eventoDesc.setText("Evento de palestraas ahsudhfuashdfiuashdufhasudfhuahusdh");


    }
}
