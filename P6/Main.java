import exceptions.InsufficientFundsException;
import utility.AccountUtils;

public class Main {
    private static final double MINIMUM_BALANCE = 500.0;

    public static void main(String[] args) {
        System.out.println("P6 - Static, final, packages, and exceptions");
        AccountUtils account = new AccountUtils("AC-101", 2000.0);
        System.out.println("Bank: " + AccountUtils.BANK_NAME + " | Accounts created: " + AccountUtils.getAccountCount());
        System.out.println("Minimum balance: " + MINIMUM_BALANCE);
        try {
            account.withdraw(800.0);
            account.withdraw(1500.0);
        } catch (InsufficientFundsException e) {
            System.out.println("Domain error: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid input: " + e.getMessage());
        } finally {
            System.out.printf("Final balance: %.2f%n", account.getBalance());
        }
    }
}
