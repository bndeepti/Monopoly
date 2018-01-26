package cell;

import model.Bank;
import model.Player;
import model.TransactionType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class TreasureCellTest {
    TreasureCell treasureCell;
    @Before
    public void setUp() throws Exception {
        treasureCell = new TreasureCell();
    }

    @Test
    public void testShouldSetTreasureValue() {
        assertEquals(200, treasureCell.getValue());
    }

    @Test
    public void testShouldHandleTransactionForPlayerByGivingTreasureValue() {
        Player player = new Player("Player1");
        Bank bank = mock(Bank.class);

        treasureCell.handleTransaction(player, bank);

        verify(bank).transact(player, 200, TransactionType.CREDIT);
    }

}