package br.com.javamodas.service;

import br.com.javamodas.exception.BusinessRuleException;
import br.com.javamodas.model.Cliente;
import br.com.javamodas.repository.ClienteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> listAll(){
        return clienteRepository.findAll();
    }

    public Optional<Cliente> findById(long id){
        return clienteRepository.findById(id);
    }

    public Cliente save(Cliente cliente){
        validateClienteDuplicated(cliente);
        return clienteRepository.save(cliente);
    }

    public Cliente update(Long id, Cliente cliente){
      Cliente clienteUpdate = validateExists(id);
      validateClienteDuplicated(cliente);
      BeanUtils.copyProperties(cliente, clienteUpdate, "id");
      return clienteRepository.save(clienteUpdate);
    }

    public void delete(Long id){
        clienteRepository.deleteById(id);
    }

    public Cliente validateExists(Long id){
        Optional<Cliente> cliente = findById(id);
        if (cliente.isEmpty()){
            throw new EmptyResultDataAccessException(1);
        }
        return cliente.get();
    }

    public void validateClienteDuplicated(Cliente cliente){
        Cliente clienteByName = clienteRepository.findByNome(cliente.getNome());
        if (clienteByName != null && clienteByName.getId() != cliente.getId()){
            throw new BusinessRuleException(String.format("O cliente %s já está cadastrado", cliente.getNome().toUpperCase()));
        }
    }
}









