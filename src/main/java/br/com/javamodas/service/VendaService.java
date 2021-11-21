package br.com.javamodas.service;

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

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VendaService extends AbstractVendaService{

    private VendaRepository vendaRepository;
    private ClienteService clienteService;
    private ItemVendaRepository itemVendaRepository;

    @Autowired
    public VendaService(VendaRepository vendaRepository, ClienteService clienteService, ItemVendaRepository itemVendaRepository) {
        this.vendaRepository = vendaRepository;
        this.clienteService = clienteService;
        this.itemVendaRepository = itemVendaRepository;
    }

    public ClienteVendaResponseDTO listAllByClienteId(Long idCLliente){
        Cliente cliente = validClienteVendaExists(idCLliente);
        List<VendaResponseDTO> vendaResponseDTOS = vendaRepository.findByClienteId(idCLliente).stream()
                .map(venda -> createVendaResponseDTO(venda, itemVendaRepository.findByVendaId(venda.getId()))).collect(Collectors.toList());
        return new ClienteVendaResponseDTO(cliente.getNome(), vendaResponseDTOS);

    }

    public ClienteVendaResponseDTO listAllById(Long id){
        Venda venda = validVendaExists(id);
        return new ClienteVendaResponseDTO(venda.getCliente().getNome(),
                Arrays.asList(createVendaResponseDTO(venda, itemVendaRepository.findByVendaId(venda.getId()))));
    }

    private Venda validVendaExists(Long id){
        Optional<Venda> venda = vendaRepository.findById(id);
        if (venda.isEmpty()){
            throw new BusinessRuleException(String.format("O venda de Id %s não existe", id));
        }
        return venda.get();
    }

    private Cliente validClienteVendaExists(Long idCLliente) {
        Optional<Cliente> cliente = clienteService.findById(idCLliente);
        if (cliente.isEmpty()){
            throw new BusinessRuleException(String.format("O cliente de Id %s não existe", idCLliente));
        }
        return cliente.get();
    }


    }
