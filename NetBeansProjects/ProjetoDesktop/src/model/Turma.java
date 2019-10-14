package model;

import java.sql.Date;

public class Turma {
    
    private int intTurmaId, intCursoId, intCapacidade, intVagasOcupadas;
    private String strHorarioInicio, strHorarioFinal;
    private String strDscTurma;
    
    public Turma(){
    
    }

    public int getIntTurmaId() {
        return intTurmaId;
    }

    public void setIntTurmaId(int intTurmaId) {
        this.intTurmaId = intTurmaId;
    }

    public int getIntCursoId() {
        return intCursoId;
    }

    public void setIntCursoId(int intCursoId) {
        this.intCursoId = intCursoId;
    }

    public int getIntCapacidade() {
        return intCapacidade;
    }

    public void setIntCapacidade(int intCapacidade) {
        this.intCapacidade = intCapacidade;
    }

    public int getIntVagasOcupadas() {
        return intVagasOcupadas;
    }

    public void setIntVagasOcupadas(int intVagasOcupadas) {
        this.intVagasOcupadas = intVagasOcupadas;
    }

    public String getStrHorarioInicio() {
        return strHorarioInicio;
    }

    public void setStrHorarioInicio(String strHorarioInicio) {
        this.strHorarioInicio = strHorarioInicio;
    }

    public String getStrHorarioFinal() {
        return strHorarioFinal;
    }

    public void setStrHorarioFinal(String strHorarioFinal) {
        this.strHorarioFinal = strHorarioFinal;
    }

    public String getStrDscTurma() {
        return strDscTurma;
    }

    public void setStrDscTurma(String strDscTurma) {
        this.strDscTurma = strDscTurma;
    }
    
    
}
