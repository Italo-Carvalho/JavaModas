package br.com.javamodas.dto.produto;

import br.com.javamodas.model.Categoria;
import br.com.javamodas.model.Produto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@ApiModel("Produto Request DTO")
public class ProdutoRequestDTO {

    @NotBlank(message = "Descrição") //not black and not null
    @Length(min=3,max=100,message="Descrição")
    @ApiModelProperty(value = "Descrição")
    private String descricao;

    @NotNull(message = "Quantidade")
    @ApiModelProperty(value = "Quantidade")
    private Integer quantidade;

    @NotNull(message = "Preço custo")
    @ApiModelProperty(value = "Preço Custo")
    private BigDecimal precoCusto;

    @NotNull(message = "Preço venda")
    @ApiModelProperty(value = "Preço Venda")
    private BigDecimal precoVenda;

    @Length(max=500,message="Observação")
    @ApiModelProperty(value = "Observação")
    private String observacao;

    public Produto convert(Long categoryiId){
        return new Produto(
                descricao,
                quantidade,
                precoCusto,
                precoVenda,
                observacao,
                new Categoria(categoryiId)
        );
    }

    public Produto convert(Long categoryiId,Long productId){
        return new Produto(
                productId,
                descricao,
                quantidade,
                precoCusto,
                precoVenda,
                observacao,
                new Categoria(categoryiId)
        );
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
}