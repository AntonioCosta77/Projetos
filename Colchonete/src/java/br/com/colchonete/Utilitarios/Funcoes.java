package br.com.colchonete.Utilitarios;

/**
 *
 * @author antonio
 */
public class Funcoes {
    
    public String exibirError(String sql){
        String prefixo = "-----BEGUIN-----\n";
        String sufixo = "\n-----BEGUIN-----\n";
        
        return prefixo+sql+sufixo;
    }
    
}
