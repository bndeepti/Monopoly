package model;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BankTest {
    Bank bank;
    @Before
    public void setUp() throws Exception {
        bank = new Bank();
    }

    @Test
    public void testShouldDebitAmount() throws Exception {
        Player player = mock(Player.class);

        int amount = 100;
        TransactionType transactionType = TransactionType.DEBIT;
        bank.transact(player, amount, transactionType);

        verify(player).updateWorth(amount, transactionType);
    }

    @Test
    public void testShouldCreditAmount() throws Exception {
        Player player = mock(Player.class);

        int amount = 100;
        TransactionType transactionType = TransactionType.CREDIT;
        bank.transact(player, amount, transactionType);

        verify(player).updateWorth(amount, transactionType);
    }

}