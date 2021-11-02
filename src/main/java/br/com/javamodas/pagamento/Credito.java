package br.com.javamodas.pagamento;


public class Credito extends Pagamento{
    private int numero;
    private String tipo;

    public void autorizar(){}

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }



    @Override
    public void varificarTranzacao() {

    }

    @Override
    public void confirmaPagamento() {

    }
}
