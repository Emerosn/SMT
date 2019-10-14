package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConnectionFactory {
    private Connection con;
    public ConnectionFactory(){}
    
    public Connection getConnection(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch(ClassNotFoundException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        String url = "jdbc:mysql://localhost:3306/escoladesktop?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String usr = "root";
        String passwd = "";
        
        try{
            con = DriverManager.getConnection(url, usr, passwd);
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        return con;
    }
}
