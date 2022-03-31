package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BankTest {
    @Test
    void shouldCreateANewBank() {
        Bank bank = new Bank("001", "unibank");

        System.out.println("Bank: " + bank.toString());

        Assertions.assertEquals("unibank", bank.getName());
    }

    @Test
    void shouldAssociateACheckingAccountWithBank() {
        Bank bank = new Bank("001", "unibank");
        Client client = new Client("11111111111", "Rebecca Lopes");

        Account accountCriada = bank.novaContaCorrente(client);

        Assertions.assertTrue(bank.getContas().contains(accountCriada));
    }

    @Test
    void shouldAssociateASavingsAccountWithBank() {
        Bank bank = new Bank("001", "unibank");
        Client client = new Client("11111111111", "Rebecca Lopes");

        Account accountCriada = bank.novaContaPoupanca(client);

        Assertions.assertTrue(bank.getContas().contains(accountCriada));
    }

    @Test
    void accountNumberShouldBeSequential() {
        Bank bank = new Bank("001", "unibank");
        Client client1 = new Client("11111111111", "Rebecca Lopes");
        Client client2 = new Client("22222222222", "Thamiris Lopes");

        Account account1 = bank.novaContaCorrente(client1);
        Account account2 = bank.novaContaCorrente(client2);

        System.out.println("Conta1: " + account1.getAccountNumber());
        System.out.println("Conta2: " + account2.getAccountNumber());

        Assertions.assertEquals("0002", account2.getAccountNumber());
    }

    @Test
    void shouldNotBePossibleCreateTwoCheckingAccountsForSameClientAtSameBank() {
        Bank bank = new Bank("001", "unibank");
        Client client = new Client("11111111111", "Rebecca Lopes");

        bank.novaContaCorrente(client);

        Assertions.assertThrows(RuntimeException.class, () -> bank.novaContaCorrente(client));
    }

    @Test
    void shouldNotBePossibleCreateTwoSavingsAccountsForSameClientAtSameBank() {
        Bank bank = new Bank("001", "unibank");
        Client client = new Client("11111111111", "Rebecca Lopes");

        bank.novaContaPoupanca(client);

        Assertions.assertThrows(RuntimeException.class, () -> bank.novaContaPoupanca(client));
    }
}
