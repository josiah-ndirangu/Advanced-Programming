package Lecture4_interfaces_abstract_classes;

import java.util.Calendar;

public class WithdrawalTransaction extends BaseTransaction {

    public WithdrawalTransaction(int amount, @NotNull Calendar date) {
        super(amount, date);
    }

    @SuppressWarnings("unused")
    private boolean checkWithdrawAmount(int amt) {
        return amt >= 0;
    }

    @Override
    public void printTransactionDetails() {
        System.out.println("Withdrawal Transaction: " + this.toString());
    }

    @Override
    public void apply(BankAccount ba) {
        double currentBalance = ba.getBalance();
        if (currentBalance >= getAmount()) {
            double newBalance = currentBalance - getAmount();
            ba.setBalance(newBalance);
        } else {
            System.out.println("Insufficient funds for withdrawal.");
        }
    }

    // Method to reverse the withdrawal transaction
    public boolean reverse(BankAccount ba) {
        double originalBalance = ba.getBalance() + getAmount(); // Restore original balance
        ba.setBalance(originalBalance);
        return true;
    }
}
