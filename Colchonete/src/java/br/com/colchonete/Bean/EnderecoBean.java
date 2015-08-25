package br.com.colchonete.Bean;

/**
 *
 * @author antonio
 */
public class EnderecoBean {
    private int id_endereco;
    private int id_pessoa;
    private int estado;
    private String cidade;
    private String bairro;
    private String rua;
    private String cep;
    private String complemento;

    public EnderecoBean() {
    }

    public EnderecoBean(int id_endereco, int id_pessoa, int estado, String cidade, String bairro, String rua, String cep, String complemento) {
        this.id_endereco = id_endereco;
        this.id_pessoa = id_pessoa;
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.cep = cep;
        this.complemento = complemento;
    }

    public int getId_endereco() {
        return id_endereco;
    }

    public void setId_endereco(int id_endereco) {
        this.id_endereco = id_endereco;
    }

    public int getId_pessoa() {
        return id_pessoa;
    }

    public void setId_pessoa(int id_pessoa) {
        this.id_pessoa = id_pessoa;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
    
}