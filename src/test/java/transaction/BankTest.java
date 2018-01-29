package transaction;

import model.Player;
import org.junit.Before;
import org.junit.Test;
import transaction.Bank;
import transaction.TransactionType;

import static org.junit.Assert.assertEquals;
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

    @Test
    public void testShouldCreditBankBalance() throws Exception {
        Player player = mock(Player.class);

        int amount = 100;
        TransactionType transactionType = TransactionType.DEBIT;
        bank.transactWithBank(player, amount, transactionType);

        verify(player).updateWorth(amount, transactionType);
        assertEquals(100, bank.getBalance());
    }

    @Test
    public void testShouldDebitBankBalance() throws Exception {
        Player player = mock(Player.class);

        int amount = 100;
        TransactionType transactionType = TransactionType.CREDIT;
        bank.transactWithBank(player, amount, transactionType);

        verify(player).updateWorth(amount, transactionType);
        assertEquals(-100, bank.getBalance());
    }

}