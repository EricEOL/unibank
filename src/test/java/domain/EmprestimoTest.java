package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EmprestimoTest {

    public Banco banco = new Banco("001", "unibank");
    public Cliente cliente = new Cliente("11111111111", "Rebecca Lopes");
    public Conta conta;

    @Test
    void shouldMakeANewLoan() {

        this.conta = banco.novaContaCorrente(cliente);

        Emprestimo emprestimo = banco.realizarEmprestimo(conta, 10000d, 15);

        System.out.println(emprestimo.getConta());
        System.out.println(emprestimo.getValorInicial());

        Assertions.assertTrue(banco.getEmprestimos().contains(emprestimo));
        Assertions.assertEquals(10000d, emprestimo.getValorInicial());
    }

    @Test
    void shouldMakeLoanIfBankAccount() {
        this.conta = banco.novaContaCorrente(cliente);
        Emprestimo emprestimo = banco.realizarEmprestimo(conta, 10000d, 15);

        Assertions.assertTrue(banco.getEmprestimos().contains(emprestimo));

        Banco banco2 = new Banco("002", "otherbank");
        Conta conta2 = new ContaCorrente(banco2, cliente);

        Assertions.assertThrows(RuntimeException.class, () -> banco.realizarEmprestimo(conta2, 15000d, 12));

        System.out.println(banco.getEmprestimos());
    }
}
