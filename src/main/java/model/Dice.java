package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Dice {
    private List<String> rollValues = new ArrayList<>();

    public void init(String diceOutput) {
        rollValues = Arrays.asList(diceOutput.split(","));
    }

    public int getRollValue(int index) {
        return Integer.valueOf(rollValues.get(index));
    }
}
