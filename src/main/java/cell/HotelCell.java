package cell;

import model.Player;

public class HotelCell implements Cell {
    private int cost;
    private int rent;

    public HotelCell() {
        this.cost = 200;
        this.rent = 50;
    }

    @Override
    public void handleTransaction(Player player) {

    }

    public int getCost() {
        return cost;
    }

    public int getRent() {
        return rent;
    }
}
