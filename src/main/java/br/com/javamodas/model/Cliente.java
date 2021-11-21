package br.com.javamodas.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "telefone")
    private String telefone;

    @Column(name="ativo")
    private Boolean ativo;

    @Embedded
    private Endereco endereco;

    public Cliente(Long id, String nome, String telefone, Boolean ativo, Endereco endereco) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.ativo = ativo;
        this.endereco = endereco;
    }

    public Cliente(String nome, String telefone, Boolean ativo, Endereco endereco) {
        this.nome = nome;
        this.telefone = telefone;
        this.ativo = ativo;
        this.endereco = endereco;
    }

    public Cliente() {}

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

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cliente)) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(getId(), cliente.getId()) && Objects.equals(getNome(), cliente.getNome()) && Objects.equals(getTelefone(), cliente.getTelefone()) && Objects.equals(getAtivo(), cliente.getAtivo()) && Objects.equals(getEndereco(), cliente.getEndereco());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNome(), getTelefone(), getAtivo(), getEndereco());
    }
}
