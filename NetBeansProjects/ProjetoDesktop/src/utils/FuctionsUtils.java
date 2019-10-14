package utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.*;

public class FuctionsUtils {

    private Connection con = null;

    public FuctionsUtils() {
        this.con = new ConnectionFactory().getConnection();
    }

    public boolean isExistMatInTurma(int codPessoa) throws SQLException {
        String query = "SELECT * FROM pessoa AS p RIGHT JOIN aluno AS a ON a.intPessoaId = p.intPessoaId"
                + " RIGHT JOIN matricula AS m ON m.intAlunoId = a.intAlunoId"
                + " RIGHT JOIN turma AS t ON t.intTurmaId = m.intTurmaId"
                + " WHERE p.intPessoaId = ? GROUP BY m.intTurmaId HAVING COUNT(*) > 0";
        PreparedStatement pst = this.con.prepareStatement(query);
        pst.setInt(1, codPessoa);
        ResultSet rs = pst.executeQuery();

        rs.last();
        int countRows = rs.getRow();
        rs.beforeFirst();

        if (countRows > 0) {
            return true;
        }

        return false;
    }

    public boolean isExistProfInTurma(int codPessoa) throws SQLException {
        String query = "SELECT * FROM pessoa AS p RIGHT JOIN professor AS pf ON pf.intPessoaId = p.intPessoaId"
                + " RIGHT JOIN turma_professor AS tp ON tp.intProfId = pf.intProfId"
                + " RIGHT JOIN turma AS t ON t.intTurmaId = tp.intTurmaId"
                + " WHERE p.intPessoaId = ? GROUP BY tp.intTurmaId HAVING COUNT(*) > 0";
        PreparedStatement pst = this.con.prepareStatement(query);
        pst.setInt(1, codPessoa);
        ResultSet rs = pst.executeQuery();

        rs.last();
        int countRows = rs.getRow();
        rs.beforeFirst();

        if (countRows > 0) {
            return true;
        }

        return false;
    }
    
    public boolean isExistTurmaInnerProf(int codTurma) throws SQLException {
        String query = "SELECT * FROM pessoa AS p RIGHT JOIN professor AS pf ON pf.intPessoaId = p.intPessoaId"
                + " RIGHT JOIN turma_professor AS tp ON tp.intProfId = pf.intProfId"
                + " RIGHT JOIN turma AS t ON t.intTurmaId = tp.intTurmaId"
                + " WHERE t.intTurmaId = ? GROUP BY tp.intTurmaId HAVING COUNT(tp.intTurmaId) > 0";
        PreparedStatement pst = this.con.prepareStatement(query);
        pst.setInt(1, codTurma);
        ResultSet rs = pst.executeQuery();

        rs.last();
        int countRows = rs.getRow();
        rs.beforeFirst();

        if (countRows > 0) {
            return true;
        }

        return false;
    }
    
    public boolean isExistTurmaInMat(int codTurma) throws SQLException {
        String query = "SELECT * FROM pessoa AS p RIGHT JOIN aluno AS a ON a.intPessoaId = p.intPessoaId"
                + " RIGHT JOIN matricula AS m ON m.intAlunoId = a.intAlunoId"
                + " RIGHT JOIN turma AS t ON t.intTurmaId = m.intTurmaId"
                + " WHERE m.intTurmaId = ? GROUP BY m.intTurmaId HAVING COUNT(*) > 0";
        PreparedStatement pst = this.con.prepareStatement(query);
        pst.setInt(1, codTurma);
        ResultSet rs = pst.executeQuery();

        rs.last();
        int countRows = rs.getRow();
        rs.beforeFirst();

        if (countRows > 0) {
            return true;
        }

        return false;
    }

    public boolean isExistCursoInTurma(int codCurso) throws SQLException {
        String query = "SELECT * "
                + " FROM curso AS c RIGHT JOIN turma AS t ON t.intCursoId = c.intCursoId"
                + " WHERE c.intCursoId = ? GROUP BY t.intCursoId HAVING COUNT(*) > 0";
        PreparedStatement pst = this.con.prepareStatement(query);
        pst.setInt(1, codCurso);
        ResultSet rs = pst.executeQuery();

        rs.last();
        int countRows = rs.getRow();
        rs.beforeFirst();

        if (countRows > 0) {
            return true;
        }

        return false;
    }

    public void deleteProfToTurma(String cpf) {
        try {
            String query = "SELECT tp.intTurmaProfId FROM pessoa AS p INNER JOIN professor AS pf ON pf.intPessoaId = p.intPessoaId"
                    + " INNER JOIN turma_professor AS tp ON tp.intProfId = pf.intProfId"
                    + " INNER JOIN turma AS t ON t.intTurmaId = tp.intTurmaId"
                    + " WHERE p.strCpfPessoa = ?";
            PreparedStatement pst = this.con.prepareStatement(query);
            pst.setString(1, cpf);
            ResultSet rs = pst.executeQuery();

            PreparedStatement pstDel = null;
            while (rs.next()) {
                String delete = "DELETE FROM turma_professor WHERE intTurmaProfId = ?";
                pstDel = this.con.prepareStatement(delete);
                pstDel.setInt(1, rs.getInt("intTurmaProfId"));
                pstDel.execute();
            }

            pst.close();
            pstDel.close();
            rs.close();
            this.con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void deleteAlunoToTurma(String cpf) {
        try {
            int turma = 0, codMatricula = 0;

            String buscar = "SELECT * "
                    + " FROM pessoa AS p INNER JOIN aluno AS a ON a.intPessoaId = p.intPessoaId"
                    + " INNER JOIN matricula AS m ON m.intAlunoId = a.intAlunoId "
                    + " INNER JOIN turma AS t ON t.intTurmaId = m.intTurmaId WHERE p.strCpfPessoa = ?";
            PreparedStatement stmtB = this.con.prepareStatement(buscar);
            stmtB.setString(1, cpf);
            ResultSet rs = stmtB.executeQuery();

            while (rs.next()) {
                turma = rs.getInt("intTurmaId");
                codMatricula = rs.getInt("intMatriculaId");
            }
            stmtB.close();
            rs.close();

            String queryExcluirM = "DELETE FROM matricula WHERE intMatriculaId = ?";
            PreparedStatement stmtExcluirM = this.con.prepareStatement(queryExcluirM);
            stmtExcluirM.setInt(1, codMatricula);
            stmtExcluirM.execute();
            stmtExcluirM.close();

            String update = "UPDATE turma SET intVagasOcupadas = intVagasOcupadas-1 WHERE intTurmaId = ?";
            PreparedStatement stmtU = this.con.prepareStatement(update);
            stmtU.setInt(1, turma);
            stmtU.execute();
            stmtU.close();

            this.con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void transferAlunoToTurma(int codMat, int turmaPos, int turmaAnt) {
        try {
            this.con = new ConnectionFactory().getConnection();
            String update = "UPDATE matricula SET intTurmaId = ? WHERE intMatriculaId = ?";
            PreparedStatement pst = this.con.prepareStatement(update);
            pst.setInt(1, turmaPos);
            pst.setInt(2, codMat);
            pst.execute();
            pst.close();

            String updateT = "UPDATE turma SET intVagasOcupadas = intVagasOcupadas+1 WHERE intTurmaId = ?";
            PreparedStatement stmtU = this.con.prepareStatement(updateT);
            stmtU.setInt(1, turmaPos);
            stmtU.execute();
            stmtU.close();

            String updateAnt = "UPDATE turma SET intVagasOcupadas = intVagasOcupadas-1 WHERE intTurmaId = ?";
            PreparedStatement stmtAnt = this.con.prepareStatement(updateAnt);
            stmtAnt.setInt(1, turmaAnt);
            stmtAnt.execute();
            stmtAnt.close();

            this.con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void transferProfToTurma(List<TurmaProfessor> lista) {
        try {
            for (TurmaProfessor arr : lista) {
                String update = "UPDATE turma_professor SET intTurmaId = ? WHERE intTurmaProfId = ?";
                PreparedStatement pst = this.con.prepareStatement(update);
                pst.setInt(1, arr.getIntTurmaId());
                pst.setInt(2, arr.getIntTurmaProfId());
                pst.execute();
                pst.close();
            }
            this.con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public List<Turma> turmasDisponiveis(String turno, int Serie, int qtAlunoInTurma) {
        List<Turma> lista = new ArrayList<>();

        try {
            String query = "SELECT *"
                    + " FROM turma AS t INNER JOIN curso AS c ON c.intCursoId = t.intCursoId"
                    + " WHERE c.strTurno <> ? AND c.intSerie = ?"
                    + " AND t.intCapacidade >= (t.intVagasOcupadas + ?)";
            PreparedStatement pst = this.con.prepareStatement(query);
            pst.setString(1, turno);
            pst.setInt(2, Serie);
            pst.setInt(3, qtAlunoInTurma);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Turma t = new Turma();
                t.setIntTurmaId(rs.getInt("intTurmaId"));
                t.setIntCapacidade(rs.getInt("intCapacidade"));
                t.setStrDscTurma(rs.getString("strDscTurma"));
                t.setStrHorarioInicio(rs.getString("strHorarioInicio"));
                t.setStrHorarioFinal(rs.getString("strHorarioFinal"));
                t.setIntVagasOcupadas(rs.getInt("intVagasOcupadas"));
                t.setIntCursoId(rs.getInt("intCursoId"));
                lista.add(t);
            }

            rs.close();
            pst.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.INFORMATION_MESSAGE);
        }

        return lista;
    }

    public boolean isExistNameToTurma(String turma) throws SQLException {
        String query = "SELECT *"
                + " FROM turma WHERE strDscTurma = ?";
        PreparedStatement pst = this.con.prepareStatement(query);
        pst.setString(1, turma);
        ResultSet rs = pst.executeQuery();

        rs.last();
        int countRows = rs.getRow();
        rs.beforeFirst();

        if (countRows > 0) {
            return true;
        }

        return false;
    }

    public List<Turma> turmasDisponiveisToOne(String turno, int Serie) {
        List<Turma> lista = new ArrayList<>();

        try {
            String query = "SELECT *"
                    + " FROM turma AS t INNER JOIN curso AS c ON c.intCursoId = t.intCursoId"
                    + " WHERE c.strTurno <> ? AND c.intSerie = ?";
            PreparedStatement pst = this.con.prepareStatement(query);
            pst.setString(1, turno);
            pst.setInt(2, Serie);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Turma t = new Turma();
                t.setIntTurmaId(rs.getInt("intTurmaId"));
                t.setIntCapacidade(rs.getInt("intCapacidade"));
                t.setStrDscTurma(rs.getString("strDscTurma"));
                t.setStrHorarioInicio(rs.getString("strHorarioInicio"));
                t.setStrHorarioFinal(rs.getString("strHorarioFinal"));
                t.setIntVagasOcupadas(rs.getInt("intVagasOcupadas"));
                t.setIntCursoId(rs.getInt("intCursoId"));
                lista.add(t);
            }

            rs.close();
            pst.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.INFORMATION_MESSAGE);
        }

        return lista;
    }
    
    public boolean isExistUsu(String str){
        try{
            String query = "SELECT *"
                    + " FROM usuario WHERE strUserName = ?";
            PreparedStatement pst = this.con.prepareStatement(query);
            pst.setString(1, str);
            ResultSet rs = pst.executeQuery();
            
            rs.last();
            int countRows = rs.getRow();
            rs.beforeFirst();
            
            if(countRows > 0){
                return true;
            }
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.INFORMATION_MESSAGE);
        }
        
        return false;
    }
}
