package br.edu.ifsuldeminas.afinal;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import br.edu.ifsuldeminas.afinal.dao.SessionManager;
import br.edu.ifsuldeminas.afinal.modelo.InscricaoCurso;
import br.edu.ifsuldeminas.afinal.modelo.Usuarios;
import br.edu.ifsuldeminas.afinal.service.CursoGetTask;
import br.edu.ifsuldeminas.afinal.service.InscricaoPostTask;

public class ListaCursoActivity extends AppCompatActivity implements View.OnClickListener {
    private ListView listaCurso;
    private CheckBox check;
    private Button cadastrarCurso;
    private Usuarios usuarioLogado;

    private ArrayList<Integer> id_cursos = new ArrayList<Integer>();
    private SessionManager session;
    private CursoGetTask tarefa;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_curso);

        listaCurso = (ListView) findViewById(R.id.lista_curso);
        check = (CheckBox) findViewById(R.id.checkboxCurso);
        cadastrarCurso = (Button) findViewById(R.id.botao_inscricaoCurso);
        cadastrarCurso.setOnClickListener(this);

        session = new SessionManager(this);
        session.checkLogin();

        usuarioLogado = session.getUser();

//        Intent it = getIntent();
//        id_cursos = it.getIntegerArrayListExtra("lista_cursos");

        carregaLista();
    }

    private void carregaLista() {
        tarefa = new CursoGetTask(this);
        tarefa.execute();

    }

    public ListView getListaCurso() {

        return listaCurso;
    }

    @Override
    protected void onResume() {
        super.onResume();
        carregaLista();
    }

    @Override
    public void onClick(View v) {


        int id_usuario = usuarioLogado.getUsu_id();


        id_cursos = tarefa.getCursos();

        InscricaoCurso isn = new InscricaoCurso();



        if (id_cursos == null){
            Toast.makeText(this, "Lista Vazia", Toast.LENGTH_SHORT).show();
        }

        else {

            for (int i = 0; i< id_cursos.size(); i++){

                String curso = id_cursos.get(i).toString();

                int cursos_id = Integer.parseInt(curso);

//                int cursos_id = id_cursos.get(i);


                isn.setId_usuario(id_usuario);
                isn.setId_curso(cursos_id);


//                String json = new Gson().toJson(isn);

                Toast.makeText(this, "Cursos Selecionado : " + " " +   curso, Toast.LENGTH_LONG).show();
                Toast.makeText(this, "Usuario Logado : " + " " +   isn.getId_usuario(), Toast.LENGTH_LONG).show();

                InscricaoPostTask task = new InscricaoPostTask(this);
                task.execute(Integer.toString(id_usuario), curso);
                finish();

            }
        }

//        for (Integer cursos_id : id_cursos){
//
//            int curso = cursos_id.intValue();
//            Toast.makeText(this, "Cursos " +  curso, Toast.LENGTH_LONG).show();
//            InscricaoPostTask insc = new InscricaoPostTask(this);
//            insc.execute(id_usuario, curso);
//
//        }


//        Toast.makeText(this, "Numero de Cursos " +  listaCurso.getCheckedItemCount(), Toast.LENGTH_LONG).show();

//        Toast.makeText(this, "Cursos Sele " + listaCurso.getCheckedItemIds().toString(), Toast.LENGTH_LONG).show();


    }
}
