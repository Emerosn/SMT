package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class TurmaDAO {

    private Connection con = null;

    public TurmaDAO() {
        this.con = new ConnectionFactory().getConnection();
    }

    public boolean insert(Turma t, int codCurso) throws SQLException {
        try {
            String insert = "INSERT INTO turma(intCursoId, intCapacidade, strHorarioInicio, strHorarioFinal, strDscTurma, intVagasOcupadas)"
                    + " VALUES(?, ?, ?, ?, ?, ?)";
            PreparedStatement pst = this.con.prepareStatement(insert);
            pst.setInt(1, codCurso);
            pst.setInt(2, t.getIntCapacidade());
            pst.setString(3, t.getStrHorarioInicio());
            pst.setString(4, t.getStrHorarioFinal());
            pst.setString(5, t.getStrDscTurma());
            pst.setInt(6, 0);
            pst.execute();
            pst.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Horário Inválido!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            return false;
        } finally {
            this.con.close();
        }
        
        return true;
    }

    public boolean update(Turma t) throws SQLException {
        try {
            String update = "UPDATE turma SET intCapacidade = ?, strHorarioInicio = ?, strHorarioFinal = ?, strDscTurma = ? WHERE intTurmaId = ?";
            PreparedStatement pst = this.con.prepareStatement(update);
            pst.setInt(1, t.getIntCapacidade());
            pst.setString(2, t.getStrHorarioInicio());
            pst.setString(3, t.getStrHorarioFinal());
            pst.setString(4, t.getStrDscTurma());
            pst.setInt(5, t.getIntTurmaId());

            pst.execute();
            pst.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Horário Inválido!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            return false;
        } finally {
            this.con.close();
        }
        
        return true;
    }

    public List<Turma> lista() {
        List<Turma> lista = new ArrayList<>();
        try {
            String listar = "SELECT * FROM turma";
            PreparedStatement pst = this.con.prepareStatement(listar);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Turma t = new Turma();
                t.setIntTurmaId(rs.getInt("intTurmaId"));
                t.setIntCapacidade(rs.getInt("intCapacidade"));
                t.setStrHorarioInicio(rs.getString("strHorarioInicio"));
                t.setStrHorarioFinal(rs.getString("strHorarioFinal"));
                t.setStrDscTurma(rs.getString("strDscTurma"));
                t.setIntVagasOcupadas(rs.getInt("intVagasOcupadas"));
                lista.add(t);
            }
            pst.close();
            rs.close();
            this.con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.INFORMATION_MESSAGE);
        }

        return lista;
    }

    public void delete(int codTurma) {
        try {
            String delete = "DELETE FROM turma WHERE intTurmaId = ?";
            PreparedStatement pst = this.con.prepareStatement(delete);
            pst.setInt(1, codTurma);
            pst.execute();
            pst.close();

            String update = "UPDATE turma SET intVagasOcupadas = intVagasOcupadas-1 WHERE intTurmaId = ?";
            PreparedStatement pstUp = this.con.prepareStatement(update);
            pstUp.setInt(1, codTurma);
            pstUp.execute();
            pstUp.close();

            this.con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public List<Turma> listaToSearch(String turma) {
        List<Turma> lista = new ArrayList<>();
        try {
            String listar = "SELECT * FROM turma WHERE strDscTurma LIKE ?";
            PreparedStatement pst = this.con.prepareStatement(listar);
            pst.setString(1, "%" + turma + "%");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Turma t = new Turma();
                t.setIntTurmaId(rs.getInt("intTurmaId"));
                t.setIntCapacidade(rs.getInt("intCapacidade"));
                t.setStrHorarioInicio(rs.getString("strHorarioInicio"));
                t.setStrHorarioFinal(rs.getString("strHorarioFinal"));
                t.setStrDscTurma(rs.getString("strDscTurma"));
                t.setIntVagasOcupadas(rs.getInt("intVagasOcupadas"));
                lista.add(t);
            }
            pst.close();
            rs.close();
            this.con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.INFORMATION_MESSAGE);
        }

        return lista;
    }

    public List<Turma> listaToSearch(int cod) {
        List<Turma> lista = new ArrayList<>();
        try {
            String listar = "SELECT * FROM turma WHERE intTurmaId = ?";
            PreparedStatement pst = this.con.prepareStatement(listar);
            pst.setInt(1, cod);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Turma t = new Turma();
                t.setIntTurmaId(rs.getInt("intTurmaId"));
                t.setIntCapacidade(rs.getInt("intCapacidade"));
                t.setStrHorarioInicio(rs.getString("strHorarioInicio"));
                t.setStrHorarioFinal(rs.getString("strHorarioFinal"));
                t.setStrDscTurma(rs.getString("strDscTurma"));
                t.setIntVagasOcupadas(rs.getInt("intVagasOcupadas"));
                lista.add(t);
            }
            pst.close();
            rs.close();
            this.con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.INFORMATION_MESSAGE);
        }

        return lista;
    }
}
