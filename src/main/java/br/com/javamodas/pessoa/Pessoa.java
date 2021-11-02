package br.com.javamodas.pessoa;

import java.util.Date;

public abstract class Pessoa {
    private String nome;
    private String senha;
    private String estadoLogin;
    private String email;
    private Date dataCadatro;

    public void verificarLogin() {}
    public void alterarCadastro(){}
    public void excluirCadastr(){}
    public void buscaProduto(){}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEstadoLogin() {
        return estadoLogin;
    }

    public void setEstadoLogin(String estadoLogin) {
        this.estadoLogin = estadoLogin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDataCadatro() {
        return dataCadatro;
    }

    public void setDataCadatro(Date dataCadatro) {
        this.dataCadatro = dataCadatro;
    }
}
