package model;

public class Player {
    private final String name;
    private int currentPosition;
    private int worth;

    public Player(String name) {
        this.name = name;
        this.currentPosition = -1;
        this.worth = 1000;
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

    public int getWorth() {
        return worth;
    }

    public void setWorth(int worth) {
        this.worth = worth;
    }
}
