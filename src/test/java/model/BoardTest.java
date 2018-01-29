package model;

import cell.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BoardTest {
    Board board;
    MonopolyProperties monopolyProperties;
    CellFactory cellFactory;

    @Before
    public void setUp() throws Exception {
        String cellPositionsAndTypes = "E,J,T,H,E";
        monopolyProperties = mock(MonopolyProperties.class);
        cellFactory = mock(CellFactory.class);
        board = new Board(cellFactory);
        when(monopolyProperties.getProperty("jail.fine")).thenReturn("150");
        when(monopolyProperties.getProperty("treasure.value")).thenReturn("200");
        when(monopolyProperties.getProperty("hotel.cost")).thenReturn("200");
        when(monopolyProperties.getProperty("hotel.rent")).thenReturn("50");

        when(cellFactory.createCell("E", monopolyProperties)).thenReturn(new EmptyCell());
        when(cellFactory.createCell("J", monopolyProperties)).thenReturn(new JailCell(150));
        when(cellFactory.createCell("T", monopolyProperties)).thenReturn(new TreasureCell(200));
        when(cellFactory.createCell("H", monopolyProperties)).thenReturn(new HotelCell(200, 50));

        board.init(cellPositionsAndTypes, monopolyProperties);
    }

    @Test
    public void testShouldInitCellPositionsAndTypes() {
        assertEquals(EmptyCell.class, board.getCell(0).getClass());
        assertEquals(JailCell.class, board.getCell(1).getClass());
        assertEquals(TreasureCell.class, board.getCell(2).getClass());
        assertEquals(HotelCell.class, board.getCell(3).getClass());
        assertEquals(EmptyCell.class, board.getCell(4).getClass());
    }

    @Test
    public void testShouldReturnBoardLength() {
        assertEquals(5, board.length());
    }
}