package utility;

import exceptions.InsufficientFundsException;

public class AccountUtils {
    public static final String BANK_NAME = "Campus Bank";
    private static int accountCount;
    private final String accountNumber;
    private double balance;

    public AccountUtils(String accountNumber, double openingBalance) {
        if (openingBalance < 0) throw new IllegalArgumentException("Opening balance cannot be negative");
        this.accountNumber = accountNumber;
        this.balance = openingBalance;
        accountCount++;
    }

    public static int getAccountCount() { return accountCount; }
    public double getBalance() { return balance; }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount <= 0) throw new IllegalArgumentException("Withdrawal must be positive");
        if (amount > balance) throw new InsufficientFundsException("Insufficient funds for withdrawal of " + amount);
        balance -= amount;
        System.out.println("Withdrawal successful from " + accountNumber + ": " + amount);
    }
}
