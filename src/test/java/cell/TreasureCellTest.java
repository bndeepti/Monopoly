package cell;

import model.Bank;
import model.Player;
import model.TransactionType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class TreasureCellTest {
    TreasureCell treasureCell;
    @Before
    public void setUp() throws Exception {
        int value = 200;
        treasureCell = new TreasureCell(value);
    }

    @Test
    public void testShouldSetTreasureValue() {
        assertEquals(200, treasureCell.getValue());
    }

    @Test
    public void testShouldHandleTransactionForPlayerByGivingTreasureValue() {
        int initialWorth = 1000;
        Player player = new Player("Player1", initialWorth);
        Bank bank = mock(Bank.class);

        treasureCell.handleTransaction(player, bank);

        verify(bank).transact(player, 200, TransactionType.CREDIT);
    }

}