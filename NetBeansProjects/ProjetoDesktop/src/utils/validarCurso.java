package utils;

import java.sql.*;
import model.ConnectionFactory;

public class validarCurso {

    private Connection con = null;

    public validarCurso() {
        this.con = new ConnectionFactory().getConnection();
    }

    public boolean isExist(String curso, int Serie, String turno) throws SQLException {

        String query = "SELECT * "
                + "FROM curso WHERE strNomeCurso = ? AND intSerie = ? AND strTurno = ?";
        PreparedStatement pst = this.con.prepareStatement(query);
        pst.setString(1, curso);
        pst.setInt(2, Serie);
        pst.setString(3, turno);
        ResultSet rs = pst.executeQuery();

        rs.last();
        int countRows = rs.getRow();
        rs.beforeFirst();
        
        rs.close();
        pst.close();
        this.con.close();
        
        if (countRows > 0) {
            return true;
        }

        return false;
    }

}
