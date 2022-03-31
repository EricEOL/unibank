package domain;

import java.util.ArrayList;
import java.util.List;

public class Banco {

    private String codigo;
    private String nome;
    private Double saldoProprio = 10000000000000000d;
    private Double saldoDasContas;
    private List<Conta> contas = new ArrayList();
    private List<Emprestimo> emprestimos = new ArrayList();

    public Banco(String codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public Conta novaContaCorrente(Cliente cliente) {
        for (Conta conta : contas) {
            if (conta.getCliente().getCpf() == cliente.getCpf() && conta.getClass() == ContaCorrente.class) {
                throw new RuntimeException("Não é possível criar duas contas correntes para o mesmo cliente");
            }
        }

        Conta conta = new ContaCorrente(this, cliente);

        cliente.setCc((ContaCorrente) conta);

        contas.add(conta);

        return conta;
    }

    public Conta novaContaPoupanca(Cliente cliente) {

        for (Conta conta : contas) {
            if (conta.getCliente().getCpf() == cliente.getCpf() && conta.getClass() == ContaPoupanca.class) {
                throw new RuntimeException("Não é possível criar duas contas poupança para o mesmo cliente");
            }
        }

        Conta conta = new ContaPoupanca(this, cliente);

        cliente.setCp((ContaPoupanca) conta);

        contas.add(conta);

        return conta;
    }

    public Emprestimo realizarEmprestimo(Conta contaSolicitante, Double valorSolicitado, int parcelas) {
        if (valorSolicitado > 30000d) throw new RuntimeException("Valor solicitado excede o permitido");

        if(!contas.contains(contaSolicitante)) throw new RuntimeException("O empréstimo só é realizado para contas relacionadas ao banco, contas de outros bancos não são permitidas");

        Emprestimo emprestimo = new Emprestimo(contaSolicitante, valorSolicitado, parcelas);
        contaSolicitante.depositar(valorSolicitado);
        this.setSaldoProprio(saldoProprio - valorSolicitado);
        this.emprestimos.add(emprestimo);

        return emprestimo;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
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

    public List<Conta> getContas() {
        return contas;
    }

    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    @Override
    public String toString() {
        return "Banco{" +
                "codigo='" + codigo + '\'' +
                ", nome='" + nome + '\'' +
                '}';
    }
}
