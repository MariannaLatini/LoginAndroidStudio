package com.e.logintccmarianna;

import java.io.Serializable;

public class Aluno implements Serializable {
    private Integer id_aluno;
    private String email_aluno;
    private String senha_aluno;

    public Integer getId_aluno() {
        return id_aluno;
    }

    public void setId_aluno(Integer id_aluno) {
        this.id_aluno = id_aluno;
    }

    public String getEmail_aluno() {
        return email_aluno;
    }

    public void setEmail_aluno(String email_aluno) {
        this.email_aluno = email_aluno;
    }

    public String getSenha_aluno() {
        return senha_aluno;
    }

    public void setSenha_aluno(String senha_aluno) {
        this.senha_aluno = senha_aluno;
    }

    public String toString(){
        return email_aluno;
    }
}
