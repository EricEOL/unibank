package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BancoTest {
    @Test
    void deveCriarUmNovoBanco() {
        Banco banco = new Banco("001", "unibank");
        Assertions.assertEquals("unibank", banco.getNome());
    }

    @Test
    void deveAssociarUmaContaCorrenteAoBanco() {
        Banco banco = new Banco("001", "unibank");
        Cliente cliente = new Cliente("11111111111", "Rebecca Lopes");

        Conta contaCriada = banco.novaContaCorrente(cliente);

        Assertions.assertEquals("0001", contaCriada.getNumeroDaagencia());
        Assertions.assertEquals("0001", contaCriada.getNumeroDaconta());
    }
}
