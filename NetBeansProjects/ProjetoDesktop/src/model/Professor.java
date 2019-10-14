package model;

import model.Pessoa;

public class Professor  extends Pessoa{
    private int intProfId, intPessoaId;
    private String formacao;

    public int getIntProfId() {
        return intProfId;
    }

    public void setIntProfId(int intProfId) {
        this.intProfId = intProfId;
    }

    public int getIntPessoaId() {
        return intPessoaId;
    }

    public void setIntPessoaId(int intPessoaId) {
        this.intPessoaId = intPessoaId;
    }

    public String getFormacao() {
        return formacao;
    }

    public void setFormacao(String formacao) {
        this.formacao = formacao;
    }

    public Professor() {
    }
  
}
