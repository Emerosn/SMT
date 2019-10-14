package model;

public class Aluno extends Pessoa{
    private int intAlunoId, intPessoaId;
    private String strMatricula, datDataNasc, strMaeAluno, strPaiAluno;
    
    public Aluno(){
        
    }

    public String getStrMaeAluno() {
        return strMaeAluno;
    }

    public void setStrMaeAluno(String strMaeAluno) {
        this.strMaeAluno = strMaeAluno;
    }

    public String getStrPaiAluno() {
        return strPaiAluno;
    }

    public void setStrPaiAluno(String strPaiAluno) {
        this.strPaiAluno = strPaiAluno;
    }
 
    public String getStrMatricula() {
        return strMatricula;
    }

    public void setStrMatricula(String strMatricula) {
        this.strMatricula = strMatricula;
    }
    
    public int getIntAlunoId() {
        return intAlunoId;
    }

    public void setIntAlunoId(int intAlunoId) {
        this.intAlunoId = intAlunoId;
    }

    public int getIntPessoaId() {
        return intPessoaId;
    }

    public void setIntPessoaId(int intPessoaId) {
        this.intPessoaId = intPessoaId;
    }

    public String getDatDataNasc() {
        return datDataNasc;
    }

    public void setDatDataNasc(String datDataNasc) {
        this.datDataNasc = datDataNasc;
    }
}
