package cell;

import model.Player;

public class JailCell implements Cell {
    private final int fine;

    public JailCell() {
        this.fine = 150;
    }

    @Override
    public void handleTransaction(Player player) {
        player.setWorth(player.getWorth() - fine);
    }

    public int getFine() {
        return fine;
    }
}
