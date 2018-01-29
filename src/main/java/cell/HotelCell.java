package cell;

import transaction.Bank;
import logging.MonopolyLogger;
import model.Player;

public class HotelCell implements Cell {
    private int cost;
    private int rent;
    private Player owner;

    public HotelCell(int cost, int rent) {
        this.cost = cost;
        this.rent = rent;
    }

    @Override
    public void handleTransaction(Player player, Bank bank) {
        String message;
        if (owner == null) {
            message = String.format("%s bought Hotel at position %d for cost %d", player.getName(), (player.getCurrentPosition() + 1), cost);
            player.buyHotel(this, cost);
            sell(player);
        } else {
            message = String.format("%s rented Hotel at position %d for rent %d", player.getName(), (player.getCurrentPosition() + 1), rent);
            player.payRent(rent, owner);
        }
        MonopolyLogger.LOGGER.info(message);
    }

    public Player getOwner() {
        return owner;
    }

    public void sell(Player owner) {
        this.owner = owner;
    }
}
