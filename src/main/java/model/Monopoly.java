package model;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Monopoly {
    private MonopolyProperties monopolyProperties;
    private Board board;
    private Dice dice;
    private Bank bank;
    private List<Player> players = new ArrayList<>();

    public Monopoly(Board board, Dice dice, Bank bank, MonopolyProperties monopolyProperties) {
        this.board = board;
        this.dice = dice;
        this.bank = bank;
        this.monopolyProperties = monopolyProperties;
    }

    public void init(String numberOfPlayers, String cellPositionsAndTypes, String diceOutput) throws IOException {
        board.init(cellPositionsAndTypes, monopolyProperties);
        dice.init(diceOutput);

        int initialWorth = Integer.parseInt(monopolyProperties.getProperty("player.worth"));
        initPlayers(Integer.valueOf(numberOfPlayers), initialWorth);
    }

    private void initPlayers(int numberOfPlayers, int initialWorth) {
        for (int i = 1; i <= numberOfPlayers; i++)
            players.add(new Player("Player-" + i, initialWorth));
    }

    public Player getPlayer(int index) {
        return players.get(index);
    }

    public void startGame(Dice dice) {
        for(int i = 0; i < 10; i++) {
            players.forEach(player -> {
                player.moveForward(player.roll(dice), board.length());
                board.getCell(player.getCurrentPosition()).handleTransaction(player, bank);
            });
        }
    }

    public void endGame() {
        players.forEach(player -> player.getTotalAssetValue());
    }
}
