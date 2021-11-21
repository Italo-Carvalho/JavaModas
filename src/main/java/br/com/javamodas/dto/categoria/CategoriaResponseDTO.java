package br.com.javamodas.dto.categoria;

import br.com.javamodas.model.Categoria;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Categoria Response DTO")
public class CategoriaResponseDTO {

    @ApiModelProperty(value="Id")
    private Long id;

    @ApiModelProperty(value="Nome")
    private String nome;

    public CategoriaResponseDTO(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public static CategoriaResponseDTO convert(Categoria categoria){
        return new CategoriaResponseDTO(categoria.getId(), categoria.getNome());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}