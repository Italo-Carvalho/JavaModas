package br.com.javamodas.loja;
import br.com.javamodas.pessoa.Gerente;
import java.math.BigDecimal;
import java.util.Date;

public class Produto {
    private Gerente gerente;
    private String nome;
    private BigDecimal preco;
    private int numProduto;
    private int qtd;
    private String tipo;
    private Date dataAdd;

    public Produto(Gerente gerente ,String nome, BigDecimal preco, int numProduto, int qtd, String tipo) {
        this.gerente = gerente;
        this.nome = nome;
        this.preco = preco;
        this.numProduto = numProduto;
        this.qtd = qtd;
        this.tipo = tipo;
        this.dataAdd = new Date(System.currentTimeMillis());
    }

    public void limparEstoque(){
        setQtd(0);
    }
    public void reporProduto(int qtd){
        setQtd(qtd);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Gerente getGerente() {
        return gerente;
    }

    public void setGerente(Gerente gerente) {
        this.gerente = gerente;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public int getNumProduto() {
        return numProduto;
    }

    public void setNumProduto(int numProduto) {
        this.numProduto = numProduto;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getDataAdd() {
        return dataAdd;
    }

    public void setDataAdd(Date dataAdd) {
        this.dataAdd = dataAdd;
    }
}
