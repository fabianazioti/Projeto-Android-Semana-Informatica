package br.edu.ifsuldeminas.afinal;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifsuldeminas.afinal.helper.CadastroUsuHelper;
import br.edu.ifsuldeminas.afinal.modelo.Usuarios;
import br.edu.ifsuldeminas.afinal.service.UsuarioPostTask;


public class CadastroUsuActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener{

    private CadastroUsuHelper helperCadUsu;
    private Spinner tipoUsu;
    private Button btnCadastrar, bntSair;
    private List<String> tipo_usu = new ArrayList<String>();
    private String nome_tipo_usu;
    private int id_tipo_id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_usu);

        tipoUsu = (Spinner) findViewById(R.id.sp_usu_tipo);
        tipoUsu.setOnItemSelectedListener(this);


        this.helperCadUsu = new CadastroUsuHelper(this);

        btnCadastrar = (Button) findViewById(R.id.btn_reg_usu);
        bntSair = (Button) findViewById(R.id.btn_sair_usu);

        btnCadastrar.setOnClickListener(this);
        bntSair.setOnClickListener(this);
    }
    @Override
    protected void onResume() {
        super.onResume();
        carregarTipoUsu();
    }

    private void carregarTipoUsu() {

        tipo_usu.add("Professor");
        tipo_usu.add("Aluno");
        tipo_usu.add("Palestrante");
        tipo_usu.add("Visitante");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, tipo_usu);
        ArrayAdapter<String> spinnerArrayAdapter = arrayAdapter;
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);

        tipoUsu.setAdapter(spinnerArrayAdapter);
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        //pega nome pela posição
        nome_tipo_usu = parent.getItemAtPosition(position).toString();
        id_tipo_id = parent.getSelectedItemPosition();

        //imprime um Toast na tela com o nome que foi selecionado
        Toast.makeText(parent.getContext(), "Tipo Selecionado: " + nome_tipo_usu, Toast.LENGTH_LONG).show();
    }


    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_reg_usu:
                Usuarios usuario = helperCadUsu.getUsu();
                usuario.setUsu_tipo(id_tipo_id + 1);

                Toast.makeText(this, "TIpo" + usuario.getUsu_tipo(), Toast.LENGTH_LONG).show();

                String json = new Gson().toJson(usuario);

                UsuarioPostTask task = new UsuarioPostTask(this);
                task.execute(json);

                break;
            case R.id.btn_sair_usu:
                finish();
                break;
        }

    }
}
