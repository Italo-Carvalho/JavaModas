package br.com.javamodas.pedido;

import java.math.BigDecimal;

public class Envio {
    private Endereco endereco;
    private int numEnvio;
    private String tipoEnvio;
    private BigDecimal precoEnvio;
    private BigDecimal custoEnvio;

    public Envio(Endereco endereco, int numEnvio, String tipoEnvio, BigDecimal precoEnvio, BigDecimal custoEnvio) {
        this.endereco = endereco;
        this.numEnvio = numEnvio;
        this.tipoEnvio = tipoEnvio;
        this.precoEnvio = precoEnvio;
        this.custoEnvio = custoEnvio;
    }

    public void atualizarEndereco(){}

    public void atualizarPreco(BigDecimal precoEnvio, BigDecimal custoEnvio){
        setPrecoEnvio(precoEnvio);
        setCustoEnvio(custoEnvio);
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public int getNumEnvio() {
        return numEnvio;
    }

    public void setNumEnvio(int numEnvio) {
        this.numEnvio = numEnvio;
    }

    public String getTipoEnvio() {
        return tipoEnvio;
    }

    public void setTipoEnvio(String tipoEnvio) {
        this.tipoEnvio = tipoEnvio;
    }

    public BigDecimal getPrecoEnvio() {
        return precoEnvio;
    }

    public void setPrecoEnvio(BigDecimal precoEnvio) {
        this.precoEnvio = precoEnvio;
    }

    public BigDecimal getCustoEnvio() {
        return custoEnvio;
    }

    public void setCustoEnvio(BigDecimal custoEnvio) {
        this.custoEnvio = custoEnvio;
    }
}























