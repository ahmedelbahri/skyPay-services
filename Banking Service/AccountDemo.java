public class AccountDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Account Service Demo ===\n");
        
        Account account = new Account();
        
        System.out.println("Creating a new account...");
        System.out.println("Initial balance: " + account.getBalance() + "\n");
        
        System.out.println("Performing transactions:");
        System.out.println("1. Deposit: 1000");
        account.deposit(1000.0);
        
        System.out.println("2. Deposit: 2000");
        account.deposit(2000.0);
        
        System.out.println("3. Withdraw: 500");
        account.withdraw(500.0);
        
        System.out.println("\nCurrent balance: " + account.getBalance());
        
        System.out.println("\n=== Account Statement ===");
        account.printStatement();
        
        System.out.println("\n=== Testing Exception Handling ===");
        
        try {
            System.out.println("\nAttempting negative deposit...");
            account.deposit(-100.0);
        } catch (IllegalArgumentException e) {
            System.out.println("✓ Caught exception: " + e.getMessage());
        }
        
        try {
            System.out.println("\nAttempting withdrawal exceeding balance...");
            account.withdraw(10000.0);
        } catch (IllegalStateException e) {
            System.out.println("✓ Caught exception: " + e.getMessage());
        }
        
        System.out.println("\n=== Demo Complete ===");
    }
}
