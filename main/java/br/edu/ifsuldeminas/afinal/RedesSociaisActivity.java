package br.edu.ifsuldeminas.afinal;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RedesSociaisActivity extends AppCompatActivity implements View.OnClickListener {

    private Button face_cc;
    private Button face_ca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_redes_sociais);

        face_ca = (Button) findViewById(R.id.facebook_ca);
        face_cc = (Button) findViewById(R.id.facebook_cc);

        face_cc.setOnClickListener(this);
        face_ca.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.facebook_ca:
                Intent abrirUrl = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/ca.comp.muz/?fref=ts"));
                startActivity(abrirUrl);
                break;
            case R.id.facebook_cc:
                break;
        }

    }
}
