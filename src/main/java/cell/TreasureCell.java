package cell;

import model.Bank;
import model.Player;

import static model.TransactionType.CREDIT;

public class TreasureCell implements Cell {
    private int value;

    public TreasureCell() {
        this.value = 200;
    }

    @Override
    public void handleTransaction(Player player, Bank bank) {
        bank.transact(player, value, CREDIT);
    }

    public int getValue() {
        return value;
    }
}
