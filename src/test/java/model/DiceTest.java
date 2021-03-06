package model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DiceTest {
    Dice dice;
    @Before
    public void setUp() throws Exception {
        dice = new Dice();
    }

    @Test
    public void testShouldGiveNextRollValue() {
        String diceOutput = "4,5,6";

        dice.init(diceOutput);

        assertEquals(4, dice.roll());
        assertEquals(5, dice.roll());
        assertEquals(6, dice.roll());
    }

    @Test
    public void testShouldReturnTotalRolls() {
        String diceOutput = "4,5,6";

        dice.init(diceOutput);

        assertEquals(3, dice.totalRolls());
    }

}