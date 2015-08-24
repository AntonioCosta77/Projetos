package br.com.colchonete.Utilitarios;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author antonio
 */
public class Teste {
    public static void main(String[] args){
        try {
            Conexao con = new Conexao();
            PreparedStatement stm = con.getConnection().prepareStatement("select * from colchonete_pessoas");
            ResultSet rs = stm.executeQuery();
            rs.next();
            System.out.println(rs.getString("nick_name"));
        } catch (SQLException ex) {
            Logger.getLogger(Teste.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
