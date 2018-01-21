package model;

public class Monopoly {
    private Board board;
    private Dice dice;

    public Monopoly(Board board, Dice dice) {
        this.board = board;
        this.dice = dice;
    }

    public void init(String cellPositionsAndTypes, String diceOutput) {
        board.init("");
        dice.init("");
    }
}
