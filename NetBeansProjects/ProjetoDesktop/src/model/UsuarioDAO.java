package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class UsuarioDAO {
    private Connection con=null;
    
    public UsuarioDAO(){
        this.con = new ConnectionFactory().getConnection();
    }
    
    public void insert(Usuario usu){
        try{
            String query = "INSERT INTO usuario(strSenha, strUserName, strUsuarioTipo) VALUES(?, ?, ?)";
            PreparedStatement pst = this.con.prepareStatement(query);
            pst.setString(1, usu.getStrSenha());
            pst.setString(2, usu.getStrUserName());
            pst.setString(3, usu.getStrUsuarioTipo());
            pst.execute();
            
            pst.close();
            this.con.close();
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public void update(Usuario usu){
        try {
            String query = "UPDATE usuario SET strSenha = ?, strUserName, strUsuarioTipo = ? WHERE intUsuarioId = ?";
            PreparedStatement pst = this.con.prepareStatement(query);
            pst.setString(1, usu.getStrSenha());
            pst.setString(2, usu.getStrUserName());
            pst.setString(3, usu.getStrUsuarioTipo());
            pst.setInt(4, usu.getIntUsuarioId());
            pst.execute();
            
            pst.close();
            this.con.close();
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public void delete(int codUsu){
        try {
            String query = "DELETE FROM usuario WHERE intUsuarioId = ?";
            PreparedStatement pst = this.con.prepareStatement(query);
            pst.setInt(1, codUsu);
            pst.execute();
            
            pst.close();
            this.con.close();
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public List<Usuario> listar(){
        List<Usuario> listar = new ArrayList<>();
        
        try {
            String query = "SELECT * FROM usuario";
            PreparedStatement pst = this.con.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                Usuario usu = new Usuario();
                usu.setIntUsuarioId(rs.getInt("intUsuarioId"));
                usu.setStrUserName(rs.getString("strUserName"));
                usu.setStrUsuarioTipo(rs.getString("strUsuarioTipo"));
                listar.add(usu);
            }
            rs.close();
            pst.close();
            this.con.close();
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.INFORMATION_MESSAGE);
        }
        
        return listar;
    }
    
    public List<Usuario> listarToSearch(String str){
        List<Usuario> listar = new ArrayList<>();
        
        try {
            String query = "SELECT * FROM usuario WHERE strUserName LIKE ?";
            PreparedStatement pst = this.con.prepareStatement(query);
            pst.setString(1, "%"+str+"%");
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                Usuario usu = new Usuario();
                usu.setIntUsuarioId(rs.getInt("intUsuarioId"));
                usu.setStrUserName(rs.getString("strUserName"));
                usu.setStrUsuarioTipo(rs.getString("strUsuarioTipo"));
                listar.add(usu);
            }
            rs.close();
            pst.close();
            this.con.close();
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.INFORMATION_MESSAGE);
        }
        
        return listar;
    }
    
    public List<Usuario> listarToSearch(int cod){
        List<Usuario> listar = new ArrayList<>();
        
        try {
            String query = "SELECT * FROM usuario WHERE intUsuarioId = ?";
            PreparedStatement pst = this.con.prepareStatement(query);
            pst.setInt(1, cod);
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                Usuario usu = new Usuario();
                usu.setIntUsuarioId(rs.getInt("intUsuarioId"));
                usu.setStrUserName(rs.getString("strUserName"));
                usu.setStrUsuarioTipo(rs.getString("strUsuarioTipo"));
                listar.add(usu);
            }
            rs.close();
            pst.close();
            this.con.close();
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.INFORMATION_MESSAGE);
        }
        
        return listar;
    }
}
