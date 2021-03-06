package model;

import cell.Cell;
import cell.HotelCell;
import transaction.TransactionType;

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

    public void buyHotel(HotelCell hotelCell, int cost) {
        ownedHotelCells.add(hotelCell);
        updateWorth(cost, TransactionType.DEBIT);
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

    public void payRent(int rent, Player owner) {
        updateWorth(rent, TransactionType.DEBIT);
        owner.updateWorth(rent, TransactionType.CREDIT);
    }
}
