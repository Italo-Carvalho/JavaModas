package br.com.javamodas.dto.venda;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel("Cliente da venda response DTO")
public class ClienteVendaResponseDTO {

    @ApiModelProperty(value = "Nome cliente")
    private String nome;

    @ApiModelProperty(value = "Vendas")
    private List<VendaResponseDTO> venda;

    public ClienteVendaResponseDTO(String nome, List<VendaResponseDTO> venda) {
        this.nome = nome;
        this.venda = venda;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<VendaResponseDTO> getvenda() {
        return venda;
    }

    public void setvenda(List<VendaResponseDTO> venda) {
        this.venda = venda;
    }
}
