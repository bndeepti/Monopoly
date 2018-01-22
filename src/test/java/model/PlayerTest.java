package model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PlayerTest {
    Player player;
    Dice dice;

    @Before
    public void setUp() throws Exception {
        dice = mock(Dice.class);
    }

    @Test
    public void testShouldSetInitialCurrentPosition() {
        player = new Player("name");

        assertEquals(-1, player.getCurrentPosition());
    }

    @Test
    public void testShouldGiveNextRollValue() {
        player = new Player("name");
        when(dice.roll()).thenReturn(3);

        assertEquals(3, player.roll(dice));
    }

    @Test
    public void testMovePlayerToPosition() {
        int boardLength = 6;
        player = new Player("player1");

        assertEquals(-1, player.getCurrentPosition());

        player.moveForward(3, boardLength);

        assertEquals(2, player.getCurrentPosition());
    }

    @Test
    public void testMovePlayerToPositionAfterRoundTrip() {
        int boardLength = 6;
        player = new Player("player1");

        assertEquals(-1, player.getCurrentPosition());

        player.moveForward(3, boardLength);

        assertEquals(2, player.getCurrentPosition());

        player.moveForward(4, boardLength);

        assertEquals(0, player.getCurrentPosition());
    }

}