import java.util.*;

public class BankManager {
    private Map<String, BankAccount> accounts;
    
    public BankManager() {
        this.accounts = new HashMap<>();
    }
    
    public void createAccount(String accountNumber, String accountHolder, double initialDeposit) {
        if (!accounts.containsKey(accountNumber)) {
            BankAccount newAccount = new BankAccount(accountNumber, accountHolder, initialDeposit);
            accounts.put(accountNumber, newAccount);
            System.out.println("Account created successfully for: " + accountHolder);
        } else {
            System.out.println("Account number already exists!");
        }
    }
    
    public BankAccount getAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }
    
    public void displayAllAccounts() {
        System.out.println("\n=== ALL BANK ACCOUNTS ===");
        if (accounts.isEmpty()) {
            System.out.println("No accounts found.");
        } else {
            for (BankAccount account : accounts.values()) {
                System.out.println(account);
            }
        }
    }
    
    public void deleteAccount(String accountNumber) {
        if (accounts.containsKey(accountNumber)) {
            BankAccount removed = accounts.remove(accountNumber);
            System.out.println("Account deleted: " + removed.getAccountHolder());
        } else {
            System.out.println("Account not found!");
        }
    }
}
