package cell;

import transaction.Bank;
import model.Player;

public interface Cell {
    void handleTransaction(Player player, Bank bank);
}
