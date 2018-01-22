package model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DiceTest {
    Dice dice;
    @Before
    public void setUp() throws Exception {
        dice = new Dice();
    }

    @Test
    public void testShouldInitRollValues() {
        String diceOutput = "4,5,6";

        dice.init(diceOutput);

        assertEquals(4, dice.getRollValue(0));
        assertEquals(5, dice.getRollValue(1));
        assertEquals(6, dice.getRollValue(2));
    }

    @Test
    public void testShouldGiveNextRollValue() {
        String diceOutput = "4,5,6";

        dice.init(diceOutput);

        assertEquals(4, dice.roll());
        assertEquals(5, dice.roll());
        assertEquals(6, dice.roll());
    }

}