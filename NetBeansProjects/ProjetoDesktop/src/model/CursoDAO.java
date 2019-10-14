package model;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class CursoDAO {

    private Connection con = null;

    public CursoDAO() {
        this.con = new ConnectionFactory().getConnection();
    }

    public void insert(Curso curso) throws SQLException {

        try {
            SimpleDateFormat df = new SimpleDateFormat("YYYY");
            String insert = "INSERT INTO curso(strNomeCurso, intDuracao, strTurno, intSerie, strAnoLetivo)"
                    + " VALUES(?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(insert);
            pst.setString(1, curso.getStrNomeCurso());
            pst.setInt(2, curso.getIntDurcao());
            pst.setString(3, curso.getStrTurno());
            pst.setInt(4, curso.getIntSerie());
            pst.setString(5, df.format(curso.getAnoLetivo()));
            pst.execute();
            pst.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.INFORMATION_MESSAGE);
        } finally {
            this.con.close();
        }
    }

    public void update(Curso curso) throws SQLException {
        try {
            SimpleDateFormat df = new SimpleDateFormat("YYYY");
            String update = "UPDATE curso SET strNomeCurso = ?, intDuracao = ?, strTurno = ?, intSerie = ?, strAnoLetivo = ?"
                    + " WHERE intCursoId = ?";
            PreparedStatement pst = con.prepareStatement(update);
            pst.setString(1, curso.getStrNomeCurso());
            pst.setInt(2, curso.getIntDurcao());
            pst.setString(3, curso.getStrTurno());
            pst.setInt(4, curso.getIntSerie());
            pst.setString(5, df.format(curso.getAnoLetivo()));
            pst.setInt(6, curso.getIntCursoId());
            pst.execute();
            pst.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.INFORMATION_MESSAGE);
        } finally {
            this.con.close();
        }
    }

    public void delete(Curso curso) throws SQLException {
        try {
            String delete = "DELETE FROM curso WHERE intCursoId = ?";
            PreparedStatement pst = con.prepareStatement(delete);
            pst.setInt(1, curso.getIntCursoId());
            pst.execute();
            pst.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.INFORMATION_MESSAGE);
        } finally {
            this.con.close();
        }
    }

    public List<Curso> listar() throws SQLException {
        List<Curso> lista = new ArrayList<>();

        try {
            String listar = "SELECT * "
                    + "FROM curso";
            PreparedStatement pst = con.prepareStatement(listar);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Curso curso = new Curso();
                curso.setIntCursoId(rs.getInt("intCursoId"));
                curso.setStrNomeCurso(rs.getString("strNomeCurso"));
                curso.setStrTurno(rs.getString("strTurno"));
                curso.setIntDurcao(rs.getInt("intDuracao"));
                curso.setIntSerie(rs.getInt("intSerie"));
                curso.setAnoLetivo(rs.getDate("strAnoLetivo"));
                lista.add(curso);
            }
            rs.close();
            pst.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.INFORMATION_MESSAGE);
        } finally {
            this.con.close();
        }

        return lista;
    }

    public List<Curso> listarToFilter(String turno) throws SQLException {
        List<Curso> lista = new ArrayList<>();

        if (!turno.equalsIgnoreCase("todos")) {
            try {
                String listar = "SELECT * "
                        + "FROM curso WHERE strTurno = ?";
                PreparedStatement pst = con.prepareStatement(listar);
                pst.setString(1, turno);
                ResultSet rs = pst.executeQuery();

                while (rs.next()) {
                    Curso curso = new Curso();
                    curso.setIntCursoId(rs.getInt("intCursoId"));
                    curso.setStrNomeCurso(rs.getString("strNomeCurso"));
                    curso.setStrTurno(rs.getString("strTurno"));
                    curso.setIntDurcao(rs.getInt("intDuracao"));
                    curso.setIntSerie(rs.getInt("intSerie"));
                    curso.setAnoLetivo(rs.getDate("strAnoLetivo"));
                    lista.add(curso);
                }
                rs.close();
                pst.close();

                this.con.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            try {
                String listar = "SELECT * "
                        + "FROM curso ";
                PreparedStatement pst = con.prepareStatement(listar);
                ResultSet rs = pst.executeQuery();

                while (rs.next()) {
                    Curso curso = new Curso();
                    curso.setIntCursoId(rs.getInt("intCursoId"));
                    curso.setStrNomeCurso(rs.getString("strNomeCurso"));
                    curso.setStrTurno(rs.getString("strTurno"));
                    curso.setIntDurcao(rs.getInt("intDuracao"));
                    curso.setIntSerie(rs.getInt("intSerie"));
                    curso.setAnoLetivo(rs.getDate("strAnoLetivo"));
                    lista.add(curso);
                }
                rs.close();
                pst.close();

                this.con.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        return lista;
    }

    public List<Curso> listarToCod(int cod) throws SQLException {
        List<Curso> lista = new ArrayList<>();

        try {
            String listar = "SELECT * "
                    + "FROM curso WHERE intCursoId = ?";
            PreparedStatement pst = con.prepareStatement(listar);
            pst.setInt(1, cod);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Curso curso = new Curso();
                curso.setIntCursoId(rs.getInt("intCursoId"));
                curso.setStrNomeCurso(rs.getString("strNomeCurso"));
                curso.setStrTurno(rs.getString("strTurno"));
                curso.setIntDurcao(rs.getInt("intDuracao"));
                curso.setIntSerie(rs.getInt("intSerie"));
                curso.setAnoLetivo(rs.getDate("strAnoLetivo"));
                lista.add(curso);
            }
            rs.close();
            pst.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.INFORMATION_MESSAGE);
        } finally {
            this.con.close();
        }

        return lista;
    }
}
