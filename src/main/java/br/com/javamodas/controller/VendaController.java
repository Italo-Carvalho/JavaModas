package br.com.javamodas.controller;

import br.com.javamodas.dto.venda.ClienteVendaResponseDTO;
import br.com.javamodas.dto.venda.VendaRequestDTO;
import br.com.javamodas.service.VendaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(tags = "Venda")
@RestController
@RequestMapping(value = "/venda")
public class VendaController {

    @Autowired
    private VendaService vendaService;

    @ApiOperation(value = "Listar vendas por id", nickname = "listVendasById")
    @GetMapping("/{id}")
    public ResponseEntity<ClienteVendaResponseDTO> listAllById(@PathVariable Long id){
        return ResponseEntity.ok(vendaService.listAllById(id));
    }


    @ApiOperation(value = "Listar vendas por cliente", nickname = "listVendasByCliente")
    @GetMapping("/cliente/{clienteId}")
    public ResponseEntity<ClienteVendaResponseDTO> listAllByCliente(@PathVariable Long clienteId){
        return ResponseEntity.ok(vendaService.listAllByClienteId(clienteId));
    }

    @ApiOperation(value = "Salvar venda", nickname = "saveVenda")
    @PostMapping("/cliente/{clienteId}")
    public ResponseEntity<ClienteVendaResponseDTO> save(@PathVariable Long clienteId,@Valid @RequestBody VendaRequestDTO vendaRequestDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(vendaService.save(clienteId, vendaRequestDTO));
    }

    @ApiOperation(value = "Deletar venda", nickname = "deleteVenda")
    @DeleteMapping("/{idVenda}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long idVenda){
        vendaService.delete(idVenda);
    }

}
