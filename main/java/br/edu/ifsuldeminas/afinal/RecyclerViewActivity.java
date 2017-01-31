package br.edu.ifsuldeminas.afinal;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends Activity {

    private List<Icone> persons;
    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.recyclerview_activity);

        rv=(RecyclerView)findViewById(R.id.rv);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);

        initializeData();
        initializeAdapter();

    }

    private void initializeData(){
        persons = new ArrayList<>();
        persons.add(new Icone("Felipe Campos Lima",  R.drawable.informacoes, "19/11/2016"));
        persons.add(new Icone("Thiago Lima", R.drawable.thiago, "20/11/2016"));
        persons.add(new Icone("Túlio Gomes Alves", R.drawable.redesoci, "21/11/2016"));
        persons.add(new Icone("Waldyr Felix", R.drawable.informacoes,"21/11/2016"));

    }

    private void initializeAdapter(){
        RVAdapter adapter = new RVAdapter(persons);
        rv.setAdapter(adapter);
    }
    

}
