package br.com.javamodas.dto.cliente;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@ApiModel("Endereco Request DTO")
public class EnderecoResquestDTO {

    @ApiModelProperty(value = "Logradouro")
    @NotBlank(message = "Logradouro")
    @Length(max = 50, min = 3, message = "Logradouro")
    private String logradouro;

    @ApiModelProperty(value = "Numero")
    @NotNull(message = "Numero")
    private Integer numero;

    @ApiModelProperty(value = "Complemento")
    @Length(max = 50, message = "Complemento")
    private String complemento;

    @ApiModelProperty(value = "Bairro")
    @NotBlank(message = "Bairro")
    @Length(max = 50, min = 3, message = "Bairro")
    private String bairro;

    @ApiModelProperty(value = "Cep")
    @NotBlank(message = "Bairro")
    @Pattern(regexp = "[\\d]{5}-[\\d]{3}", message = "Cep")
    private String cep;

    @ApiModelProperty(value = "Cidade")
    @NotBlank(message = "Cidade")
    @Length(max = 50, min = 3, message = "Cidade")
    private String cidade;

    @ApiModelProperty(value = "Estado")
    @NotBlank(message = "Estado")
    @Length(max = 50, min = 3, message = "Estado")
    private String estado;

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
