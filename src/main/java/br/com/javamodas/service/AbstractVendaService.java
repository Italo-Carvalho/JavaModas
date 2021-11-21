package br.com.javamodas.service;

import br.com.javamodas.dto.venda.ItemVendaResponseDTO;
import br.com.javamodas.dto.venda.VendaResponseDTO;
import br.com.javamodas.model.ItemVenda;
import br.com.javamodas.model.Venda;

import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractVendaService {


    protected VendaResponseDTO createVendaResponseDTO(Venda venda, List<ItemVenda> itemVendas) {
        List<ItemVendaResponseDTO> itensVendas = itemVendas.stream()
                .map(itemVenda -> createItemVendaResponseDTO(itemVenda))
                .collect(Collectors.toList());

        return new VendaResponseDTO(
                venda.getId(),
                venda.getData(),
                itensVendas
        );
    }

    protected ItemVendaResponseDTO createItemVendaResponseDTO(ItemVenda itemVenda) {

        return new ItemVendaResponseDTO(
                itemVenda.getId(),
                itemVenda.getQuantidade(),
                itemVenda.getPrecoVendido(),
                itemVenda.getProduto().getId(),
                itemVenda.getProduto().getDescricao()
        );
    }
}










