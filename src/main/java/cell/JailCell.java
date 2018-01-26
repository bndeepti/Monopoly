package cell;

import model.Bank;
import model.Player;

import static model.TransactionType.DEBIT;

public class JailCell implements Cell {
    private final int fine;

    public JailCell(int fine) {
        this.fine = fine;
    }

    @Override
    public void handleTransaction(Player player, Bank bank) {
        bank.transact(player, fine, DEBIT);
    }

    public int getFine() {
        return fine;
    }
}
