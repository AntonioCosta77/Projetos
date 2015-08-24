package br.com.colchonete.Bean;

import java.util.Date;

/**
 *
 * @author antonio
 */
public class PessoaBean {
    private int id_pessoa;
    private String nome;
    private String nick_name;
    private Date dt_nascimento;
    private int rg;
    private int cpf;
    private String telefone;
    private String email;

    public PessoaBean() {
    }

    public PessoaBean(int id_pessoa, String nome, String nick_name, Date dt_nascimento, int rg, int cpf, String telefone, String email) {
        this.id_pessoa = id_pessoa;
        this.nome = nome;
        this.nick_name = nick_name;
        this.dt_nascimento = dt_nascimento;
        this.rg = rg;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
    }

    public int getId_pessoa() {
        return id_pessoa;
    }

    public void setId_pessoa(int id_pessoa) {
        this.id_pessoa = id_pessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNick_name() {
        return nick_name;
    }

    public void setNick_name(String nick_name) {
        this.nick_name = nick_name;
    }

    public Date getDt_nascimento() {
        return dt_nascimento;
    }

    public void setDt_nascimento(Date dt_nascimento) {
        this.dt_nascimento = dt_nascimento;
    }

    public int getRg() {
        return rg;
    }

    public void setRg(int rg) {
        this.rg = rg;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
}
