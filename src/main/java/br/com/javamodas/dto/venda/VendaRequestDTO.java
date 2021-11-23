package br.com.javamodas.dto.venda;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@ApiModel("Venda request DTO")
public class VendaRequestDTO {

    @ApiModelProperty(value = "Data")
    @NotNull(message = "Data")
    private LocalDate data;

    @ApiModelProperty(value = "Itens da venda")
    @NotNull(message = "Itens da venda")
    @Valid
    private List<ItemVendaRequestDTO> itensvenda;

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public List<ItemVendaRequestDTO> getItensvenda() {
        return itensvenda;
    }

    public void setItensvenda(List<ItemVendaRequestDTO> itensvenda) {
        this.itensvenda = itensvenda;
    }
}
