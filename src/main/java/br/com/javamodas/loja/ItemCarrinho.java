package br.com.javamodas.loja;

public class ItemCarrinho {
    private Produto produto;
    private int qtd;

    public ItemCarrinho(Produto produto, int qtd) throws Exception {
        if (qtd > produto.getQtd()) throw new Exception("A quantidade não ser maior que o estoque do produto");
        this.produto = produto;
        this.qtd = qtd;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }
}
