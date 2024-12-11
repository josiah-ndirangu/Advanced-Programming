package Lecture4_interfaces_abstract_classes;

import java.util.Calendar;

public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000.00); // Initial balance of 1000

        // Create and apply a deposit transaction
        Calendar depositDate = Calendar.getInstance();
        DepositTransaction deposit = new DepositTransaction(200, depositDate);
        deposit.printTransactionDetails();
        deposit.apply(account);
        System.out.println("Balance after deposit: " + account.getBalance());

        // Create and apply a withdrawal transaction
        Calendar withdrawalDate = Calendar.getInstance();
        WithdrawalTransaction withdrawal = new WithdrawalTransaction(150, withdrawalDate);
        withdrawal.printTransactionDetails();
        withdrawal.apply(account);
        System.out.println("Balance after withdrawal: " + account.getBalance());

        // Try to reverse the withdrawal transaction
        withdrawal.reverse(account);
        System.out.println("Balance after reversal: " + account.getBalance());

        // Test insufficient funds scenario
        WithdrawalTransaction withdrawal2 = new WithdrawalTransaction(2000, withdrawalDate);
        withdrawal2.apply(account); // This should fail due to insufficient funds
    }
}

