package br.com.javamodas.model;


import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.Properties;

@Entity
@Table(name = "item_venda")
public class ItemVenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="quantidade")
    private Integer quantidade;

    @Column(name = "preco_vendido")
    private BigDecimal precoVendido;

    @ManyToOne
    @JoinColumn(name = "id_produto", referencedColumnName = "id")
    private Produto produto;

    @ManyToOne
    @JoinColumn(name = "id_venda", referencedColumnName = "id")
    private Venda venda;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ItemVenda)) return false;
        ItemVenda itemVenda = (ItemVenda) o;
        return Objects.equals(id, itemVenda.id) && Objects.equals(quantidade, itemVenda.quantidade) && Objects.equals(precoVendido, itemVenda.precoVendido) && Objects.equals(produto, itemVenda.produto) && Objects.equals(venda, itemVenda.venda);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, quantidade, precoVendido, produto, venda);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getPrecoVendido() {
        return precoVendido;
    }

    public void setPrecoVendido(BigDecimal precoVendido) {
        this.precoVendido = precoVendido;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }
}
