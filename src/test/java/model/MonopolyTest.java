package model;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Properties;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class MonopolyTest {
    Monopoly monopoly;
    Board board;
    Dice dice;
    Bank bank;
    MonopolyProperties monopolyProperties;

    @Before
    public void setUp() {
        board = mock(Board.class);
        dice = mock(Dice.class);
        bank =  mock(Bank.class);
        monopolyProperties = mock(MonopolyProperties.class);

        when(monopolyProperties.getProperty("player.worth")).thenReturn("1000");
        monopoly = new Monopoly(board, dice, bank, monopolyProperties);
    }

    @Test
    public void testShouldTakeInputsAndDelegateInitialization() throws IOException {
        String cellPositionsAndTypes = "";
        String diceOutput = "";
        String numberOfPlayers = "2";
        monopoly.init(numberOfPlayers, cellPositionsAndTypes, diceOutput);
        verify(board, times(1)).init(cellPositionsAndTypes, monopolyProperties);
        verify(dice, times(1)).init(diceOutput);
    }

    @Test
    public void testShouldInitPlayers() throws IOException {
        String numberOfPlayers = "2";
        String diceOutput = "";
        String cellPositionAndTypes = "";

        monopoly.init(numberOfPlayers, cellPositionAndTypes, diceOutput);

        assertEquals("Player-1", monopoly.getPlayer(0).getName());
        assertEquals("Player-2", monopoly.getPlayer(1).getName());
    }
}
