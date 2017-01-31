package br.edu.ifsuldeminas.afinal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class AgendaDivActivity extends AppCompatActivity implements View.OnClickListener {

    private Button botaoCurso;
    private Button palestrante;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agenda_div);

        botaoCurso = (Button) findViewById(R.id.botao_ag_cursos);
        palestrante = (Button) findViewById(R.id.botao_ag_palestrantes);

        palestrante.setOnClickListener(this);
        botaoCurso.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.botao_ag_palestrantes:
                Intent intent = new Intent(this, RecyclerViewActivity.class);
                startActivity(intent);
                break;
            case R.id.botao_ag_cursos:
                Intent intent2 = new Intent(this,ListaCursoActivity.class);
                startActivity(intent2);
                break;
        }
    }
}
