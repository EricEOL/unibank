package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BancoTest {
    @Test
    void deveCriarUmNovoBanco() {
        Banco banco = new Banco("001", "unibank");

        System.out.println("Banco: " + banco.toString());

        Assertions.assertEquals("unibank", banco.getNome());
    }

    @Test
    void deveAssociarUmaContaCorrenteAoBanco() {
        Banco banco = new Banco("001", "unibank");
        Cliente cliente = new Cliente("11111111111", "Rebecca Lopes");

        Conta contaCriada = banco.novaContaCorrente(cliente);

        Assertions.assertTrue(banco.getContas().contains(contaCriada));
    }

    @Test
    void identificacaoDeNumeroDaContaDeveSerSequencial() {
        Banco banco = new Banco("001", "unibank");
        Cliente cliente1 = new Cliente("11111111111", "Rebecca Lopes");
        Cliente cliente2 = new Cliente("22222222222", "Thamiris Lopes");

        Conta conta1 = banco.novaContaCorrente(cliente1);
        Conta conta2 = banco.novaContaCorrente(cliente2);

        System.out.println("Conta1: " + conta1.getNumeroDaconta());
        System.out.println("Conta2: " + conta2.getNumeroDaconta());

        Assertions.assertEquals("0002", conta2.getNumeroDaconta());
    }

    @Test
    void deveAssociarUmaContaPoupancaAoBanco() {
        Banco banco = new Banco("001", "unibank");
        Cliente cliente = new Cliente("11111111111", "Rebecca Lopes");

        Conta contaCriada = banco.novaContaPoupanca(cliente);

        Assertions.assertTrue(banco.getContas().contains(contaCriada));
    }

    @Test
    void naoDeveSerPossivelCriarDuasContasCorrentesParaOMesmoCliente() {
        Banco banco = new Banco("001", "unibank");
        Cliente cliente = new Cliente("11111111111", "Rebecca Lopes");

        banco.novaContaCorrente(cliente);

        Assertions.assertThrows(RuntimeException.class, () -> banco.novaContaCorrente(cliente));
    }

    @Test
    void naoDeveSerPossivelCriarDuasContasPoupancaParaOMesmoCliente() {
        Banco banco = new Banco("001", "unibank");
        Cliente cliente = new Cliente("11111111111", "Rebecca Lopes");

        banco.novaContaPoupanca(cliente);

        Assertions.assertThrows(RuntimeException.class, () -> banco.novaContaPoupanca(cliente));
    }
}
