package cell;

import model.Player;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

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

        treasureCell.handleTransaction(player);

        assertEquals(1200, player.getWorth());
    }

}