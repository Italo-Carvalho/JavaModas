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
    private List<ItemVendaResponseDTO> itemVendaResponseDTOS;

    public VendaResponseDTO(Long id, LocalDate data, List<ItemVendaResponseDTO> itemVendaResponseDTOS) {
        this.id = id;
        this.data = data;
        this.itemVendaResponseDTOS = itemVendaResponseDTOS;
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

    public List<ItemVendaResponseDTO> getItemVendaResponseDTOS() {
        return itemVendaResponseDTOS;
    }

    public void setItemVendaResponseDTOS(List<ItemVendaResponseDTO> itemVendaResponseDTOS) {
        this.itemVendaResponseDTOS = itemVendaResponseDTOS;
    }
}
