package domain;

public class Cliente {
    private String cpf;
    private String nome;
    private ContaCorrente cc;
    private ContaPoupanca cp;

    public Cliente(String cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ContaCorrente getCc() {
        return cc;
    }

    public void setCc(ContaCorrente cc) {
        this.cc = cc;
    }

    public ContaPoupanca getCp() {
        return cp;
    }

    public void setCp(ContaPoupanca cp) {
        this.cp = cp;
    }
}
