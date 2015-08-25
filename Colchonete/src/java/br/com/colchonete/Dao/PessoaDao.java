package br.com.colchonete.Dao;

import br.com.colchonete.Bean.PessoaBean;
import br.com.colchonete.Utilitarios.Conexao;
import java.sql.Date;
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
public class PessoaDao {
    private Conexao con;

    public PessoaDao() {
        con = new Conexao();
    }
    
    public  boolean salvarPessoa(PessoaBean pessoa){
        try {
            String sql = "INSERT INTO colchonete_pessoas (nome, nick_name, dt_nascimento, rg, cpf, telefone, email)" + 
                         "VALUES (?, ?, ?, ?, ?, ?, ?);";
            System.out.println(pessoa.getDt_nascimento()+"<-AQUI");
            PreparedStatement stm = con.getConnection().prepareStatement(sql);
            
            stm.setString(1, pessoa.getNome());
            stm.setString(2, pessoa.getNick_name());
            stm.setDate(3, (Date) pessoa.getDt_nascimento());
            stm.setInt(4, pessoa.getRg());
            stm.setInt(5, pessoa.getCpf());
            stm.setString(6, pessoa.getTelefone());
            stm.setString(7, pessoa.getEmail());
            stm.execute();
            con.getConnection().commit();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    public boolean excluirPessoa(PessoaBean pessoa){
        try {
            String sql = "DELETE FROM colchonete_pessoas WHERE id_pessoa=?";
            PreparedStatement stm = con.getConnection().prepareStatement(sql);
            
            stm.setInt(1, pessoa.getId_pessoa());
            stm.execute();
            con.getConnection().commit();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    public boolean editarPessoa(PessoaBean pessoa){
        try {
            String sql = "UPDATE colchonete_pessoas SET nome=?, nick_name=?, dt_nascimento=?, rg=?, cpf=?, telefone=?, email=?" + 
                         "WHERE id_pessoa=?";
            PreparedStatement stm = con.getConnection().prepareStatement(sql);
            
            stm.setString(1, pessoa.getNome());
            stm.setString(2, pessoa.getNick_name());
            stm.setDate(3, (Date) pessoa.getDt_nascimento());
            stm.setInt(4, pessoa.getRg());
            stm.setInt(5, pessoa.getCpf());
            stm.setString(6, pessoa.getTelefone());
            stm.setString(7, pessoa.getEmail());
            stm.setInt(8, pessoa.getId_pessoa());
            stm.execute();
            con.getConnection().commit();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    public List<PessoaBean> listarPessoas(){
        List<PessoaBean> lista = new ArrayList<PessoaBean>();
        try {
            String sql = "SELECT * FROM colchonete_pessoas";
            PreparedStatement stm = con.getConnection().prepareStatement(sql);
            
            ResultSet rs = stm.executeQuery();
            
            while(rs.next()){
                PessoaBean pessoa = new PessoaBean();
                pessoa.setId_pessoa(rs.getInt("id_pessoa"));
                pessoa.setNome(rs.getString("nome"));
                pessoa.setNick_name(rs.getString("nick_name"));
                pessoa.setDt_nascimento(rs.getDate("dt_nascimento"));
                pessoa.setRg(rs.getInt("rg"));
                pessoa.setCpf(rs.getInt("cpf"));
                pessoa.setTelefone(rs.getString("telefone"));
                pessoa.setEmail(rs.getString("email"));
                lista.add(pessoa);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lista;
    }
    
}
