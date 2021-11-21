package br.com.javamodas.dto.venda;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

@ApiModel("Item da venda response DTO")
public class ItemVendaResponseDTO {

    @ApiModelProperty(value = "Id")
    private Long id;

    @ApiModelProperty(value = "Quantidade")
    private Integer quantidade;

    @ApiModelProperty(value = "Preço da Venda")
    private BigDecimal precoVenda;

    @ApiModelProperty(value = "Id do produto")
    private Long idProduto;

    @ApiModelProperty(value = "Descrição do produto")
    private String produtoDescricao;

    public ItemVendaResponseDTO(Long id, Integer quantidade, BigDecimal precoVenda, Long idProduto, String produtoDescricao) {
        this.id = id;
        this.quantidade = quantidade;
        this.precoVenda = precoVenda;
        this.idProduto = idProduto;
        this.produtoDescricao = produtoDescricao;
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

    public BigDecimal getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(BigDecimal precoVenda) {
        this.precoVenda = precoVenda;
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public String getProdutoDescricao() {
        return produtoDescricao;
    }

    public void setProdutoDescricao(String produtoDescricao) {
        this.produtoDescricao = produtoDescricao;
    }
}
