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

    private void depositar(Double valor) {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public String getNumeroDaagencia() {
        return numeroDaagencia;
    }

    public void setNumeroDaagencia(String numeroDaagencia) {
        this.numeroDaagencia = numeroDaagencia;
    }

    public String getNumeroDaconta() {
        return numeroDaconta;
    }

    public void setNumeroDaconta(String numeroDaconta) {
        this.numeroDaconta = numeroDaconta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    // private String sacar(Double valor) {}

    // private String transferir(Conta contaDestino, Double valor ) {}
}
