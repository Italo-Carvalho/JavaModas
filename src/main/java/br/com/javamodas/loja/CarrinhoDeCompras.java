package br.com.javamodas.loja;
import br.com.javamodas.pessoa.Cliente;

import java.util.List;

public class CarrinhoDeCompras {
    private Cliente cliente;
    private List<ItemCarrinho> itens;

    public CarrinhoDeCompras(Cliente cliente, List<ItemCarrinho> itens) {
        this.cliente = cliente;
        this.itens = itens;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ItemCarrinho> getItens() {
        return itens;
    }

    public void setItens(List<ItemCarrinho> itens) {
        this.itens = itens;
    }
}
