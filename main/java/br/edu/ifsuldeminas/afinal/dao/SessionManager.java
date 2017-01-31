package br.edu.ifsuldeminas.afinal.dao;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import br.edu.ifsuldeminas.afinal.LoginActivity;
import br.edu.ifsuldeminas.afinal.modelo.Usuarios;

/**
 * Created by fabiana on 15/12/16.
 */
public class SessionManager {
    // preferencias compartilhadas
    private SharedPreferences pref;

    // editor para preferencias
    private SharedPreferences.Editor editor;

    // contexto
    private Context context;

    // modo de compartilhamento
    private int PRIVATE_MODE = 0;

    // nome do arquivo compartilhado
    private String PREF_NAME = "LoginPref";

    // nomes dos campos armazenados nas preferencias
    // esta logado?
    private String IS_LOGIN = "IsLoggedIn";

    // senha do usuario
    private static final String KEY_PASSWORD = "password";

    // email do usuario
    private static final String KEY_LOGIN = "login";

    // tipo do usuario
    private static final String KEY_TYPE = "tipo";

    private static final String KEY_ID = "id";

    public SessionManager(Context context) {
        this.context = context;
        pref = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void createLoginSession(String login, String password, int tipo, int id){
        editor.putBoolean(IS_LOGIN, true);
        editor.putString(KEY_LOGIN, login);
        editor.putString(KEY_PASSWORD, password);
        editor.putInt(KEY_TYPE, tipo);
        editor.putInt(KEY_ID, id);
        editor.commit();
    }
    public Usuarios getUser(){
        Usuarios usuario = new Usuarios();

        usuario.setUsu_login(pref.getString(KEY_LOGIN, null));
        usuario.setUsu_senha(pref.getString(KEY_PASSWORD, null));
        usuario.setUsu_tipo(pref.getInt(KEY_TYPE, 0));
        usuario.setUsu_id(pref.getInt(KEY_ID,0));

        return usuario;
    }

    public boolean isLoggedIn(){
        return pref.getBoolean(IS_LOGIN, false);
    }

    public void checkLogin(){
        if (!this.isLoggedIn()){
            Intent intent = new Intent(context, LoginActivity.class);
            // fecha as outras activities
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            // starta nova activity
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }
    }

    public void logoutUser(){
        editor.clear();
        editor.commit();

        // redireciona para login
        Intent intent = new Intent(context, LoginActivity.class);
        // fecha as outras activities
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        // starta nova activity
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }


}
