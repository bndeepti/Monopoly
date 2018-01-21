package model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class MonopolyTest {
    @Test
    public void testShouldTakeInputsAndDelegateInitialization() {
        Board board = mock(Board.class);
        Dice dice = mock(Dice.class);
        Monopoly monopoly = new Monopoly(board, dice);

        String cellPositionsAndTypes = "";
        String diceOutput = "";
        monopoly.init(cellPositionsAndTypes, diceOutput);
        verify(board, times(1)).init(cellPositionsAndTypes);
        verify(dice, times(1)).init(diceOutput);
    }
}
