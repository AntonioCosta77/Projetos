package br.com.colchonete.Controller;

import br.com.colchonete.Bean.EnderecoBean;
import br.com.colchonete.Bean.PessoaBean;
import br.com.colchonete.Bean.UsuarioBean;
import br.com.colchonete.Dao.EnderecoDao;
import br.com.colchonete.Dao.PessoaDao;
import br.com.colchonete.Dao.UsuarioDao;
import java.io.Serializable;
import java.util.Random;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;

/**
 *
 * @author antonio
 */

@ManagedBean
@SessionScoped
public class genericController implements Serializable{
    private PessoaBean pessoa;
    private EnderecoBean endereco;
    private UsuarioBean usuario;
    private DataModel lista;

    public genericController() {
        pessoa = new PessoaBean();
        endereco = new EnderecoBean();
        usuario = new UsuarioBean();
    }

    public PessoaBean getPessoa() {
        return pessoa;
    }

    public void setPessoa(PessoaBean pessoa) {
        this.pessoa = pessoa;
    }

    public EnderecoBean getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoBean endereco) {
        this.endereco = endereco;
    }

    public UsuarioBean getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioBean usuario) {
        this.usuario = usuario;
    }

    public DataModel getLista() {
        return lista;
    }

    public void setLista(DataModel lista) {
        this.lista = lista;
    }
    
    public void novo(){
        pessoa = new PessoaBean();
        endereco = new EnderecoBean();
        usuario = new UsuarioBean();
    }
    
    public String salvar(){
        double id = new Random().nextDouble();
        pessoa.setId_pessoa(2015+id);
        endereco.setId_pessoa(pessoa.getId_pessoa());
        usuario.setId_pessoa(pessoa.getId_pessoa());
        
        PessoaDao pd = new PessoaDao();
        EnderecoDao ed = new EnderecoDao();
        UsuarioDao ud = new UsuarioDao();
        
        FacesContext contexto = FacesContext.getCurrentInstance();
        
        if(ud.salvarUsuario(usuario)){
            if(pd.salvarPessoa(pessoa)){
                if(ed.salvarEndereco(endereco)){
                    contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cadastro realizado com sucesso!",null) );
                    return "pagina_principal";
                }else{
                    contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Não foi possivel cadastrar seu endereco!",null) );
                    return "error";  
                }
            }else{
                contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Não foi possivel cadastrar seus dados!",null) );
                return "error";  
            }
        }else{
            return "";
        }
    }
    
    public String editar(){
        PessoaDao pd = new PessoaDao();
        EnderecoDao ed = new EnderecoDao();
        UsuarioDao ud = new UsuarioDao();
        
        FacesContext contexto = FacesContext.getCurrentInstance();
        
        if(pd.editarPessoa(pessoa)){
            if(ed.editarEndereco(endereco)){
                contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cadastro editado com sucesso!",null) );
                return "pagina_principal";
            }else{
                contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Não foi possivel editar o endereco!",null) );
                return "error";  
            }
        }else{
            return "error";
        }
    }
    
    public String excluir(){
        PessoaDao pd = new PessoaDao();
        EnderecoDao ed = new EnderecoDao();
        UsuarioDao ud = new UsuarioDao();
        
        FacesContext contexto = FacesContext.getCurrentInstance();
        if(pd.excluirPessoa(pessoa)){
            if(ed.excluirEndereco(endereco)){
                contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cadastro excluido com sucesso!",null) );
                return "pagina_principal";
            }else{
                contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Não foi possivel excluir o endereco!",null) );
                return "error";  
            }
        }else{
            return "error";
        }
    }
}
