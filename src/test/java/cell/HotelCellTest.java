package cell;

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

}