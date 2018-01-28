package cell;

import model.Bank;
import model.Player;
import model.TransactionType;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


public class JailCellTest {
    JailCell jailCell;
    @Before
    public void setUp() throws Exception {
        int fine = 150;
        jailCell = new JailCell(fine);
    }

    @Test
    public void testShouldHandleTransactionForPlayerByTakingFine() {
        int initialWorth = 1000;
        Player player = new Player("Player1", initialWorth);
        Bank bank = mock(Bank.class);
        jailCell.handleTransaction(player, bank);

        verify(bank).transact(player, 150, TransactionType.DEBIT);
    }

}