package cell;

import monopoly.MonopolyProperties;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CellFactoryTest {
    CellFactory cellFactory;
    MonopolyProperties monopolyProperties;
    @Before
    public void setUp() throws Exception {
        cellFactory = new CellFactory();
        monopolyProperties = mock(MonopolyProperties.class);

        when(monopolyProperties.getProperty("jail.fine")).thenReturn("150");
        when(monopolyProperties.getProperty("treasure.value")).thenReturn("200");
        when(monopolyProperties.getProperty("hotel.cost")).thenReturn("200");
        when(monopolyProperties.getProperty("hotel.rent")).thenReturn("50");
    }

    @Test
    public void testShouldReturnEmptyCell() {
        assertEquals(EmptyCell.class, cellFactory.createCell("E", monopolyProperties).getClass());
    }

    @Test
    public void testShouldReturnHotelCell() {
        assertEquals(HotelCell.class, cellFactory.createCell("H", monopolyProperties).getClass());
    }

    @Test
    public void testShouldReturnJailCell() {
        assertEquals(JailCell.class, cellFactory.createCell("J", monopolyProperties).getClass());
    }

    @Test
    public void testShouldReturnTreasureCell() {
        assertEquals(TreasureCell.class, cellFactory.createCell("T", monopolyProperties).getClass());
    }

}