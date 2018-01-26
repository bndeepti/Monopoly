package model;

public class Bank {
    public void transact(Player player, int amount, TransactionType transactionType) {
        player.updateWorth(amount, transactionType);
    }
}
