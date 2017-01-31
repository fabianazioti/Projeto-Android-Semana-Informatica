package br.edu.ifsuldeminas.afinal.service;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

import br.edu.ifsuldeminas.afinal.PrincipalActivity;
import br.edu.ifsuldeminas.afinal.modelo.Usuarios;

/**
 * Created by fabiana on 26/12/16.
 */
public class UsuarioGetLoTask extends AsyncTask<String,Void,String> {

    private Context context;
    private ProgressDialog dialog;
    private Usuarios usu;

    public UsuarioGetLoTask(Context context) {
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        dialog = ProgressDialog.show(context, "Aguarde","Fazendo Login");
    }

    @Override
    protected String doInBackground(String... params) {
        UsuarioService service = new UsuarioService();
        String login = params[0].toString();
        String senha = params[1].toString();

        String resposta = service.getLogin(login,senha);
        return resposta;
    }

    @Override
    protected void onPostExecute(String s){
        dialog.dismiss();

        usu = new Usuarios();

        if(s != null && s != ""){
            Type usuType = new TypeToken<Usuarios>(){}.getType();
            usu =  new Gson().fromJson(s.substring(4),Usuarios.class);

            Toast.makeText(context, "Bem Vindo  " + usu.getUsu_nome(), Toast.LENGTH_LONG).show();
            Intent intencao = new Intent(context, PrincipalActivity.class);
            intencao.putExtra("usu_id", usu.getUsu_id());
            intencao.putExtra("usu_nome", usu.getUsu_nome());
            intencao.putExtra("usu_login", usu.getUsu_login());
            intencao.putExtra("usu_senha", usu.getUsu_senha());
            intencao.putExtra("usu_tipo", usu.getUsu_tipo());

            context.startActivity(intencao);

        }
        else{
            Toast.makeText(context, "Esta vazia" + s, Toast.LENGTH_LONG).show();
        }




//        Type listType = new TypeToken<List<Usuarios>>(){}.getType();
//        List<Usuarios> alunos = new Gson().fromJson(s, listType);


//
//        Intent intencao = new Intent(context, PrincipalActivity.class);
//        intencao.putExtra("usuario", usuario);
//
//        startActivity(intencao);

    }
}
