package br.edu.ifsuldeminas.afinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class InformacoesActivity extends AppCompatActivity implements View.OnClickListener {

    private Button informacoesGerais;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacoes);

        informacoesGerais = (Button) findViewById(R.id.btao_informacoes_gerais);


        informacoesGerais.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btao_informacoes_gerais:
                Intent intent = new Intent(this, EnventoActivity.class);
                startActivity(intent);
                break;
        }

    }
}
