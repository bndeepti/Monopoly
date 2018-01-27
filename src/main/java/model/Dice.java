package model;

import java.util.Arrays;
import java.util.List;

public class Dice {
    private List<String> rollValues;
    private int rollNumber;

    public void init(String diceOutput) {
        rollValues = Arrays.asList(diceOutput.split(","));
        rollNumber = 0;
    }

    public int getRollValue(int index) {
        return Integer.valueOf(rollValues.get(index));
    }

    public int roll() {
        return getRollValue(rollNumber++ % rollValues.size());
    }

    public int totalRolls() {
        return rollValues.size();
    }
}
