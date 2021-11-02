package br.com.javamodas.pagamento;

import java.util.Date;

public abstract class Pagamento implements ProcessarPagamento{
    private int qtdProduto;
    private int bancoId;
    private Date expData;
    private String nome;

    public Date getExpData() {
        return expData;
    }

    public void setExpData(Date expData) {
        this.expData = expData;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getBancoId() {
        return bancoId;
    }

    public void setBancoId(int bancoId) {
        this.bancoId = bancoId;
    }

    public int getQtdProduto() {
        return qtdProduto;
    }

    public void setQtdProduto(int qtdProduto) {
        this.qtdProduto = qtdProduto;
    }
}
