package br.com.javamodas.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name= "produto")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="descricao")
    private String descricao;


    @Column(name="quantidade")
    private Integer quantidade;

    @Column(name="preco_curto")
    private BigDecimal precoCusto;

    @Column(name="preco_venda")
    private BigDecimal precoVenda;

    @Column(name="observacao")
    private String observacao;

    @ManyToOne
    @JoinColumn(name="id_categoria", referencedColumnName = "id")
    private Categoria categoria;

    public Produto(){}

    public Produto(String descricao, Integer quantidade, BigDecimal precoCusto, BigDecimal precoVenda, String observacao, Categoria categoria) {
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.precoCusto = precoCusto;
        this.precoVenda = precoVenda;
        this.observacao = observacao;
        this.categoria = categoria;
    }

    public Produto(Long id,String descricao, Integer quantidade, BigDecimal precoCusto, BigDecimal precoVenda, String observacao, Categoria categoria) {
        this.id = id;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.precoCusto = precoCusto;
        this.precoVenda = precoVenda;
        this.observacao = observacao;
        this.categoria = categoria;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(BigDecimal precoCusto) {
        this.precoCusto = precoCusto;
    }

    public BigDecimal getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(BigDecimal precoVenda) {
        this.precoVenda = precoVenda;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Produto)) return false;
        Produto produto = (Produto) o;
        return Objects.equals(getId(), produto.getId()) && Objects.equals(getDescricao(), produto.getDescricao()) && Objects.equals(getQuantidade(), produto.getQuantidade()) && Objects.equals(getPrecoCusto(), produto.getPrecoCusto()) && Objects.equals(getPrecoVenda(), produto.getPrecoVenda()) && Objects.equals(getObservacao(), produto.getObservacao()) && Objects.equals(getCategoria(), produto.getCategoria());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDescricao(), getQuantidade(), getPrecoCusto(), getPrecoVenda(), getObservacao(), getCategoria());
    }
}