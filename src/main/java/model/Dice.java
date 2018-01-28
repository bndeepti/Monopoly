package model;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Dice {
    private List<String> rollValues;
    private Iterator<String> iterator;

    public void init(String diceOutput) {
        rollValues = Arrays.asList(diceOutput.split(","));
        iterator = rollValues.iterator();
    }

    public int roll() {
        return Integer.parseInt(iterator.next());
    }

    public int totalRolls() {
        return rollValues.size();
    }
}
