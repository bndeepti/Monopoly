package cell;

import model.Bank;
import model.MonopolyLogger;
import model.Player;

import static model.TransactionType.CREDIT;

public class TreasureCell implements Cell {
    private int value;

    public TreasureCell(int value) {
        this.value = value;
    }

    @Override
    public void handleTransaction(Player player, Bank bank) {
        String message = String.format("%s at Treasure position %d got value of %d", player.getName(), (player.getCurrentPosition() + 1), value);
        MonopolyLogger.LOGGER.info(message);

        bank.transactWithBank(player, value, CREDIT);
    }
}
