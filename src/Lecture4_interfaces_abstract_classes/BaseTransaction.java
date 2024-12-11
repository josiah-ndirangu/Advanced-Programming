package Lecture4_interfaces_abstract_classes;

import java.util.Calendar;

public abstract class BaseTransaction implements TransactionInterface {
    private final int amount;
    private final Calendar date;
    private final String transactionID;

    /**
     * Constructor for BaseTransaction.
     *
     * @param amount: the transaction amount.
     * @param date: the transaction date (NotNull, Calendar object).
     */
    public BaseTransaction(int amount, @NotNull Calendar date) {
        this.amount = amount;
        this.date = (Calendar) date.clone(); // Defensive copying
        int uniq = (int) (Math.random() * 10000);
        this.transactionID = date.toString() + uniq;
    }

    @Override
    public double getAmount() {
        return amount;
    }

    @Override
    public Calendar getDate() {
        return (Calendar) date.clone(); // Defensive copying to avoid modification outside.
    }

    @Override
    public String getTransactionID() {
        return transactionID;
    }

    // Abstract methods for subclass implementation
    public abstract void printTransactionDetails();
    public abstract void apply(BankAccount ba);
}
