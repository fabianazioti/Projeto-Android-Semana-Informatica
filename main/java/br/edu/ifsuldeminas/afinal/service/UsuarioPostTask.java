package br.edu.ifsuldeminas.afinal.service;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import br.edu.ifsuldeminas.afinal.CadastroUsuActivity;

/**
 * Created by fabiana on 15/12/16.
 */
public class UsuarioPostTask extends AsyncTask<String, Void, Boolean> {

    private Context context;
    private ProgressDialog dialog;

    public UsuarioPostTask(Context context) {
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        dialog = ProgressDialog.show(context, "Aguarde","Enviando Usuario");
    }

    @Override
    protected Boolean doInBackground(String... params) {
        UsuarioService service = new UsuarioService();
        String json = params[0];
        boolean resposta = service.post(json);
        return resposta;
    }
    @Override
    protected void onPostExecute(Boolean aBoolean) {
        dialog.dismiss();

        if (aBoolean) {
            Toast.makeText(context, "Deu Certo", Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(context, "nao deu certo", Toast.LENGTH_LONG).show();
        }

      ((CadastroUsuActivity)context).finish();
    }
}
