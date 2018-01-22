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

    @Test
    public void testShouldStartGame() {
        String cellPositionsAndTypes = "E,J,T,H,E,H,T";
        board.init(cellPositionsAndTypes);

        List<Player> players = new ArrayList<>();
        Player player = mock(Player.class);
        players.add(player);
        when(player.getCurrentPosition()).thenReturn(1);

        Dice dice = mock(Dice.class);
        when(player.roll(dice)).thenReturn(4);

        when(board.length()).thenReturn(7);
        Cell cell = mock(Cell.class);
        when(board.getCell(1)).thenReturn(cell);

        monopoly.startGame(players, dice);

        verify(player, times(1)).moveForward(4, cellPositionsAndTypes.split(",").length);
        verify(cell, times(1)).handleTransaction(player);
    }
}
