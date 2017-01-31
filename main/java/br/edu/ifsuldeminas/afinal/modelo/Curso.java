package br.edu.ifsuldeminas.afinal.modelo;

/**
 * Created by fabiana on 28/12/16.
 */
public class Curso {
    private int curso_id;
    private String curso_nome, curso_desc, curso_dia;
    private Usuarios curso_ministrante;

    public Usuarios getCurso_ministrante() {
        return curso_ministrante;
    }

    public void setCurso_ministrante(Usuarios curso_ministrante) {
        this.curso_ministrante = curso_ministrante;
    }

    public int getCurso_id() {
        return curso_id;
    }

    public void setCurso_id(int curso_id) {
        this.curso_id = curso_id;
    }


    public String getCurso_nome() {
        return curso_nome;
    }

    public void setCurso_nome(String curso_nome) {
        this.curso_nome = curso_nome;
    }

    public String getCurso_desc() {
        return curso_desc;
    }

    public void setCurso_desc(String curso_desc) {
        this.curso_desc = curso_desc;
    }

    public String getCurso_dia() {
        return curso_dia;
    }

    public void setCurso_dia(String curso_dia) {
        this.curso_dia = curso_dia;
    }
}
