package cell;

import model.Player;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


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
        jailCell.handleTransaction(player);

        assertEquals(850, player.getWorth());
    }

}