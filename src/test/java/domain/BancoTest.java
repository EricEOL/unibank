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
    void deveAssociarUmaContaPoupancaAoBanco() {
        Banco banco = new Banco("001", "unibank");
        Cliente cliente = new Cliente("11111111111", "Rebecca Lopes");

        Conta contaCriada = banco.novaContaPoupanca(cliente);

        Assertions.assertTrue(banco.getContas().contains(contaCriada));
    }
}
