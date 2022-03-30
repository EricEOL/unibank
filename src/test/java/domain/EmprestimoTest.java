package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EmprestimoTest {

    public Banco banco = new Banco("001", "unibank");
    public Cliente cliente = new Cliente("11111111111", "Rebecca Lopes");
    public Conta conta;

    @Test
    void deveRealizarUmNovoEmprestimo() {

        this.conta = banco.novaContaCorrente(cliente);

        Emprestimo emprestimo = banco.realizarEmprestimo(conta, 10000d, 15);

        System.out.println(emprestimo.getConta());
        System.out.println(emprestimo.getValorInicial());

        Assertions.assertTrue(banco.getEmprestimos().contains(emprestimo));
        Assertions.assertEquals(10000d, emprestimo.getValorInicial());
    }
}
