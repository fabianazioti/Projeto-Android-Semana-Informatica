package br.edu.ifsuldeminas.afinal.service;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

/**
 * Created by fabiana on 15/12/16.
 */
public class UsuarioGetTask extends AsyncTask<Void,Void,String> {
    private Context context;
    private ProgressDialog dialog;

    public UsuarioGetTask(Context context) {

        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        dialog = ProgressDialog.show(context, "Aguarde","Buscando Usuario");
    }

    @Override
    protected String doInBackground(Void... params) {
        UsuarioService service = new UsuarioService();
        String resposta = service.get();
        return resposta;
    }

    @Override
    protected void onPostExecute(String s) { //a string é a resposta retornada
        dialog.dismiss(); //fecho a caixa com a mensagem

        if(s != null && s != ""){


        }
    }
}
