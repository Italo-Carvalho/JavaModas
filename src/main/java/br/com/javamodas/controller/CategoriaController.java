package br.com.javamodas.controller;

import br.com.javamodas.dto.categoria.CategoriaRequestDTO;
import br.com.javamodas.dto.categoria.CategoriaResponseDTO;
import br.com.javamodas.model.Categoria;
import br.com.javamodas.service.CategoriaService;
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

@Api(tags="Categoria")
@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @ApiOperation(value="Todas as categorias", nickname ="listAllCategory")
    @GetMapping
    public List<CategoriaResponseDTO> listAll(){

        return categoriaService.listAll().stream()
                .map(categoria -> CategoriaResponseDTO.convert(categoria))
                .collect(Collectors.toList());
    }

    @ApiOperation(value = "Pegar categoria", nickname = "findByIdCategory")
    @GetMapping("/{id}")
    public ResponseEntity<CategoriaResponseDTO> findById(@PathVariable Long id){
        Optional<Categoria> categoria =  categoriaService.findById(id);
        return categoria.isPresent() ? ResponseEntity.ok(CategoriaResponseDTO.convert(categoria.get())) : ResponseEntity.notFound().build();
    };

    @ApiOperation(value = "Salvar categoria", nickname = "saveCategory")
    @PostMapping
    public ResponseEntity<CategoriaResponseDTO> save(@Valid @RequestBody CategoriaRequestDTO categoriaDto){
        Categoria categoriaSave = categoriaService.save(categoriaDto.convert());
        return ResponseEntity.status(HttpStatus.CREATED).body(CategoriaResponseDTO.convert(categoriaSave));
    };



    @ApiOperation(value = "Atualizar categoria", nickname = "updateCategory")
    @PutMapping("/{id}")
    public ResponseEntity<CategoriaResponseDTO> update(@PathVariable Long id, @Valid @RequestBody CategoriaRequestDTO categoria) {
        Categoria categoriaUpdated = categoriaService.update(id, categoria.convert(id));
        return ResponseEntity.ok(CategoriaResponseDTO.convert(categoriaUpdated));
    }


    @ApiOperation(value = "Deletar Categoria", nickname = "deleteCategory")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        categoriaService.delete(id);
    }

}
