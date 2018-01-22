package model;

import java.util.ArrayList;
import java.util.List;

public class Monopoly {
    private Board board;
    private Dice dice;
    private List<Player> players = new ArrayList<>();;

    public Monopoly(Board board, Dice dice) {
        this.board = board;
        this.dice = dice;
    }

    public void init(String numberOfPlayers, String cellPositionsAndTypes, String diceOutput) {
        board.init("");
        dice.init("");
        initPlayers(Integer.valueOf(numberOfPlayers));
    }

    private void initPlayers(int numberOfPlayers) {
        for (int i = 1; i <= numberOfPlayers; i++)
            players.add(new Player("Player-" + i));
    }

    public Player getPlayer(int index) {
        return players.get(index);
    }

    public void startGame(List<Player> players, Dice dice) {
        players.forEach(player -> {
            player.moveForward(player.roll(dice), board.length());
        });
    }
}
