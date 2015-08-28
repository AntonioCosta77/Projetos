package br.com.colchonete.Dao;

import br.com.colchonete.Bean.UsuarioBean;
import br.com.colchonete.Utilitarios.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

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
            SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
            
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
    
    public List<UsuarioBean> listarUsuarios(){
        List<UsuarioBean> lista = new ArrayList<UsuarioBean>();
        try {
            String sql = "SELECT * FROM colchonete_usuarios";
            PreparedStatement stm = con.getConnection().prepareStatement(sql);
            
            ResultSet rs = stm.executeQuery();
            
            while(rs.next()){
                UsuarioBean usuario = new UsuarioBean();
                usuario.setId_usuario(rs.getInt("id_usuario"));
                usuario.setId_pessoa(rs.getInt("id_pessoa"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setLogin(rs.getString("login"));
                lista.add(usuario);
            }
            
        } catch (SQLException ex) {
            System.out.println("ERRO LISTAR PESSOA: "+ex.getMessage());
        }
        
        return lista;
    }
}
