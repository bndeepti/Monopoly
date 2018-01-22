package model;

public class Player {
    private final String name;
    private int currentPosition;

    public Player(String name) {
        this.name = name;
        this.currentPosition = -1;
    }

    public String getName() {
        return name;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public int roll(Dice dice) {
        return dice.roll();
    }

    public void moveForward(int rollValue, int boardLength) {
        currentPosition = (currentPosition + rollValue) % boardLength;
    }
}
