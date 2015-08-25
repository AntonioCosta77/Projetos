package br.com.colchonete.Controller;

import br.com.colchonete.Bean.EnderecoBean;
import br.com.colchonete.Dao.EnderecoDao;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

/**
 *
 * @author antonio
 */
@ManagedBean
@SessionScoped
public class EnderecoController implements Serializable{
    private EnderecoBean enderecoB;
    private DataModel listaEnderecos;

    public EnderecoController() {
        enderecoB = new EnderecoBean();
    }

    public EnderecoBean getEnderecoB() {
        return enderecoB;
    }

    public void setEnderecoB(EnderecoBean enderecoB) {
        this.enderecoB = enderecoB;
    }

    public DataModel getListaEnderecos() {
        EnderecoDao ed = new EnderecoDao();
        listaEnderecos = new ListDataModel(ed.listarEndereco());
        return listaEnderecos;
    }

    public void setListaEnderecos(DataModel listaEnderecos) {
        this.listaEnderecos = listaEnderecos;
    }
    
    public void novoEndereco(){
        enderecoB = new EnderecoBean();
    }
    
    public String salvarEndereco(){
        EnderecoDao ed = new EnderecoDao();
        if(ed.salvarEndereco(enderecoB)){
            return "pagina_principal";
        }else{
            return "error";
        }
    }
    
    public String editarPessoa(){
        EnderecoDao ed = new EnderecoDao();
        if(ed.editarEndereco(enderecoB)){
            return "pagina_principal";
        }else{
            return "error";
        }
    }
    
    public String excluirPessoa(){
        EnderecoDao ed = new EnderecoDao();
        if(ed.excluirEndereco(enderecoB)){
            return "pagina_principal";
        }else{
            return "error";
        }
    }
}