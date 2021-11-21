package br.com.javamodas.dto.cliente;

import br.com.javamodas.model.Cliente;
import br.com.javamodas.model.Endereco;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Cliente Response DTO")
public class ClienteResponseDTO {

    @ApiModelProperty(value="Id")
    private Long id;

    @ApiModelProperty(value="Nome")
    private String nome;

    @ApiModelProperty(value="Telefone")
    private String telefone;

    @ApiModelProperty(value="Ativo")
    private Boolean ativo;

    @ApiModelProperty(value = "Endereço")
    private EnderecoResponseDTO enderecoResponseDTO;


    public ClienteResponseDTO(Long id, String nome, String telefone, Boolean ativo, EnderecoResponseDTO enderecoResponseDTO) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.ativo = ativo;
        this.enderecoResponseDTO = enderecoResponseDTO;
    }
    public static ClienteResponseDTO convertToClienteDTO(Cliente cliente){
        EnderecoResponseDTO enderecoResponseDTO = new EnderecoResponseDTO(
                cliente.getEndereco().getLogradouro(),
                cliente.getEndereco().getNumero(),
                cliente.getEndereco().getComplemento(),
                cliente.getEndereco().getBairro(),
                cliente.getEndereco().getCep(),
                cliente.getEndereco().getCidade(),
                cliente.getEndereco().getEstado());

        return new ClienteResponseDTO(cliente.getId(), cliente.getNome(), cliente.getTelefone(), cliente.getAtivo(), enderecoResponseDTO);
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

    public EnderecoResponseDTO getEnderecoResponseDTO() {
        return enderecoResponseDTO;
    }

    public void setEnderecoResponseDTO(EnderecoResponseDTO enderecoResponseDTO) {
        this.enderecoResponseDTO = enderecoResponseDTO;
    }

}
