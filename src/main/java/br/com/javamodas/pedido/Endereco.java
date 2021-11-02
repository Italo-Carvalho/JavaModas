package br.com.javamodas.pedido;

public class Endereco {

    private int numero;
    private int rua;
    private String logradouro;
    private String bairro;
    private String cidade;
    private String CEP;
    private String UF;

    public Endereco(int numero, int rua, String logradouro, String bairro, String cidade, String CEP, String UF) {
        this.numero = numero;
        this.rua = rua;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cidade = cidade;
        this.CEP = CEP;
        this.UF = UF;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getRua() {
        return rua;
    }

    public void setRua(int rua) {
        this.rua = rua;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUF() {
        return UF;
    }

    public void setUF(String UF) {
        this.UF = UF;
    }
}
