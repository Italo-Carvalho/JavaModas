package br.com.javamodas.dto.categoria;

import br.com.javamodas.model.Categoria;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@ApiModel("Categoria Request DTO")
public class CategoriaRequestDTO {

    @ApiModelProperty(value = "Nome")
    @NotBlank(message = "Nome")
    @Length(min = 3, max = 50, message = "Nome")
    private  String nome;

    public Categoria convert(){
        return new Categoria(nome);
    }

    public Categoria convert(Long id){
        return new Categoria(id, nome);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}