package cell;

import model.Player;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HotelCellTest {
    HotelCell hotelCell;
    @Before
    public void setUp() throws Exception {
        hotelCell = new HotelCell();
    }

    @Test
    public void testShouldSetHotelCostAndRent() {
        assertEquals(200, hotelCell.getCost());
        assertEquals(50, hotelCell.getRent());
    }


    @Test
    public void testShouldHandleTransactionForPlayerBySellingAtACostIfHotelIsForSale() {
        Player player = new Player("Player1");
        hotelCell.setOwned(false);
        hotelCell.handleTransaction(player);

        assertEquals(800, player.getWorth());
        assertEquals(1, player.getOwnedHotelCells().size());
        assertEquals(true, hotelCell.isOwned());
        assertEquals(player, hotelCell.getOwner());
    }

    @Test
    public void testShouldHandleTransactionForPlayerByTakingRentIfHotelIsOwned() {
        Player owner = new Player("Owner");
        Player player = new Player("Player1");

        hotelCell.setOwner(owner);
        hotelCell.setOwned(true);
        hotelCell.handleTransaction(player);

        assertEquals(950, player.getWorth());
        assertEquals(1050, owner.getWorth());
    }

    @Test
    public void testShouldHandleTransactionForOwnerByNotTakingRent() {
        Player owner = new Player("Owner");

        hotelCell.setOwner(owner);
        hotelCell.setOwned(true);
        hotelCell.handleTransaction(owner);

        assertEquals(1000, owner.getWorth());
    }

}