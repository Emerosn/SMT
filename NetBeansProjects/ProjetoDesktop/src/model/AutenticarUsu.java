package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class AutenticarUsu implements autenticar{
    private Connection con = null;
    
    public AutenticarUsu(){
        this.con = new ConnectionFactory().getConnection();
    }
    
    @Override
    public boolean autenticar(String usr, String passwd){
        
        try{
            int cont=0;
            String query = "SELECT * FROM usuario WHERE strUserName = ? AND strSenha = ?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, usr);
            stmt.setString(2, passwd);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                cont++;
            }
            
            con.close();
            stmt.close();
            rs.close();
            
            if(cont > 0){
                return true;
            } else {
                return false;
            }
            
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
}
