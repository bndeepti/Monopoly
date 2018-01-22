package cell;

import model.Player;

public class TreasureCell implements Cell {
    private int value;

    public TreasureCell() {
        this.value = 200;
    }

    @Override
    public void handleTransaction(Player player) {
        player.setWorth(player.getWorth() + value);
    }

    public int getValue() {
        return value;
    }
}
