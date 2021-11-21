package br.com.javamodas.controller;

import br.com.javamodas.dto.venda.ClienteVendaResponseDTO;
import br.com.javamodas.service.VendaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "Venda")
@RestController
@RequestMapping(value = "/venda")
public class VendaController {

    @Autowired
    private VendaService vendaService;

    @ApiOperation(value = "Listar vendas por id", nickname = "listVendasById")
    @GetMapping("/{id}")
    public ResponseEntity<ClienteVendaResponseDTO> listById(@PathVariable Long id){
        return ResponseEntity.ok(vendaService.listAllById(id));
    }


    @ApiOperation(value = "Listar vendas por cliente", nickname = "listVendasByCliente")
    @GetMapping("/cliente/{clienteId}")
    public ResponseEntity<ClienteVendaResponseDTO> listByCliente(@PathVariable Long clienteId){
        return ResponseEntity.ok(vendaService.listAllByClienteId(clienteId));
    }

}
