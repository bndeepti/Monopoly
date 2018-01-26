package cell;

import model.Bank;
import model.Player;
import model.TransactionType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


public class JailCellTest {
    JailCell jailCell;
    @Before
    public void setUp() throws Exception {
        jailCell = new JailCell();
    }

    @Test
    public void testShouldSetJailFine() {
        assertEquals(150, jailCell.getFine());
    }

    @Test
    public void testShouldHandleTransactionForPlayerByTakingFine() {
        Player player = new Player("Player1");
        Bank bank = mock(Bank.class);
        jailCell.handleTransaction(player, bank);

        verify(bank).transact(player, 150, TransactionType.DEBIT);
    }

}