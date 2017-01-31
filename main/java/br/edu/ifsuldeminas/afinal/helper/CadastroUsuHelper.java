package br.edu.ifsuldeminas.afinal.helper;

import android.widget.EditText;
import android.widget.Spinner;

import br.edu.ifsuldeminas.afinal.CadastroUsuActivity;
import br.edu.ifsuldeminas.afinal.R;
import br.edu.ifsuldeminas.afinal.modelo.Usuarios;

/**
 * Created by fabiana on 15/12/16.
 */
public class CadastroUsuHelper {
    private EditText campoNome;
    private EditText campoEmail;
    private EditText campoLogin;
    private EditText campoSenha;
    private EditText campoCpf;
    private Spinner campoTipo_Usu;
    private Usuarios usu;

    public CadastroUsuHelper(CadastroUsuActivity activity){

        campoNome = (EditText) activity.findViewById(R.id.usu_nome);
        campoLogin = (EditText) activity.findViewById(R.id.usu_login);
        campoSenha = (EditText) activity.findViewById(R.id.usu_senha);
        campoCpf = (EditText) activity.findViewById(R.id.usu_cpf);
        campoTipo_Usu = (Spinner) activity.findViewById(R.id.sp_usu_tipo);
        campoEmail = (EditText) activity.findViewById(R.id.usu_email);

        usu = new Usuarios();

    }

    public Usuarios getUsu(){

        usu.setUsu_nome(campoNome.getText().toString());
        usu.setUsu_login(campoLogin.getText().toString());
        usu.setUsu_senha(campoSenha.getText().toString());
        usu.setUsu_cpf(campoCpf.getText().toString());
        usu.setUsu_tipo(campoTipo_Usu.getSelectedItemPosition());
        usu.setUsu_email(campoEmail.getText().toString());

        return usu;
    }
    public void setUsu(Usuarios usu){

        campoNome.setText(usu.getUsu_nome());
        campoLogin.setText(usu.getUsu_login());
        campoSenha.setText(usu.getUsu_senha());
        campoCpf.setText(usu.getUsu_cpf());
//        campoTipo_Usu.setAdapter(usu.getUsu_tipo());
        campoEmail.setText(usu.getUsu_cpf());

        // Tipo
        this.usu = usu;
    }
}
