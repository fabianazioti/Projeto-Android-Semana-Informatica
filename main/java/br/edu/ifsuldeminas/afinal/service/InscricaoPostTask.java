package br.edu.ifsuldeminas.afinal.service;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

/**
 * Created by fabiana on 30/12/16.
 */
public class InscricaoPostTask extends AsyncTask<String, Void, Boolean> {
    private Context context;
    private ProgressDialog dialog;

    public  InscricaoPostTask(Context context) {
        this.context = context;
    }
    @Override
    protected void onPreExecute() {
        dialog = ProgressDialog.show(context, "Aguarde","Cadastrando Cursos");
    }
    @Override
    protected Boolean  doInBackground(String... params) {
        InscricaoCursoService inscService = new InscricaoCursoService();
        String usu_id = params[0];
        String curso_id = params[1];
        boolean resposta  = inscService.post(usu_id, curso_id);

        return resposta;
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        dialog.dismiss();



        if (aBoolean) {
            Toast.makeText(context, "Cadastro de Curso REALIZADO", Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(context, "Cadastro de Curso nao Realizado", Toast.LENGTH_LONG).show();
        }

//        ((ListaCursoActivity)context).finish();
    }
}
