package br.com.javamodas.dto.produto;

import br.com.javamodas.dto.categoria.CategoriaResponseDTO;
import br.com.javamodas.model.Produto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

@ApiModel("Produto Response DTO")
public class ProdutoResponseDTO {

    @ApiModelProperty(value = "Id")
    private Long id;

    @ApiModelProperty(value = "Descrição")
    private String descricao;

    @ApiModelProperty(value = "Quantidade")
    private Integer quantidade;

    @ApiModelProperty(value = "Preço Custo")
    private BigDecimal precoCusto;

    @ApiModelProperty(value = "Preço Venda")
    private BigDecimal precoVenda;

    @ApiModelProperty(value = "Observação")
    private String observacao;

    @ApiModelProperty(value = "Categoria")
    private CategoriaResponseDTO categoria;

    public ProdutoResponseDTO(Long id, String descricao, Integer quantidade, BigDecimal precoCusto, BigDecimal precoVenda, String observacao, CategoriaResponseDTO categoria) {
        this.id = id;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.precoCusto = precoCusto;
        this.precoVenda = precoVenda;
        this.observacao = observacao;
        this.categoria = categoria;
    }

    public static ProdutoResponseDTO convert(Produto produto) {
        return new ProdutoResponseDTO(
                produto.getId(),
                produto.getDescricao(),
                produto.getQuantidade(),
                produto.getPrecoCusto(),
                produto.getPrecoVenda(),
                produto.getObservacao(),
                CategoriaResponseDTO.convert(produto.getCategoria()));
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

    public CategoriaResponseDTO getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaResponseDTO categoria) {
        this.categoria = categoria;
    }
}
