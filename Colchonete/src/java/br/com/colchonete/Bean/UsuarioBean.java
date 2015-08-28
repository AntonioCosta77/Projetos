package br.com.colchonete.Bean;

/**
 *
 * @author antonio
 */
public class UsuarioBean {
    private int id_usuario;
    private double id_pessoa;
    private String senha;
    private String login;

    public UsuarioBean() {
    }

    public UsuarioBean(int id_usuario, double id_pessoa, String senha, String login) {
        this.id_usuario = id_usuario;
        this.id_pessoa = id_pessoa;
        this.senha = senha;
        this.login = login;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public double getId_pessoa() {
        return id_pessoa;
    }

    public void setId_pessoa(double id_pessoa) {
        this.id_pessoa = id_pessoa;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
    
    
}