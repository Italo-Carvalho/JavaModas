package br.com.javamodas.pagamento;

public interface ProcessarPagamento {
    void varificarTranzacao();
    void confirmaPagamento();
    void autorizar();
}
