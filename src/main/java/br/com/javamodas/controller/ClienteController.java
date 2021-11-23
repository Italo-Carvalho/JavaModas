package br.com.javamodas.controller;


import br.com.javamodas.dto.cliente.ClienteRequestDTO;
import br.com.javamodas.dto.cliente.ClienteResponseDTO;
import br.com.javamodas.model.Cliente;
import br.com.javamodas.service.ClienteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Api(tags="Cliente")
@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @ApiOperation(value = "Listar clientes", nickname = "listAllClients")
    @GetMapping
    public List<ClienteResponseDTO> listAll(){
        return clienteService.listAll().stream().map(cliente -> ClienteResponseDTO.convertToClienteDTO(cliente)).collect(Collectors.toList());
    }

    @ApiOperation(value = "Pegar cliente", nickname = "getClientById")
    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponseDTO> findById(@PathVariable Long id){
        Optional<Cliente> cliente = clienteService.findById(id);
        return cliente.isPresent() ? ResponseEntity.ok(ClienteResponseDTO.convertToClienteDTO(cliente.get())) : ResponseEntity.notFound().build();
    }

    @ApiOperation(value = "Salvar cliente", nickname = "saveClient")
    @PostMapping
    public ResponseEntity<ClienteResponseDTO> salvar(@Valid @RequestBody ClienteRequestDTO cliente){
        Cliente clienteSave = clienteService.save(cliente.convertToEntity());
        return ResponseEntity.status(HttpStatus.CREATED).body(ClienteResponseDTO.convertToClienteDTO(clienteSave));
    }

    @ApiOperation(value = "Atualizar cliente", nickname = "updateClient")
    @PutMapping("/{id}")
    public ResponseEntity<ClienteResponseDTO> update(@PathVariable Long id, @Valid @RequestBody ClienteRequestDTO cliente){
        Cliente clienteUpdated = clienteService.update(id, cliente.convertToEntity(id));
        return ResponseEntity.ok(ClienteResponseDTO.convertToClienteDTO(clienteUpdated));
    }

    @ApiOperation(value = "Deletar cliente", nickname = "deleteClient")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        clienteService.delete(id);
    }

}
