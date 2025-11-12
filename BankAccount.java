public class BankAccount {
    private String accountNumber;
    private String accountHolder;
    private double balance;
    
    public BankAccount(String accountNumber, String accountHolder, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
    }
    
    // Getters and Setters
    public String getAccountNumber() { return accountNumber; }
    public String getAccountHolder() { return accountHolder; }
    public double getBalance() { return balance; }
    
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }
    
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrew: $" + amount);
        } else {
            System.out.println("Insufficient funds or invalid amount!");
        }
    }
    
    public void transfer(BankAccount targetAccount, double amount) {
        if (amount > 0 && this.balance >= amount) {
            this.balance -= amount;
            targetAccount.balance += amount;
            System.out.println("Transfer successful: $" + amount + " to " + targetAccount.getAccountHolder());
        } else {
            System.out.println("Transfer failed: Insufficient funds!");
        }
    }
    
    @Override
    public String toString() {
        return "Account: " + accountNumber + " | Holder: " + accountHolder + " | Balance: $" + balance;
    }
}
