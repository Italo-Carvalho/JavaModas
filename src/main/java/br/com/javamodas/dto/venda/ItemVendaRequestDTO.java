package br.com.javamodas.dto.venda;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@ApiModel("Itens da Venda request DTO")
public class ItemVendaRequestDTO {

    @ApiModelProperty(value = "Quantidade")
    @NotNull(message = "Quantidade")
    private Integer quantidade;

    @ApiModelProperty(value = "Preço da Venda")
    @Min(value = 1, message = "Preço Vendido")
    private BigDecimal precoVenda;

    @ApiModelProperty(value = "Id do produto")
    @NotNull(message = "ID Produto")
    private Long idProduto;


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

}
