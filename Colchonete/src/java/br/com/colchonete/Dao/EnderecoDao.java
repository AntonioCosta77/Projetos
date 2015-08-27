package br.com.colchonete.Dao;

import br.com.colchonete.Bean.EnderecoBean;
import br.com.colchonete.Utilitarios.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author antonio
 */
public class EnderecoDao {
    private Conexao con;
    
    public EnderecoDao() {
    }
    
    public  boolean salvarEndereco(EnderecoBean endereco){
        
        try {
            
            String sql = "INSERT INTO colchonete_enderecos (id_pessoa, estado, cidade, bairro, rua, cep,complemento)" + 
                         "VALUES (?, ?, ?, ?, ?, ?, ?);";
            
            PreparedStatement stm = con.getConnection().prepareStatement(sql);
            //O erro está na linha acima
            System.out.println("--------FOI-------");
            System.exit(0);
            
            stm.setDouble(1, endereco.getId_pessoa());
            stm.setInt(2, endereco.getEstado());
            stm.setString(3, endereco.getCidade());
            stm.setString(4, endereco.getBairro());
            stm.setString(5, endereco.getRua());
            stm.setString(6, endereco.getCep());
            stm.setString(7, endereco.getComplemento());
            stm.execute();
            
            con.getConnection().commit();
            return true;
        } catch (SQLException ex) {
            System.out.println("ERRO SALVAR ENDERECO: "+ex);
        }
        
        return false;
    }
    
    public boolean excluirEndereco(EnderecoBean endereco){
        try {
            String sql = "DELETE FROM colchonete_enderecos WHERE id_endereco=?";
            PreparedStatement stm = con.getConnection().prepareStatement(sql);
            
            stm.setInt(1, endereco.getId_endereco());
            stm.execute();
            con.getConnection().commit();
            return true;
        } catch (SQLException ex) {
            System.out.println("ERRO EXCLUIR ENDERECO: "+ex);
        }
        
        return false;
    }
    
    public boolean editarEndereco(EnderecoBean endereco){
        
        try {
        
            String sql = "UPDATE colchonete_enderecos SET estado=?, cidade=?, bairro=?, rua=?, cep=?, complemento=?" + 
                         "WHERE id_endereco=?";
            
            PreparedStatement stm = con.getConnection().prepareStatement(sql);
            
            stm.setInt(1, endereco.getEstado());
            stm.setString(2, endereco.getCidade());
            stm.setString(3, endereco.getBairro());
            stm.setString(4, endereco.getRua());
            stm.setString(5, endereco.getCep());
            stm.setString(6, endereco.getComplemento());
            stm.setInt(5, endereco.getId_endereco());
            stm.execute();
            con.getConnection().commit();
            return true;
        } catch (SQLException ex) {
            System.out.println("ERRO EDITAR ENDERECO: "+ex);
        }
        
        return false;
    }
    
    public List<EnderecoBean> listarEndereco(){
        List<EnderecoBean> lista = new ArrayList<EnderecoBean>();
        try {
            String sql = "SELECT * FROM colchonete_enderecos";
            PreparedStatement stm = con.getConnection().prepareStatement(sql);
            
            ResultSet rs = stm.executeQuery();
            
            while(rs.next()){
                EnderecoBean endereco = new EnderecoBean();
                endereco.setId_endereco(rs.getInt("id_endereco"));
                endereco.setId_pessoa(rs.getInt("id_pessoa"));
                endereco.setEstado(rs.getInt("estado"));
                endereco.setCidade(rs.getString("cidade"));
                endereco.setBairro(rs.getString("bairro"));
                endereco.setRua(rs.getString("rua"));
                endereco.setCep(rs.getString("cep"));
                endereco.setComplemento(rs.getString("complemento"));
                lista.add(endereco);
            }
            
        } catch (SQLException ex) {
            System.out.println("ERRO LISTAR ENDERECO: "+ex);
        }
        
        return lista;
    }
}
