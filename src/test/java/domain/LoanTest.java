package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoanTest {

    public Bank bank = new Bank("001", "unibank");
    public Client client = new Client("11111111111", "Rebecca Lopes");
    public Account account;

    @Test
    void shouldMakeANewLoan() {

        this.account = bank.novaContaCorrente(client);

        Loan loan = bank.takeOutLoan(account, 10000d, 15);

        System.out.println(loan.getConta());
        System.out.println(loan.getValueInicial());

        Assertions.assertEquals(10000d, loan.getValueInicial());
    }

    @Test
    void shouldMakeLoanIfBankAccount() {
        this.account = bank.novaContaCorrente(client);
        Loan loan = bank.takeOutLoan(account, 10000d, 15);

        Assertions.assertTrue(bank.getLoans().contains(loan));

        Bank bank2 = new Bank("002", "otherbank");
        Account account2 = new CheckingAccount(bank2, client);

        Assertions.assertThrows(RuntimeException.class, () -> bank.takeOutLoan(account2, 15000d, 12));
    }

    @Test
    void loanShouldBeOnBankLoanList() {
        this.account = bank.novaContaCorrente(client);
        Loan loan = bank.takeOutLoan(account, 10000d, 15);

        Assertions.assertTrue(bank.getLoans().contains(loan));
    }

    @Test
    void requestedAmountShouldBeInTheAccountBalance() {
        this.account = bank.novaContaCorrente(client);
        System.out.println("Balance na conta ANTERIOR ao empréstimo: " + this.account.getBalance());

        Loan loan = bank.takeOutLoan(account, 10000d, 15);

        System.out.println("Balance na conta APÓS empréstimo: " + this.account.getBalance());
        Assertions.assertEquals(10000d, this.account.getBalance());
    }
}
