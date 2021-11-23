package br.com.javamodas.service;

import br.com.javamodas.dto.venda.ClienteVendaResponseDTO;
import br.com.javamodas.dto.venda.ItemVendaRequestDTO;
import br.com.javamodas.dto.venda.VendaRequestDTO;
import br.com.javamodas.dto.venda.VendaResponseDTO;
import br.com.javamodas.exception.BusinessRuleException;
import br.com.javamodas.model.Cliente;
import br.com.javamodas.model.Produto;
import br.com.javamodas.model.Venda;
import br.com.javamodas.repository.ItemVendaRepository;
import br.com.javamodas.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VendaService extends AbstractVendaService {

    private VendaRepository vendaRepository;
    private ClienteService clienteService;
    private ItemVendaRepository itemVendaRepository;
    private ProdutoService produtoService;

    @Autowired
    public VendaService(VendaRepository vendaRepository, ClienteService clienteService, ItemVendaRepository itemVendaRepository, ProdutoService produtoService) {
        this.vendaRepository = vendaRepository;
        this.clienteService = clienteService;
        this.itemVendaRepository = itemVendaRepository;
        this.produtoService = produtoService;
    }

    public ClienteVendaResponseDTO listAllByClienteId(Long idCliente) {
        Cliente cliente = validClienteVendaExists(idCliente);
        List<VendaResponseDTO> vendaResponseDTOS = vendaRepository.findByClienteId(idCliente).stream()
                .map(venda -> createVendaResponseDTO(venda, itemVendaRepository.findByVendaId(venda.getId()))).collect(Collectors.toList());
        return new ClienteVendaResponseDTO(cliente.getNome(), vendaResponseDTOS);

    }

    public ClienteVendaResponseDTO listAllById(Long id) {
        Venda venda = validVendaExists(id);
        return returnClienteVendaResponseDTO(venda, itemVendaRepository.findByVendaId(venda.getId()));

    }


    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class) // caso aconteça um erro fara rollback dos produtos alterados antes da exeption
    public ClienteVendaResponseDTO save(Long idCliente, VendaRequestDTO vendaRequestDTO) {
        Cliente cliente = validClienteVendaExists(idCliente);
        produtoPosVendaValidationSave(vendaRequestDTO.getItensvenda());
        Venda vendaSave = saveVenda(cliente, vendaRequestDTO);
        return returnClienteVendaResponseDTO(vendaSave, itemVendaRepository.findByVendaId(vendaSave.getId()));
    }


    private Venda saveVenda(Cliente cliente, VendaRequestDTO vendaRequestDTO) {
        Venda vendaSave = vendaRepository.save(new Venda(vendaRequestDTO.getData(), cliente));
        vendaRequestDTO.getItensvenda().stream()
                .map(itemVendaRequestDTO -> createItemVenda(itemVendaRequestDTO, vendaSave))
                .forEach(itemVenda -> itemVendaRepository.save(itemVenda));
        return vendaSave;

    }

    private void produtoPosVendaValidationSave(List<ItemVendaRequestDTO> itensvenda) {
        itensvenda.forEach(item -> {
            Produto produto = produtoService.validateProductExists(item.getIdProduto());
            validQuantidadeProdutoExists(produto, item.getQuantidade());
            produto.setQuantidade(produto.getQuantidade() - item.getQuantidade());
            produtoService.updateQuantidadePosVenda(produto);
        });
    }

    private void validQuantidadeProdutoExists(Produto produto, Integer quantidadeProduto){
        if (produto.getQuantidade() < quantidadeProduto){
            throw new BusinessRuleException(
                    String.format("A quantidade %s é maior que a disponível em estoque, Estoque atual %s",
                    quantidadeProduto, produto.getQuantidade()));
        }
    }

    private Venda validVendaExists(Long id) {
        Optional<Venda> venda = vendaRepository.findById(id);
        if (venda.isEmpty()) {
            throw new BusinessRuleException(String.format("O venda de Id %s não existe", id));
        }
        return venda.get();
    }

    private Cliente validClienteVendaExists(Long idCLliente) {
        Optional<Cliente> cliente = clienteService.findById(idCLliente);
        if (cliente.isEmpty()) {
            throw new BusinessRuleException(String.format("O cliente de Id %s não existe", idCLliente));
        }
        return cliente.get();
    }


}
