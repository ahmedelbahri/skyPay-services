import java.util.ArrayList;
import java.util.Collections;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Account implements AccountService {
    private int balance;
    private final ArrayList<Transaction> transactions;
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    
    public Account() {
        this.balance = 0;
        this.transactions = new ArrayList<>();
    }
    
    @Override
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }
        
        int amountInCents = (int) (amount * 100);
        balance += amountInCents;
        transactions.add(new Transaction(new Date(), amountInCents, balance));
    }
    
    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive");
        }
        
        int amountInCents = (int) (amount * 100);
        
        if (balance < amountInCents) {
            throw new IllegalStateException("Insufficient funds");
        }
        
        balance -= amountInCents;
        transactions.add(new Transaction(new Date(), -amountInCents, balance));
    }
    
    @Override
    public void printStatement() {
        if (transactions.isEmpty()) {
            System.out.println("Date || Amount || Balance");
            return;
        }
        
        int maxDateWidth = "Date".length();
        int maxAmountWidth = "Amount".length();
        int maxBalanceWidth = "Balance".length();
        
        for (Transaction t : transactions) {
            String date = dateFormat.format(t.getDate());
            String amount = formatAmount(t.getAmount());
            String balance = formatAmount(t.getBalance());
            
            maxDateWidth = Math.max(maxDateWidth, date.length());
            maxAmountWidth = Math.max(maxAmountWidth, amount.length());
            maxBalanceWidth = Math.max(maxBalanceWidth, balance.length());
        }
        
        System.out.println(String.format("%-" + maxDateWidth + "s || %-" + maxAmountWidth + "s || %-" + maxBalanceWidth + "s", 
            "Date", "Amount", "Balance"));
        
        for (int i = transactions.size() - 1; i >= 0; i--) {
            Transaction t = transactions.get(i);
            System.out.println(formatTransaction(t, maxDateWidth, maxAmountWidth, maxBalanceWidth));
        }
    }
    
    private String formatTransaction(Transaction t, int dateWidth, int amountWidth, int balanceWidth) {
        String date = dateFormat.format(t.getDate());
        String amount = formatAmount(t.getAmount());
        String balance = formatAmount(t.getBalance());
        
        return String.format("%-" + dateWidth + "s || %-" + amountWidth + "s || %-" + balanceWidth + "s", 
            date, amount, balance);
    }
    
    private String formatAmount(int amountInCents) {
        return String.valueOf(amountInCents / 100);
    }
    
    public int getBalance() {
        return balance / 100;
    }
    
    private static class Transaction {
        private final Date date;
        private final int amount;
        private final int balance;
        
        public Transaction(Date date, int amount, int balance) {
            this.date = date;
            this.amount = amount;
            this.balance = balance;
        }
        
        public Date getDate() {
            return date;
        }
        
        public int getAmount() {
            return amount;
        }
        
        public int getBalance() {
            return balance;
        }
    }
}
