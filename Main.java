import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BankManager bankManager = new BankManager();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== JAVA BANK MANAGEMENT SYSTEM ===");
        
        while (true) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Transfer Funds");
            System.out.println("5. View All Accounts");
            System.out.println("6. Exit");
            System.out.print("Choose option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
            
            switch (choice) {
                case 1:
                    System.out.print("Enter account number: ");
                    String accNum = scanner.nextLine();
                    System.out.print("Enter account holder name: ");
                    String holder = scanner.nextLine();
                    System.out.print("Enter initial deposit: ");
                    double deposit = scanner.nextDouble();
                    bankManager.createAccount(accNum, holder, deposit);
                    break;
                    
                case 2:
                    System.out.print("Enter account number: ");
                    String depAccNum = scanner.nextLine();
                    BankAccount depAccount = bankManager.getAccount(depAccNum);
                    if (depAccount != null) {
                        System.out.print("Enter deposit amount: ");
                        double depAmount = scanner.nextDouble();
                        depAccount.deposit(depAmount);
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;
                    
                case 3:
                    System.out.print("Enter account number: ");
                    String withAccNum = scanner.nextLine();
                    BankAccount withAccount = bankManager.getAccount(withAccNum);
                    if (withAccount != null) {
                        System.out.print("Enter withdrawal amount: ");
                        double withAmount = scanner.nextDouble();
                        withAccount.withdraw(withAmount);
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;
                    
                case 4:
                    System.out.print("Enter your account number: ");
                    String fromAcc = scanner.nextLine();
                    System.out.print("Enter target account number: ");
                    String toAcc = scanner.nextLine();
                    BankAccount fromAccount = bankManager.getAccount(fromAcc);
                    BankAccount toAccount = bankManager.getAccount(toAcc);
                    
                    if (fromAccount != null && toAccount != null) {
                        System.out.print("Enter transfer amount: ");
                        double transferAmount = scanner.nextDouble();
                        fromAccount.transfer(toAccount, transferAmount);
                    } else {
                        System.out.println("One or both accounts not found!");
                    }
                    break;
                    
                case 5:
                    bankManager.displayAllAccounts();
                    break;
                    
                case 6:
                    System.out.println("Thank you for using Java Bank System!");
                    scanner.close();
                    return;
                    
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
