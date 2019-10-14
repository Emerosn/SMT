package model;

import java.sql.*;
import java.util.List;
import javax.swing.JOptionPane;

public class ProfessorDAO {
    
    private Connection con = null;
    
    public ProfessorDAO() {
        this.con = new ConnectionFactory().getConnection();
    }
    
    public void insertProf(Professor prof, List<Integer> arr) {
        try {
            int codT = 0, codP = 0;
            
            String queryInsertPessoa = "INSERT INTO pessoa(strNomePessoa, strRgPessoa, strCpfPessoa, strTelPessoa, strEmailPessoa, strSexoPessoa, strCidadePessoa, strEnderecoPessoa, strUfPessoa) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = this.con.prepareStatement(queryInsertPessoa);
            stmt.setString(1, prof.getStrNomePessoa());
            stmt.setString(2, prof.getStrRgPessoa());
            stmt.setString(3, prof.getStrCpfPessoa());
            stmt.setString(4, prof.getStrTelPessoa());
            stmt.setString(5, prof.getStrEmailPessoa());
            stmt.setString(6, prof.getStrSexoPessoa());
            stmt.setString(7, prof.getStrCidadePessoa());
            stmt.setString(8, prof.getStrEnderecoPessoa());
            stmt.setString(9, prof.getStrUfPessoa());
            stmt.execute();
            stmt.close();
            
            String queryBuscar = "SELECT intPessoaId FROM pessoa WHERE strCpfPessoa = ?";
            PreparedStatement stmtBuscar = this.con.prepareStatement(queryBuscar);
            stmtBuscar.setString(1, prof.getStrCpfPessoa());
            ResultSet rs = stmtBuscar.executeQuery();
            
            while (rs.next()) {
                prof.setIntPessoaId(rs.getInt("intPessoaId"));
            }
            
            stmtBuscar.close();
            rs.close();
            
            String insert = "INSERT INTO professor(intPessoaId, strFormacaoProf) VALUES(?, ?)";
            PreparedStatement pst = this.con.prepareStatement(insert);
            pst.setInt(1, prof.getIntPessoaId());
            pst.setString(2, prof.getFormacao());
            pst.execute();
            pst.close();
            
            String buscarP = "SELECT pf.intProfId FROM pessoa AS p INNER JOIN professor AS pf ON pf.intPessoaId = p.intPessoaId WHERE p.intPessoaId = ?";
            PreparedStatement pstBuscarP = this.con.prepareStatement(buscarP);
            pstBuscarP.setInt(1, prof.getIntPessoaId());
            ResultSet rsP = pstBuscarP.executeQuery();
            
            while (rsP.next()) {
                codP = rsP.getInt("intProfId");
            }
            rsP.close();
            
            for (Integer array : arr) {
                String insertTP = "INSERT INTO turma_professor(intTurmaId, intProfId) VALUES(?, ?)";
                PreparedStatement pstP = this.con.prepareStatement(insertTP);
                pstP.setInt(1, Integer.parseInt(array.toString()));
                pstP.setInt(2, codP);
                pstP.execute();
                pstP.close();
            }
            
            this.con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }
    
    public void update(Professor prof) throws SQLException {
        try {
            String queryAlterP = "UPDATE pessoa SET strNomePessoa = ?, strCpfPessoa = ?, strRgPessoa = ?, strTelPessoa = ?, strEmailPessoa = ?, strCidadePessoa = ?, strEnderecoPessoa = ?, strUfPessoa = ? WHERE intPessoaId = ?";
            PreparedStatement stmt = this.con.prepareStatement(queryAlterP);
            stmt.setString(1, prof.getStrNomePessoa());
            stmt.setString(2, prof.getStrCpfPessoa());
            stmt.setString(3, prof.getStrRgPessoa());
            stmt.setString(4, prof.getStrTelPessoa());
            stmt.setString(5, prof.getStrEmailPessoa());
            stmt.setString(6, prof.getStrCidadePessoa());
            stmt.setString(7, prof.getStrEnderecoPessoa());
            stmt.setString(8, prof.getStrUfPessoa());
            stmt.setInt(9, prof.getIntPessoaId());
            stmt.execute();
            
            stmt.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.INFORMATION_MESSAGE);
        } finally {
            this.con.close();
        }
    }
    
   public void delete(int cod){
       try{
            String query = "SELECT * FROM pessoa AS p INNER JOIN professor AS pf ON pf.intPessoaId = p.intPessoaId"                    
                    + " WHERE p.intPessoaId = ?";
            PreparedStatement pst = this.con.prepareStatement(query);
            pst.setInt(1, cod);
            ResultSet rs = pst.executeQuery();
            int codprof = 0;
            
            while(rs.next()){codprof = rs.getInt("intProfId");}
            rs.close();
            pst.close();
            
            String pessoa = "DELETE FROM pessoa WHERE intPessoaId = ?";
            PreparedStatement stmtP = this.con.prepareStatement(pessoa);
            stmtP.setInt(1, cod);
            stmtP.execute();
            stmtP.close();
            
            String prof = "DELETE FROM professor WHERE intProfId = ?";
            PreparedStatement stmtPf = this.con.prepareStatement(prof);
            stmtPf.setInt(1, codprof);
            stmtPf.execute();
            stmtPf.close();
            
       } catch(SQLException e){
           JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.INFORMATION_MESSAGE);
       }
   }
}
