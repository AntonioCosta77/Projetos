package br.com.colchonete.Controller;

import br.com.colchonete.Bean.PessoaBean;
import br.com.colchonete.Dao.PessoaDao;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

/**
 *
 * @author antonio
 */
@ManagedBean
@SessionScoped
public class PessoaController implements Serializable{
    private PessoaBean pessoaB;
    private DataModel listaPessoas;

    public PessoaController() {
        pessoaB = new PessoaBean();
    }

    public PessoaBean getPessoaB() {
        return pessoaB;
    }

    public void setPessoaB(PessoaBean pessoaB) {
        this.pessoaB = pessoaB;
    }

    public DataModel getListaPessoas() {
        PessoaDao pd = new PessoaDao();
        listaPessoas = new ListDataModel(pd.listarPessoas());
        return listaPessoas;
    }

    public void setListaPessoas(DataModel listaPessoas) {
        this.listaPessoas = listaPessoas;
    }
    
    public void novaPessoa(){
        pessoaB = new PessoaBean();
    }
    
    public String salvarPessoa(){
        PessoaDao pd = new PessoaDao();
        if(pd.salvarPessoa(pessoaB)){
            FacesContext contexto = FacesContext.getCurrentInstance();
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cadastro realizado com sucesso!",null) );
            return "pagina_principal";
        }else{
            return "error";
        }
    }
    
    public String editarPessoa(){
        PessoaDao pd = new PessoaDao();
        if(pd.editarPessoa(pessoaB)){
            FacesContext contexto = FacesContext.getCurrentInstance();
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cadastro editado com sucesso!",null) );
            return "pagina_principal";
        }else{
            return "error";
        }
    }
    
    public String excluirPessoa(){
        PessoaDao pd = new PessoaDao();
        if(pd.excluirPessoa(pessoaB)){
            FacesContext contexto = FacesContext.getCurrentInstance();
            contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cadastro excluido com sucesso!",null) );
            return "pagina_principal";
        }else{
            return "error";
        }
    }
    
}
