package br.com.javamodas.service;

import br.com.javamodas.dto.cliente.ClienteRequestDTO;
import br.com.javamodas.dto.venda.ClienteVendaResponseDTO;
import br.com.javamodas.dto.venda.ItemVendaResponseDTO;
import br.com.javamodas.dto.venda.VendaResponseDTO;
import br.com.javamodas.exception.BusinessRuleException;
import br.com.javamodas.model.Cliente;
import br.com.javamodas.model.ItemVenda;
import br.com.javamodas.model.Venda;
import br.com.javamodas.repository.ItemVendaRepository;
import br.com.javamodas.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VendaService {

    private VendaRepository vendaRepository;
    private ClienteService clienteService;
    private ItemVendaRepository itemVendaRepository;

    @Autowired
    public VendaService(VendaRepository vendaRepository, ClienteService clienteService, ItemVendaRepository itemVendaRepository) {
        this.vendaRepository = vendaRepository;
        this.clienteService = clienteService;
        this.itemVendaRepository = itemVendaRepository;
    }

    public ClienteVendaResponseDTO listVendaByCliente(Long idCLliente){
        Cliente cliente = validClienteVendaExists(idCLliente);
        List<VendaResponseDTO> vendaResponseDTOS = vendaRepository.findByClienteId(idCLliente).stream()
                .map(venda -> createVendaResponseDTO(venda))
                .collect(Collectors.toList());
        return new ClienteVendaResponseDTO(cliente.getNome(), vendaResponseDTOS);

    }

    private Cliente validClienteVendaExists(Long idCLliente) {
        Optional<Cliente> cliente = clienteService.findById(idCLliente);
        if (cliente.isEmpty()){
            throw new BusinessRuleException(String.format("O cliente de Id %s não existe", idCLliente));
        }
        return cliente.get();
    }

    private VendaResponseDTO createVendaResponseDTO(Venda venda){
        List<ItemVendaResponseDTO> itensVendas = itemVendaRepository
                .findByVendaId(venda.getId())
                .stream().map(itemVenda -> createItemVendaResponseDTO(itemVenda))
                .collect(Collectors.toList());

        return new VendaResponseDTO(
                venda.getId(),
                venda.getData(),
                itensVendas
                );
    }

    private ItemVendaResponseDTO createItemVendaResponseDTO(ItemVenda itemVenda){

        return new ItemVendaResponseDTO(
                itemVenda.getId(),
                itemVenda.getQuantidade(),
                itemVenda.getPrecoVendido(),
                itemVenda.getProduto().getId(),
                itemVenda.getProduto().getDescricao()
        );
    }
}
