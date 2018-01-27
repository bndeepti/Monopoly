package cell;

import model.Bank;
import model.MonopolyLogger;
import model.Player;
import model.TransactionType;

public class HotelCell implements Cell {
    private int cost;
    private int rent;
    private boolean owned;
    private Player owner;

    public HotelCell(int cost, int rent) {
        this.cost = cost;
        this.rent = rent;
    }

    @Override
    public void handleTransaction(Player player, Bank bank) {
        String message;
        if (!owned) {
            message = String.format("%s bought Hotel at position %d for cost %d", player.getName(), (player.getCurrentPosition() + 1), cost);
            player.updateWorth(cost, TransactionType.DEBIT);
            player.buyHotel(this);
            this.owned = true;
            this.owner = player;
        } else {
            message = String.format("%s rented Hotel at position %d for rent %d", player.getName(), (player.getCurrentPosition() + 1), rent);
            player.updateWorth(rent, TransactionType.DEBIT);
            owner.updateWorth(rent, TransactionType.CREDIT);
        }
        MonopolyLogger.LOGGER.info(message);
    }

    public int getCost() {
        return cost;
    }

    public int getRent() {
        return rent;
    }

    public void setOwned(boolean owned) {
        this.owned = owned;
    }

    public boolean isOwned() {
        return owned;
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }
}
