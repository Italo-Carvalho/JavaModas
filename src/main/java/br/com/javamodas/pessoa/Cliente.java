package br.com.javamodas.pessoa;

import java.math.BigDecimal;

public class Cliente extends Pessoa{
    private String endereco;
    private String infoCartao;
    private String inforCartaoCred;
    private String infoEnvio;
    private BigDecimal saldoConta;

    public void cadastrar(){}
    public void atualizaPerfil(){}
    public void login(){}

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getInfoCartao() {
        return infoCartao;
    }

    public void setInfoCartao(String infoCartao) {
        this.infoCartao = infoCartao;
    }

    public String getInforCartaoCred() {
        return inforCartaoCred;
    }

    public void setInforCartaoCred(String inforCartaoCred) {
        this.inforCartaoCred = inforCartaoCred;
    }

    public String getInfoEnvio() {
        return infoEnvio;
    }

    public void setInfoEnvio(String infoEnvio) {
        this.infoEnvio = infoEnvio;
    }

    public BigDecimal getSaldoConta() {
        return saldoConta;
    }

    public void setSaldoConta(BigDecimal saldoConta) {
        this.saldoConta = saldoConta;
    }
}
