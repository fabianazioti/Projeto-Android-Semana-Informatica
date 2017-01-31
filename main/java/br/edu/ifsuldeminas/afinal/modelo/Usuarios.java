package br.edu.ifsuldeminas.afinal.modelo;


/**
 * Created by fabiana on 15/12/16.
 */
public class Usuarios {
    private int usu_id, usu_tipo;
    private String usu_nome, usu_login, usu_senha, usu_cpf, usu_email;

    public int getUsu_id() {
        return usu_id;
    }

    public String getUsu_nome() {
        return usu_nome;
    }

    public void setUsu_nome(String usu_nome) {
        this.usu_nome = usu_nome;
    }

    public String getUsu_login() {
        return usu_login;
    }

    public void setUsu_login(String usu_login) {
        this.usu_login = usu_login;
    }

    public String getUsu_senha() {
        return usu_senha;
    }

    public void setUsu_senha(String usu_senha) {
        this.usu_senha = usu_senha;
    }

    public String getUsu_cpf() {
        return usu_cpf;
    }

    public void setUsu_cpf(String usu_cpf) {
        this.usu_cpf = usu_cpf;
    }

    public String getUsu_email() {
        return usu_email;
    }

    public void setUsu_email(String usu_email) {
        this.usu_email = usu_email;
    }

    public void setUsu_id(int usu_id) {
        this.usu_id = usu_id;
    }

    public int getUsu_tipo() {
        return usu_tipo;
    }

    public void setUsu_tipo(int usu_tipo) {
        this.usu_tipo = usu_tipo;
    }

    public String toString(){
        return usu_nome;
    }
}
