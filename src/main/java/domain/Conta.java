package domain;

public abstract class Conta {

    private int id;
    private Banco banco;
    private Double saldo = 0d;
    private String numeroDaagencia = "0001";
    private String numeroDaconta;
    private Cliente cliente;

    public Conta(Banco banco, Cliente cliente) {
        int proximaConta = banco.getContas().size() + 1;

        this.id = proximaConta;
        this.banco = banco;
        this.numeroDaconta =  "000" + proximaConta;
        this.cliente = cliente;
    }

    protected String depositar(Double valor) {
        if(valor <= 0) return "Deposite um valor válido";

        saldo += valor;
        return "DEPÓSITO no valor de " + valor + " realizado com sucesso";
    }

    protected String sacar(Double valor) {
        if(valor > this.saldo || valor <= 0) throw new RuntimeException("Não é possível realizar o saque desse valor");

        saldo -= valor;
        return "SAQUE no valor de " + valor + " realizado com sucesso";
    }

    protected String transferir(Conta contaDestino, Double valor, TiposDeTransferencia tipo ) {
        double valorComTaxa = valor;

        if(tipo.equals(TiposDeTransferencia.TED)) valorComTaxa = valor + 15d;
        if(tipo.equals(TiposDeTransferencia.DOC)) valorComTaxa = valor + 10d;

        if(valorComTaxa > this.saldo || valor <= 0) return "Não é possível realizar uma transferência com esse valor";

        this.sacar(valorComTaxa);
        contaDestino.depositar(valor);

        return "TRANSFERÊNCIA no valor de " + valor + " para a Conta de " + contaDestino.getCliente().getNome() + " realizada com sucesso";
    }

    protected int getId() {
        return id;
    }

    protected void setId(int id) {
        this.id = id;
    }

    protected Banco getBanco() {
        return banco;
    }

    protected void setBanco(Banco banco) {
        this.banco = banco;
    }

    protected Double getSaldo() {
        return saldo;
    }

    protected void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    protected String getNumeroDaagencia() {
        return numeroDaagencia;
    }

    protected void setNumeroDaagencia(String numeroDaagencia) {
        this.numeroDaagencia = numeroDaagencia;
    }

    protected String getNumeroDaconta() {
        return numeroDaconta;
    }

    protected void setNumeroDaconta(String numeroDaconta) {
        this.numeroDaconta = numeroDaconta;
    }

    protected Cliente getCliente() {
        return cliente;
    }

    protected void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

}
