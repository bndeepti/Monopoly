package model;

import cell.EmptyCell;
import cell.HotelCell;
import cell.JailCell;
import cell.TreasureCell;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BoardTest {
    Board board;

    @Before
    public void setUp() throws Exception {
        board = new Board();
    }

    @Test
    public void testShouldInitCellPositionsAndTypes() {
        String cellPositionsAndTypes = "E,J,T,H,E";
        board.init(cellPositionsAndTypes);

        assertEquals(EmptyCell.class, board.getCell(0).getClass());
        assertEquals(JailCell.class, board.getCell(1).getClass());
        assertEquals(TreasureCell.class, board.getCell(2).getClass());
        assertEquals(HotelCell.class, board.getCell(3).getClass());
        assertEquals(EmptyCell.class, board.getCell(4).getClass());
    }

}