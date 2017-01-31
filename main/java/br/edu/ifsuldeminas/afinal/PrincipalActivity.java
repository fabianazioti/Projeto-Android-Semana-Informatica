package br.edu.ifsuldeminas.afinal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import br.edu.ifsuldeminas.afinal.dao.SessionManager;
import br.edu.ifsuldeminas.afinal.modelo.Usuarios;

public class PrincipalActivity extends AppCompatActivity implements View.OnClickListener {

    private Button agenda;
    private Button apoio;
    private Button redesSociais;
    private Button informacoes;
    private Usuarios usuarioLogado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        agenda = (Button) findViewById(R.id.btao_agenda);
        apoio = (Button) findViewById(R.id.btao_apoio);
        redesSociais = (Button) findViewById(R.id.btao_redes_soci);
        informacoes = (Button) findViewById(R.id.btao_informacoes);

        agenda.setOnClickListener(this);
        apoio.setOnClickListener(this);
        redesSociais.setOnClickListener(this);
        informacoes.setOnClickListener(this);

        Intent it = getIntent();
        int usu_id = it.getIntExtra("usu_id", -1);
        String usu_nome = it.getStringExtra("usu_nome");
        String usu_login = it.getStringExtra("usu_login");
        String usu_senha = it.getStringExtra("usu_senha");
        int usu_tipo = it.getIntExtra("usu_tipo", -1);

        //SessionManager
        SessionManager session = new SessionManager(PrincipalActivity.this);
        session.createLoginSession(usu_login, usu_senha, usu_tipo, usu_id);

        session.checkLogin();

        usuarioLogado = session.getUser();


    }
    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.btao_agenda:
                Intent intent  = new Intent(this, AgendaDivActivity.class);
                startActivity(intent);
                break;
            case R.id.btao_apoio:
                Intent intent2  = new Intent(this, ApoioActivity.class);
                startActivity(intent2);
                break;
            case R.id.btao_redes_soci:
                Intent intent3 = new Intent(this, RedesSociaisActivity.class);
                startActivity(intent3);
                break;
            case R.id.btao_informacoes:
                Intent intent4 = new Intent(this, InformacoesActivity.class);
                startActivity(intent4);
                break;

        }

    }
}
