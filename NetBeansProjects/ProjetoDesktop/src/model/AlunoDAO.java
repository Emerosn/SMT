package model;

import java.sql.*;
import javax.swing.JOptionPane;

public class AlunoDAO {

    private Connection con = null;
    
    public AlunoDAO() {
        this.con = new ConnectionFactory().getConnection();
    }

    public int insertAluno(Aluno a, String turma, String status) throws SQLException {
        try {
            String queryInsertPessoa = "INSERT INTO pessoa(strNomePessoa, strRgPessoa, strCpfPessoa, strTelPessoa, strEmailPessoa, strSexoPessoa, strCidadePessoa, strEnderecoPessoa, strUfPessoa) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = this.con.prepareStatement(queryInsertPessoa);
            stmt.setString(1, a.getStrNomePessoa());
            stmt.setString(2, a.getStrRgPessoa());
            stmt.setString(3, a.getStrCpfPessoa());
            stmt.setString(4, a.getStrTelPessoa());
            stmt.setString(5, a.getStrEmailPessoa());
            stmt.setString(6, a.getStrSexoPessoa());
            stmt.setString(7, a.getStrCidadePessoa());
            stmt.setString(8, a.getStrEnderecoPessoa());
            stmt.setString(9, a.getStrUfPessoa());
            stmt.execute();
            stmt.close();

            String queryBuscar = "SELECT intPessoaId FROM pessoa WHERE strCpfPessoa = ?";
            PreparedStatement stmtBuscar = this.con.prepareStatement(queryBuscar);
            stmtBuscar.setString(1, a.getStrCpfPessoa());
            ResultSet rs = stmtBuscar.executeQuery();

            while (rs.next()) {
                a.setIntPessoaId(rs.getInt("intPessoaId"));
            }

            stmtBuscar.close();
            rs.close();

            String subStrCpf = a.getStrCpfPessoa().substring(0, 3);
            String subStrNome = a.getStrNomePessoa().substring(0, 3);
            String matricula = subStrCpf.concat(subStrNome);
            a.setStrMatricula(matricula);

            String queryInsertAluno = "INSERT INTO aluno(intPessoaId, strMatricula, datDataNasc, strPaiAluno, strMaeAluno) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmtInsertAluno = con.prepareStatement(queryInsertAluno);
            stmtInsertAluno.setInt(1, a.getIntPessoaId());
            stmtInsertAluno.setString(2, a.getStrMatricula());
            stmtInsertAluno.setString(3, a.getDatDataNasc());
            stmtInsertAluno.setString(4, a.getStrPaiAluno());
            stmtInsertAluno.setString(5, a.getStrMaeAluno());
            stmtInsertAluno.execute();
            stmtInsertAluno.close();

            int cod = 0;

            String queryBuscarAluno = "SELECT a.intAlunoId, p.intPessoaId FROM pessoa AS p INNER JOIN aluno AS a ON a.intPessoaId = p.intPessoaId WHERE p.strCpfPessoa = ?";
            PreparedStatement stmtBuscarAluno = con.prepareStatement(queryBuscarAluno);
            stmtBuscarAluno.setString(1, a.getStrCpfPessoa());
            ResultSet rsBuscarAluno = stmtBuscarAluno.executeQuery();

            while (rsBuscarAluno.next()) {
                a.setIntAlunoId(rsBuscarAluno.getInt("intAlunoId"));
                cod = rsBuscarAluno.getInt("intPessoaId");
            }

            stmtBuscarAluno.close();
            rsBuscarAluno.close();

            String queryTurma = "SELECT intTurmaId FROM turma WHERE strDscTurma = ?";
            PreparedStatement stmtTurma = con.prepareStatement(queryTurma);
            stmtTurma.setString(1, turma);
            ResultSet rsTurma = stmtTurma.executeQuery();
            int TurmaId = 0;

            while (rsTurma.next()) {
                TurmaId = rsTurma.getInt("intTurmaId");
            }
            rsTurma.close();
            stmtTurma.close();

            String update = "UPDATE turma SET intVagasOcupadas = intVagasOcupadas+1 WHERE intTurmaId = ?";
            PreparedStatement stmtUpdate = con.prepareStatement(update);
            stmtUpdate.setInt(1, TurmaId);
            stmtUpdate.execute();
            stmtUpdate.close();

            String queryMat = "INSERT INTO matricula(intAlunoId, intTurmaId, strStatusMatricula) VALUES(?, ?, ?)";
            PreparedStatement stmtMat = con.prepareStatement(queryMat);
            stmtMat.setInt(1, a.getIntAlunoId());
            stmtMat.setInt(2, TurmaId);
            stmtMat.setString(3, status);
            stmtMat.execute();
            stmtMat.close();
            
        } catch (SQLException e) {      
            String query = "DELETE FROM pessoa WHERE intPessoaId = ?";
            PreparedStatement pst = this.con.prepareStatement(query);
            pst.setInt(1, a.getIntPessoaId());
            pst.execute();
            pst.close();
            JOptionPane.showMessageDialog(null, "Data com formato inválido", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            return -1;
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Data com formato inválido", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        } finally {
            this.con.close();
        }
        
        return a.getIntPessoaId();
    }

    public void alterAluno(Aluno a) throws SQLException {
        try {
            String queryAlterP = "UPDATE pessoa SET strNomePessoa = ?, strCpfPessoa = ?, strRgPessoa = ?, strTelPessoa = ?, strEmailPessoa = ?, strCidadePessoa = ?, strEnderecoPessoa = ?, strUfPessoa = ? WHERE intPessoaId = ?";
            PreparedStatement stmt = this.con.prepareStatement(queryAlterP);
            stmt.setString(1, a.getStrNomePessoa());
            stmt.setString(2, a.getStrCpfPessoa());
            stmt.setString(3, a.getStrRgPessoa());
            stmt.setString(4, a.getStrTelPessoa());
            stmt.setString(5, a.getStrEmailPessoa());
            stmt.setString(6, a.getStrCidadePessoa());
            stmt.setString(7, a.getStrEnderecoPessoa());
            stmt.setString(8, a.getStrUfPessoa());
            stmt.setInt(9, a.getIntPessoaId());
            stmt.execute();

            stmt.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.INFORMATION_MESSAGE);
        } finally {
            this.con.close();
        }
    }

    public void excluirAluno(int cod) throws SQLException {
        try {
            int codAluno = 0;

            String buscar = "SELECT * "
                    + " FROM pessoa AS p INNER JOIN aluno AS a ON a.intPessoaId = p.intPessoaId"
                    + " WHERE p.intPessoaId = ?";
            PreparedStatement stmtB = this.con.prepareStatement(buscar);
            stmtB.setInt(1, cod);
            ResultSet rs = stmtB.executeQuery();

            while (rs.next()) {
                codAluno = rs.getInt("intAlunoId");
            }
            stmtB.close();
            rs.close();

            String queryExcluirP = "DELETE FROM pessoa WHERE intPessoaId = ?";
            PreparedStatement stmt = this.con.prepareStatement(queryExcluirP);
            stmt.setInt(1, cod);
            stmt.execute();
            stmt.close();

            String queryExcluirA = "DELETE FROM aluno WHERE intAlunoId = ?";
            PreparedStatement stmtExcluirA = this.con.prepareStatement(queryExcluirA);
            stmtExcluirA.setInt(1, codAluno);
            stmtExcluirA.execute();
            stmtExcluirA.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.INFORMATION_MESSAGE);
        } finally {
            this.con.close();
        }
    }
}
