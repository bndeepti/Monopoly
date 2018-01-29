package cell;

import transaction.Bank;
import logging.MonopolyLogger;
import model.Player;

import static transaction.TransactionType.DEBIT;

public class JailCell implements Cell {
    private final int fine;

    public JailCell(int fine) {
        this.fine = fine;
    }

    @Override
    public void handleTransaction(Player player, Bank bank) {
        String message = String.format("%s at Jail position %d paid fine of %d", player.getName(), (player.getCurrentPosition() + 1), fine);
        MonopolyLogger.LOGGER.info(message);

        bank.transactWithBank(player, fine, DEBIT);
    }
}
