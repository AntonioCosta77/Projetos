package br.com.colchonete.Dao;

import br.com.colchonete.Bean.UsuarioBean;
import br.com.colchonete.Utilitarios.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author antonio
 */
public class UsuarioDao {
    private Conexao con;

    public UsuarioDao() {
        con = new Conexao();
    }
    
    public  boolean salvarUsuario(UsuarioBean usuario){
        
        try {
            
            String sql = "INSERT INTO colchonete_usuarios (id_pessoa,senha,login)" + 
                         "VALUES (?, ?, ?);";
            
            PreparedStatement stm = con.getConnection().prepareStatement(sql);
            
            stm.setDouble(1, usuario.getId_pessoa());
            stm.setString(2, usuario.getSenha());
            stm.setString(3, usuario.getLogin());
            stm.execute();
            
            con.getConnection().commit();
            return true;
        } catch (SQLException ex) {
            System.out.println("ERRO SALVAR PESSOA: "+ex.getMessage());
        }
        
        return false;
    }
    
    public boolean excluirUsuario(UsuarioBean usuario){
        try {
            String sql = "DELETE FROM colchonete_usuarios WHERE id_pessoa=?";
            PreparedStatement stm = con.getConnection().prepareStatement(sql);
            
            stm.setDouble(1, usuario.getId_pessoa());
            stm.execute();
            con.getConnection().commit();
            return true;
        } catch (SQLException ex) {
            System.out.println("ERRO EXCLUIR PESSOA: "+ex.getMessage());
        }
        
        return false;
    }
    
    public boolean editarUsuario(UsuarioBean usuario){
        
        try {
        
            String sql = "UPDATE colchonete_usuarios SET senha=?, login=?" + 
                         "WHERE id_pessoa=?";
            PreparedStatement stm = con.getConnection().prepareStatement(sql);
            
            stm.setString(1, usuario.getSenha());
            stm.setString(2, usuario.getLogin());
            stm.setDouble(3, usuario.getId_pessoa());
            stm.execute();
            con.getConnection().commit();
            return true;
        } catch (SQLException ex) {
            System.out.println("ERRO EDITAR PESSOA: "+ex.getMessage());
        }
        
        return false;
    }
    
    public boolean login(UsuarioBean usuario) {
        try {
        
            String sql = "SELECT login FROM colchonete_usuarios WHERE login=? AND senha=?";
            
            PreparedStatement stm = con.getConnection().prepareStatement(sql);
            
            stm.setString(1, usuario.getLogin());
            stm.setString(2, usuario.getSenha());
            
            ResultSet rs = stm.executeQuery();
            
            rs.next();
            
            if(rs.getString("login").isEmpty()){
                return false;
            }else{
                return true;
            }
            
            
        } catch (SQLException ex) {
            System.out.println("ERRO AO LOGAR: "+ex.getMessage());
        }
        return false;
    }
}
