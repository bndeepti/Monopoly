package cell;

import transaction.Bank;
import model.Player;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HotelCellTest {
    HotelCell hotelCell;
    Bank bank;
    int initialWorth;

    @Before
    public void setUp() throws Exception {
        int rent = 50;
        int cost = 200;
        hotelCell = new HotelCell(cost, rent);
        bank = new Bank();
        initialWorth = 1000;
    }

    @Test
    public void testShouldHandleTransactionForPlayerBySellingAtACostIfHotelIsForSale() {
        Player player = new Player("Player1", initialWorth);
        hotelCell.handleTransaction(player, bank);

        assertEquals(800, player.getWorth());
        assertEquals(1, player.getOwnedHotelCells().size());
        assertEquals(player, hotelCell.getOwner());
    }

    @Test
    public void testShouldHandleTransactionForPlayerByTakingRentIfHotelIsOwned() {
        Player owner = new Player("Owner", initialWorth);
        Player player = new Player("Player1", initialWorth);

        hotelCell.sell(owner);
        hotelCell.handleTransaction(player, bank);

        assertEquals(950, player.getWorth());
        assertEquals(1050, owner.getWorth());
    }

    @Test
    public void testShouldHandleTransactionForOwnerByNotTakingRent() {
        Player owner = new Player("Owner", initialWorth);

        hotelCell.sell(owner);
        hotelCell.handleTransaction(owner, bank);

        assertEquals(1000, owner.getWorth());
    }

}