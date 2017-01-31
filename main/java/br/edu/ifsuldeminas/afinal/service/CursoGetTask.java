package br.edu.ifsuldeminas.afinal.service;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifsuldeminas.afinal.ListaCursoActivity;
import br.edu.ifsuldeminas.afinal.adapter.CursoAdapter;
import br.edu.ifsuldeminas.afinal.modelo.Curso;

/**
 * Created by fabiana on 28/12/16.
 */
public class CursoGetTask  extends AsyncTask<Void,Void,String> {
    private Context context;
    private ProgressDialog dialog;
    private ArrayList<Integer> id_cursos = new ArrayList<Integer>();


    public CursoGetTask(Context context) {

        this.context = context;
    }

    public ArrayList<Integer> getCursos(){
        return id_cursos;

    }
    @Override
    protected void onPreExecute() {
        dialog = ProgressDialog.show(context, "Aguarde","Buscando Cursos");
    }

    @Override
    protected String doInBackground(Void... params) {
        CursoService service = new CursoService();
        String resposta = service.get();
        return resposta;
    }

    @Override
    protected void onPostExecute(String s) { //a string é a resposta retornada
        dialog.dismiss(); //fecho a caixa com a mensagem



        if(s != null && s != ""){

            ListView listaCursoView = ((ListaCursoActivity) context).getListaCurso();//obtem o listView


//            CheckBox campoCheck = (CheckBox) view.findViewById(R.id.checkboxCurso);
//            Toast.makeText(context, "Cursos  " + s, Toast.LENGTH_LONG).show();


            Type listType = new TypeToken<List<Curso>>(){}.getType();
            List<Curso> cursos = new Gson().fromJson(s, listType);

            CursoAdapter adapter = new CursoAdapter(context, cursos);//cria o adapter
            listaCursoView.setAdapter(adapter); // para os componentes de tela seta o adapter
            

            id_cursos = adapter.getResultado();



//            Toast.makeText(context, "Chamou " + id_cursos.size(), Toast.LENGTH_SHORT).show();
//
//            Intent intencao = new Intent(context, ListaCursoActivity.class);
//            intencao.putExtra("lista_cursos", id_cursos);


        }
    }

}
