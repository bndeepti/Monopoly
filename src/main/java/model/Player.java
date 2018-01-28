package model;

import cell.Cell;
import cell.HotelCell;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private final String name;
    private int currentPosition;
    private int worth;
    private List<Cell> ownedHotelCells = new ArrayList<>();

    public Player(String name, int worth) {
        this.name = name;
        this.currentPosition = -1;
        this.worth = worth;
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

    public List<Cell> getOwnedHotelCells() {
        return ownedHotelCells;
    }

    public void buyHotel(HotelCell hotelCell) {
        ownedHotelCells.add(hotelCell);
    }

    public int getTotalHotels() {
        return  getOwnedHotelCells().size();
    }

    public void updateWorth(int amount, TransactionType transactionType) {
        if (transactionType == TransactionType.DEBIT) {
            worth -= amount;
        } else if (transactionType == TransactionType.CREDIT) {
            worth += amount;
        }
    }
}
