package br.edu.ifsuldeminas.afinal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.edu.ifsuldeminas.afinal.service.UsuarioGetLoTask;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText ediLogin;
    private EditText ediSenha;
    private Button entrar;
    private Button cadastrar;

    public LoginActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // Vincula os objtetos ao seu ID
        ediLogin = (EditText) findViewById(R.id.campo_login);
        ediSenha = (EditText) findViewById(R.id.campo_senha);
        entrar = (Button) findViewById(R.id.botao_entrar);
        cadastrar = (Button) findViewById(R.id.botao_cadastrar);


        // Adiciona as acoes
        entrar.setOnClickListener(this);
        cadastrar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.botao_entrar:

                if (ediLogin.getText().length() == 0 || ediSenha.getText().length() == 0){
                    Toast.makeText(getApplication(), "Os campos Login e Senha sao obrigatorios", Toast.LENGTH_SHORT).show();

                }
                else {

//                    Usuarios usua = new Usuarios();
//                    usua.setUsu_login(ediLogin.getText().toString());
//                    usua.setUsu_senha(ediSenha.getText().toString());

//                    String json = new Gson().toJson(usua);

                    UsuarioGetLoTask task = new UsuarioGetLoTask(this);
                    task.execute(ediLogin.getText().toString(), ediSenha.getText().toString());
                    finish();

                }
                break;
            case R.id.botao_cadastrar:

                Intent intencaoC = new Intent(LoginActivity.this, CadastroUsuActivity.class);
                startActivity(intencaoC);
                break;

        }
    }
}
