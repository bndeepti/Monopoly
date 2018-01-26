package cell;

import model.Bank;
import model.Player;

public interface Cell {
    void handleTransaction(Player player, Bank bank);
}
