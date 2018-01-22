package model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class MonopolyTest {
    Monopoly monopoly;
    Board board;
    Dice dice;

    @Before
    public void setUp() {
        board = mock(Board.class);
        dice = mock(Dice.class);
        monopoly = new Monopoly(board, dice);
    }

    @Test
    public void testShouldTakeInputsAndDelegateInitialization() {
        String cellPositionsAndTypes = "";
        String diceOutput = "";
        String numberOfPlayers = "";
        monopoly.init(numberOfPlayers, cellPositionsAndTypes, diceOutput);
        verify(board, times(1)).init(cellPositionsAndTypes);
        verify(dice, times(1)).init(diceOutput);
    }

    @Test
    public void testShouldInitPlayers() {
        String numberOfPlayers = "2";
        String diceOutput = "";
        String cellPositionAndTypes = "";

        monopoly.init(numberOfPlayers, cellPositionAndTypes, diceOutput);

        assertEquals("Player-1", monopoly.getPlayer(0).getName());
        assertEquals("Player-2", monopoly.getPlayer(1).getName());
    }
}
