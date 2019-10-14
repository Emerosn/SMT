package model;

import java.sql.*;
import javax.swing.JOptionPane;

public class LogUsr {
    private Connection con = null;
    private String LogNome, tipoTmp;

    public String getTipoTmp() {
        return tipoTmp;
    }

    public void setTipoTmp(String tipoTmp) {
        this.tipoTmp = tipoTmp;
    }
    
    public LogUsr(){
        this.con = new ConnectionFactory().getConnection();
    }
    
    public String getLogNome(){
        return this.LogNome;
    }
    
    public void setLogNome(String LogNome){
        this.LogNome = LogNome;
    }
    
    public void setLogUser() throws SQLException{
        try{
            
            String buscar = "SELECT strUsuarioTipo FROM usuario WHERE strUserName = ?";
            PreparedStatement stmtBuscar = con.prepareStatement(buscar);
            stmtBuscar.setString(1, this.getLogNome());
            ResultSet rs = stmtBuscar.executeQuery();
            
            while(rs.next()){ tipoTmp = rs.getString("strUsuarioTipo");}
            rs.close();
            stmtBuscar.close();
            
            String queryLog = "INSERT INTO log_usr_table(strNameTmp, strTipo) VALUES (?, ?)";
            PreparedStatement stmtLog = con.prepareStatement(queryLog);
            stmtLog.setString(1, this.getLogNome());
            stmtLog.setString(2, tipoTmp);
            stmtLog.execute();
            stmtLog.close();
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.ERROR_MESSAGE);
        } finally{
            this.con.close();
        }
    }
    
    public String getLogUser() throws SQLException{
       try{
            String queryLog = "SELECT strNameTmp, strTipo FROM log_usr_table";
            PreparedStatement stmtLog = con.prepareStatement(queryLog);
            ResultSet rsLog = stmtLog.executeQuery();
            
            while(rsLog.next()){ 
                this.LogNome = rsLog.getString("strNameTmp");
                this.tipoTmp = rsLog.getString("strTipo");
            }
            
            rsLog.close();
            stmtLog.close();
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.ERROR_MESSAGE);
        } finally{
           this.con.close();
       }
       
       return this.LogNome;
    }
    
    public void truncateLog() throws SQLException{
        try {
            String queryLogExit = "TRUNCATE TABLE log_usr_table";
            PreparedStatement stmtLogExit = con.prepareStatement(queryLogExit);
            stmtLogExit.execute();
                        
            stmtLogExit.close();
            con.close();
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.ERROR_MESSAGE);
        } finally {
            con.close();
        }
    }
}
