package br.com.javamodas.pedido;

import br.com.javamodas.loja.CarrinhoDeCompras;

import java.util.Date;

public class Pedido {
    private int numPedido;
    private Date dataCriacao;
    private CarrinhoDeCompras carrinhoDeCompras;
    private String endereco;
    private int numEnvio;



    public Pedido(int numPedido, Date dataCriacao, CarrinhoDeCompras carrinhoDeCompras, String endereco, int numEnvio) {
        this.numPedido = numPedido;
        this.dataCriacao = dataCriacao;
        this.carrinhoDeCompras = carrinhoDeCompras;
        this.endereco = endereco;
        this.numEnvio = numEnvio;
    }

    private void finalizarPedido(){}

    public int getNumPedido() {
        return numPedido;
    }

    public void setNumPedido(int numPedido) {
        this.numPedido = numPedido;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public CarrinhoDeCompras getCarrinhoDeCompras() {
        return carrinhoDeCompras;
    }

    public void setCarrinhoDeCompras(CarrinhoDeCompras carrinhoDeCompras) {
        this.carrinhoDeCompras = carrinhoDeCompras;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getNumEnvio() {
        return numEnvio;
    }

    public void setNumEnvio(int numEnvio) {
        this.numEnvio = numEnvio;
    }
}
