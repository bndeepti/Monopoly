package cell;

import model.Bank;
import model.MonopolyLogger;
import model.Player;

public class EmptyCell implements Cell {
    @Override
    public void handleTransaction(Player player, Bank bank) {
        String message = String.format("%s is at Empty cell at position %d", player.getName(), (player.getCurrentPosition() + 1));
        MonopolyLogger.LOGGER.info(message);
    }
}
