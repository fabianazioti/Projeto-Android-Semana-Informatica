package br.edu.ifsuldeminas.afinal.modelo;

/**
 * Created by fabiana on 15/12/16.
 */
public class Tipo_Usuario {
    private int id_tipo_usu;
    private String tipo_nome;

    public int getId_tipo_usu() {
        return id_tipo_usu;
    }

    public void setId_tipo_usu(int id_tipo_usu) {
        this.id_tipo_usu = id_tipo_usu;
    }

    public String toString(){

        return tipo_nome;
    }

}
