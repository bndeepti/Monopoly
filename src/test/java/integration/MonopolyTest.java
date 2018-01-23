package integration;

import model.Board;
import model.Dice;
import model.Monopoly;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MonopolyTest {
    @Test
    public void testShouldStartGame() {
        String numberOfPlayers = "3";
        String cellPositionsAndTypes = "E,E,J,H,E,T,J,T,E,E,H,J,T,H,E,E,J,H,E,T,J,T,E,E,H,J,T,H,J,E,E,J,H,E,T,J,T,E,E,H,J,T,E,H,E";
        String diceOutput = "4,4,4,6,7,8,5,11,10,12,2,3,5,6,7,8,5,11,10,12,2,3,5,6,7,8,5,11,10,12";

        Board board = new Board();
        Dice dice = new Dice();

        Monopoly monopoly = new Monopoly(board, dice);
        monopoly.init(numberOfPlayers, cellPositionsAndTypes, diceOutput);
        monopoly.startGame(dice);
        monopoly.endGame();

        assertEquals(1200, monopoly.getPlayer(0).getWorth());
        assertEquals(1200, monopoly.getPlayer(1).getWorth());
        assertEquals(1050, monopoly.getPlayer(2).getWorth());
    }
}
