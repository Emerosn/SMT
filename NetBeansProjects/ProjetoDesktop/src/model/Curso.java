package model;

import java.util.Date;

public class Curso {
    private int intCursoId, intDurcao, intSerie;
    private Date anoLetivo;
    private String strTurno, strNomeCurso;

    public Curso() {
    }

    public Curso(int intCursoId, int intSerie, Date anoLetivo, String strTurno, String strNomeCurso) {
        this.intCursoId = intCursoId;
        this.intSerie = intSerie;
        this.anoLetivo = anoLetivo;
        this.strTurno = strTurno;
        this.strNomeCurso = strNomeCurso;
    }

    public int getIntCursoId() {
        return intCursoId;
    }

    public void setIntCursoId(int intCursoId) {
        this.intCursoId = intCursoId;
    }

    public int getIntDurcao() {
        return intDurcao;
    }

    public void setIntDurcao(int intDurcao) {
        this.intDurcao = intDurcao;
    }

    public int getIntSerie() {
        return intSerie;
    }

    public void setIntSerie(int intSerie) {
        this.intSerie = intSerie;
    }

    public Date getAnoLetivo() {
        return anoLetivo;
    }

    public void setAnoLetivo(Date anoLetivo) {
        this.anoLetivo = anoLetivo;
    }

    public String getStrTurno() {
        return strTurno;
    }

    public void setStrTurno(String strTurno) {
        this.strTurno = strTurno;
    }

    public String getStrNomeCurso() {
        return strNomeCurso;
    }

    public void setStrNomeCurso(String strNomeCurso) {
        this.strNomeCurso = strNomeCurso;
    }
    
    
    
}
