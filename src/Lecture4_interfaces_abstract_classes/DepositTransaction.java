
package Lecture4_interfaces_abstract_classes;

import java.util.Calendar;

public class DepositTransaction extends BaseTransaction {

    public DepositTransaction(int amount, @NotNull Calendar date) {
        super(amount, date);
    }

    @SuppressWarnings("unused")
    private boolean checkDepositAmount(int amt) {
        return amt >= 0;
    }

    @Override
    public void printTransactionDetails() {
        System.out.println("Deposit Transaction: " + this.toString());
    }

    @Override
    public void apply(BankAccount ba) {
        double currentBalance = ba.getBalance();
        double newBalance = currentBalance + getAmount();
        ba.setBalance(newBalance);
    }
}

