package br.com.colchonete.Controller;

import br.com.colchonete.Bean.UsuarioBean;
import javax.faces.model.DataModel;

/**
 *
 * @author antonio
 */
public class UsuarioController {
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
    
}
