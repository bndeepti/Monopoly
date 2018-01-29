package model;

public class Bank {
    private int balance;

    public void transact(Player player, int amount, TransactionType transactionType) {
        player.updateWorth(amount, transactionType);
    }

    public void transactWithBank(Player player, int amount, TransactionType transactionType) {
        player.updateWorth(amount, transactionType);
        balance = transactionType == TransactionType.CREDIT ? balance - amount : balance + amount;
    }

    public int getBalance() {
        return balance;
    }
}
