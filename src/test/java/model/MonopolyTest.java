package model;

import cell.Cell;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

public class MonopolyTest {
    Monopoly monopoly;
    Board board;
    Dice dice;
    Bank bank;

    @Before
    public void setUp() {
        board = mock(Board.class);
        dice = mock(Dice.class);
        bank =  mock(Bank.class);
        monopoly = new Monopoly(board, dice, bank);
    }

    @Test
    public void testShouldTakeInputsAndDelegateInitialization() {
        String cellPositionsAndTypes = "";
        String diceOutput = "";
        String numberOfPlayers = "2";
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
