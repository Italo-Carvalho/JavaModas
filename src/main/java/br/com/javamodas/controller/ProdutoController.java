package br.com.javamodas.controller;

import br.com.javamodas.dto.produto.ProdutoRequestDTO;
import br.com.javamodas.dto.produto.ProdutoResponseDTO;
import br.com.javamodas.model.Produto;
import br.com.javamodas.service.ProdutoService;
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

@Api(tags="Produto")
@RestController
@RequestMapping("/categoria/{categoryId}/produto")
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;


    @ApiOperation(value = "Listar produtos por categoria", nickname = "listByCategory")
    @GetMapping
    public List<ProdutoResponseDTO> listByCategory(@PathVariable Long categoryId){
        return produtoService.findByCategoriaId(categoryId).stream()
                .map(produto -> ProdutoResponseDTO.convert(produto))
                .collect(Collectors.toList());
    }

    // faster
    @ApiOperation(value="Pegar produtos", nickname = "findByIdAndCategoryId")
    @GetMapping("/{productId}")
    public ResponseEntity<ProdutoResponseDTO> findByIdAndCategoryId(@PathVariable Long productId, @PathVariable Long categoryId){
        Optional<Produto> produto = produtoService.findByIdAndCategoriaId(productId,categoryId);
        return produto.isPresent() ? ResponseEntity.ok(ProdutoResponseDTO.convert(produto.get())) : ResponseEntity.notFound().build();
    }

    @ApiOperation(value = "Salvar produto", nickname = "saveProduct")
    @PostMapping
    public ResponseEntity<ProdutoResponseDTO> save(@PathVariable Long categoryId, @Valid @RequestBody ProdutoRequestDTO produto){
        Produto produtoSave = produtoService.save(produto.convert(categoryId),categoryId);
        return ResponseEntity.status(HttpStatus.CREATED).body(ProdutoResponseDTO.convert(produtoSave));
    }

    @ApiOperation(value="Deletar produto", nickname = "deleteProduct")
    @DeleteMapping("/{productId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long categoryId, @PathVariable Long productId){
        produtoService.delete(categoryId, productId);
    }


    @ApiOperation(value = "Atualizar produto")
    @PutMapping("/{productId}")
    public ResponseEntity<ProdutoResponseDTO> update(@PathVariable Long categoryId, @PathVariable Long productId, @Valid @RequestBody ProdutoRequestDTO produto){
        Produto produtoUpdated = produtoService.update(categoryId, productId, produto.convert(categoryId, productId));
        return  ResponseEntity.ok(ProdutoResponseDTO.convert(produtoUpdated));
    }

}
