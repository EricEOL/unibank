package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ContaTest {

    public Banco banco = new Banco("001", "unibank");
    public Cliente cliente = new Cliente("11111111111", "Rebecca Lopes");
    public Conta conta;

    @Test
    void deveCriarUmaConta() {
        this.conta = banco.novaContaCorrente(cliente);

        System.out.println("Agência: " + conta.getNumeroDaagencia());
        System.out.println("Conta: " + conta.getNumeroDaconta());

        Assertions.assertEquals("0001", conta.getNumeroDaagencia());
        Assertions.assertEquals("0001", conta.getNumeroDaconta());
    }

    @Test
    void deveRealizarUmDeposito() {
        this.conta = banco.novaContaCorrente(cliente);

        String retorno = conta.depositar(3000d);

        System.out.println(retorno);
        System.out.println("Saldo: " + conta.getSaldo());

        Assertions.assertEquals(3000d, conta.getSaldo());
    }

    @Test
    void deveRealizarUmSaque() {
        this.conta = banco.novaContaCorrente(cliente);

        conta.depositar(2000d);

        String retorno = conta.sacar(1000d);

        System.out.println(retorno);
        System.out.println("Saldo: " + conta.getSaldo());

        Assertions.assertEquals(1000d, conta.getSaldo());
    }

    @Test
    void deveRealizarTransferenciaEntreContasComPIX() {
        this.conta = banco.novaContaCorrente(cliente);
        Conta conta2 = banco.novaContaPoupanca(cliente);

        conta.depositar(3000d);
        conta2.depositar(5500d);

        conta.transferir(conta2, 2500d, TiposDeTransferencia.PIX);

        System.out.println("Saldo - Conta1: " + conta.getSaldo());
        System.out.println("Saldo - Conta2: " + conta2.getSaldo());

        Assertions.assertEquals(500d, conta.getSaldo());
        Assertions.assertEquals(8000d, conta2.getSaldo());
    }

    @Test
    void deveRealizarTransferenciaEntreContasComTED() {
        this.conta = banco.novaContaCorrente(cliente);
        Conta conta2 = banco.novaContaPoupanca(cliente);

        conta.depositar(3000d);
        conta2.depositar(5500d);

        conta.transferir(conta2, 2500d, TiposDeTransferencia.TED);

        System.out.println("Saldo - Conta1: " + conta.getSaldo());
        System.out.println("Saldo - Conta2: " + conta2.getSaldo());

        Assertions.assertEquals(485d, conta.getSaldo());
        Assertions.assertEquals(8000d, conta2.getSaldo());
    }

    @Test
    void deveRealizarTransferenciaEntreContasComDOC() {
        this.conta = banco.novaContaCorrente(cliente);
        Conta conta2 = banco.novaContaPoupanca(cliente);

        conta.depositar(3000d);
        conta2.depositar(5500d);

        conta.transferir(conta2, 2500d, TiposDeTransferencia.DOC);

        System.out.println("Saldo - Conta1: " + conta.getSaldo());
        System.out.println("Saldo - Conta2: " + conta2.getSaldo());

        Assertions.assertEquals(490d, conta.getSaldo());
        Assertions.assertEquals(8000d, conta2.getSaldo());
    }

}
