package cell;

import model.Player;

public class HotelCell implements Cell {
    private int cost;
    private int rent;
    private boolean owned;
    private Player owner;

    public HotelCell() {
        this.cost = 200;
        this.rent = 50;
    }

    @Override
    public void handleTransaction(Player player) {
        if (!owned) {
            player.setWorth(player.getWorth() - cost);
            player.buyHotel(this);
            this.owned = true;
            this.owner = player;
        } else {
            player.setWorth(player.getWorth() - rent);
            owner.setWorth(owner.getWorth() + rent);
        }
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
