package model;

import cell.HotelCell;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PlayerTest {
    Player player;
    Dice dice;

    @Before
    public void setUp() throws Exception {
        player = new Player("name");
        dice = mock(Dice.class);
    }

    @Test
    public void testShouldSetInitialCurrentPosition() {
        assertEquals(-1, player.getCurrentPosition());
    }

    @Test
    public void testShouldSetInitialWorth() {
        assertEquals(1000, player.getWorth());
    }

    @Test
    public void testShouldGiveNextRollValue() {
        when(dice.roll()).thenReturn(3);

        assertEquals(3, player.roll(dice));
    }

    @Test
    public void testMovePlayerToPosition() {
        int boardLength = 6;

        assertEquals(-1, player.getCurrentPosition());

        player.moveForward(3, boardLength);

        assertEquals(2, player.getCurrentPosition());
    }

    @Test
    public void testMovePlayerToPositionAfterRoundTrip() {
        int boardLength = 6;

        assertEquals(-1, player.getCurrentPosition());

        player.moveForward(3, boardLength);

        assertEquals(2, player.getCurrentPosition());

        player.moveForward(4, boardLength);

        assertEquals(0, player.getCurrentPosition());
    }

    @Test
    public void testShouldAddHotelToListOfOwnedHotels() {
        HotelCell hotelCell = mock(HotelCell.class);

        assertEquals(0, player.getOwnedHotelCells().size());

        player.buyHotel(hotelCell);

        assertEquals(1, player.getOwnedHotelCells().size());
    }

    @Test
    public void testShouldReturnTotalAsseetValue() {
        HotelCell hotelCell = mock(HotelCell.class);
        player.buyHotel(hotelCell);
        player.setWorth(2000);

        assertEquals(2200, player.getTotalAssetValue());
    }

}