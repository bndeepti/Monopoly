package model;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Number of Players : ");
        String numberOfPlayers = scanner.nextLine();

        System.out.println("\n" +
                "E → EMPTY \n" +
                "\n" +
                "J → JAIL\n" +
                "\n" +
                "T → TREASURE\n" +
                "\n" +
                "H → HOTEL\n");
        System.out.println("Cells Position and Type : ");
        String cellPositionsAndTypes = scanner.nextLine();

        System.out.println("Dice Output : ");
        String diceOutput = scanner.nextLine();

        InputStream inputStream = new Main().getClass().getResourceAsStream("/monopoly.properties");
        MonopolyProperties monopolyProperties = new MonopolyProperties(inputStream, new Properties());

        inputStream.close();

        new MonopolyLogger();
        Board board = new Board();
        Dice dice = new Dice();
        Bank bank = new Bank();

        Monopoly monopoly = new Monopoly(board, dice, bank, monopolyProperties);
        monopoly.init(numberOfPlayers, cellPositionsAndTypes, diceOutput);
        monopoly.startGame();
        monopoly.endGame();
        monopoly.printResult();
    }
}
