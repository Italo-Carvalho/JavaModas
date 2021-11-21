package br.com.javamodas.dto.venda;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDate;
import java.util.List;

@ApiModel("Venda response DTO")
public class VendaResponseDTO {

    @ApiModelProperty(value = "Id")
    private Long id;

    @ApiModelProperty(value = "Data")
    private LocalDate data;

    @ApiModelProperty(value = "Itens da venda")
    private List<ItemVendaResponseDTO> itensVenda;

    public VendaResponseDTO(Long id, LocalDate data, List<ItemVendaResponseDTO> itensVenda) {
        this.id = id;
        this.data = data;
        this.itensVenda = itensVenda;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public List<ItemVendaResponseDTO> getitensVenda() {
        return itensVenda;
    }

    public void setitensVenda(List<ItemVendaResponseDTO> itensVenda) {
        this.itensVenda = itensVenda;
    }
}
