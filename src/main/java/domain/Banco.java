package domain;

import java.util.ArrayList;
import java.util.List;

public class Banco {

    private String codigo;
    private String nome;
    private Double saldoProprio;
    private Double saldoDasContas;
    private List<Conta> contas = new ArrayList();

    public Banco(String codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public Conta novaContaCorrente(Cliente cliente) {
     Conta conta = new ContaCorrente(this, cliente);

     cliente.setCc((ContaCorrente) conta);

     contas.add(conta);

     return conta;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getSaldoProprio() {
        return saldoProprio;
    }

    public void setSaldoProprio(Double saldoProprio) {
        this.saldoProprio = saldoProprio;
    }

    public Double getSaldoDasContas() {
        return saldoDasContas;
    }

    public void setSaldoDasContas(Double saldoDasContas) {
        this.saldoDasContas = saldoDasContas;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public void setContas(List<Conta> contas) {
        this.contas = contas;
    }
}
