package br.edu.ifsuldeminas.afinal.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifsuldeminas.afinal.R;
import br.edu.ifsuldeminas.afinal.modelo.Curso;

/**
 * Created by fabiana on 28/12/16.
 */
public class CursoAdapter extends BaseAdapter {

    private Context context;
    private List<Curso> lista;
    private ArrayList<Integer> id_cursos = new ArrayList<Integer>();


    public CursoAdapter(Context context, List<Curso> lista) {
        this.lista = lista;
        this.context = context;
    }

    @Override
    public int getCount() {

        return lista.size();
    }

    public ArrayList<Integer> getResultado(){
        if (id_cursos == null){
            Toast.makeText(context, "Lista VaziaAdapter", Toast.LENGTH_SHORT).show();
        }

        return id_cursos;
    }

    @Override
    public Object getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return lista.get(position).getCurso_id();
    }

    @Override
    public View getView(int i, final View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);


        View view = convertView; // muitas vezes a view ja vem pronta e não necessitamos fazer alterações na view
        if (view == null) {
            view = inflater.inflate(R.layout.curso_item, parent, false);
        }

        Toast.makeText(context, "Chamou adapter", Toast.LENGTH_SHORT).show();
        Curso curso = lista.get(i);

        TextView campoCursoNome = (TextView) view.findViewById(R.id.curso_nome);
        campoCursoNome.setText(curso.getCurso_nome());

        TextView campoCursoData = (TextView) view.findViewById(R.id.curso_data);
        campoCursoData.setText(curso.getCurso_dia());

        CheckBox campoCheck = (CheckBox) view.findViewById(R.id.checkboxCurso);
        campoCheck.setText(Integer.toString(curso.getCurso_id()));
        campoCheck.setTag(Integer.toString(curso.getCurso_id()));

        campoCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckBox chk = (CheckBox) v;
                String estado = (String) chk.getTag();
                if(chk.isChecked()) {
                    Toast.makeText(context, "Checbox de " + estado + " marcado!", Toast.LENGTH_SHORT).show();
                    id_cursos.add(Integer.parseInt(estado));
                } else {
                    Toast.makeText(context, "Checbox de " + estado + " desmarcado!", Toast.LENGTH_SHORT).show();
                    id_cursos.remove(Integer.parseInt(estado));
                }
            }
        });



        return view;
    }
}
