package br.com.colchonete.Controller;

import br.com.colchonete.Bean.UsuarioBean;
import br.com.colchonete.Dao.UsuarioDao;
import java.io.Serializable;
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
public class UsuarioController implements Serializable{
    private UsuarioBean usuarioB;
    private DataModel listaUsuarios;

    public UsuarioController() {
        usuarioB = new UsuarioBean();
    }

    public UsuarioBean getUsuarioB() {
        return usuarioB;
    }

    public void setUsuarioB(UsuarioBean usuarioB) {
        this.usuarioB = usuarioB;
    }

    public DataModel getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(DataModel listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }
    
    public void novoUsuario(){
        usuarioB = new UsuarioBean();
    }
    
    public String logar(){
        FacesContext contexto = FacesContext.getCurrentInstance();
        UsuarioDao ud = new UsuarioDao();
        
        if(ud.login(usuarioB)){
            return "view_usuario/pagina_principal";
        }
        
        contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Não conseguimos achar seus dados!",null) );
        return "";
    }
}
