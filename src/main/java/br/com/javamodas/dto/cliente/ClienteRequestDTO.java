package br.com.javamodas.dto.cliente;

import br.com.javamodas.model.Cliente;
import br.com.javamodas.model.Endereco;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@ApiModel("Cliente Request DTO")
public class ClienteRequestDTO {


    @ApiModelProperty(value="Nome")
    @NotBlank(message = "Nome")
    @Length(max = 50, min = 3, message = "Nome")
    private String nome;

    @ApiModelProperty(value="Telefone")
    @NotBlank(message = "Telefone")
    @Pattern(regexp = "\\([\\d]{2}\\)[\\d]{5}[- .][\\d]{4}", message = "Telefone")
    private String telefone;

    @ApiModelProperty(value="Ativo")
    @NotNull(message = "Ativo")
    private Boolean ativo;

    @ApiModelProperty(value = "Endereço")
    @NotNull(message = "Endereço")
    @Valid
    private EnderecoResquestDTO enderecoResquestDTO;

    public Cliente convertToEntity(){
        Endereco endereco = new Endereco(
                enderecoResquestDTO.getLogradouro(),
                enderecoResquestDTO.getNumero(),
                enderecoResquestDTO.getComplemento(),
                enderecoResquestDTO.getBairro(),
                enderecoResquestDTO.getCep(),
                enderecoResquestDTO.getCidade(),
                enderecoResquestDTO.getEstado()
                );
        return new Cliente(nome, telefone, ativo, endereco);
    }

    public Cliente convertToEntity(Long id){
        Endereco endereco = new Endereco(
                enderecoResquestDTO.getLogradouro(),
                enderecoResquestDTO.getNumero(),
                enderecoResquestDTO.getComplemento(),
                enderecoResquestDTO.getBairro(),
                enderecoResquestDTO.getCep(),
                enderecoResquestDTO.getCidade(),
                enderecoResquestDTO.getEstado()
        );
        return new Cliente(id ,nome, telefone, ativo, endereco);
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public EnderecoResquestDTO getEnderecoResquestDTO() {
        return enderecoResquestDTO;
    }

    public void setEnderecoResquestDTO(EnderecoResquestDTO enderecoResquestDTO) {
        this.enderecoResquestDTO = enderecoResquestDTO;
    }
}
