// Custom Exception
class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

class BankAccount {
    private double balance;
    
    public BankAccount(double balance) {
        this.balance = balance;
    }
    
    // throws - method එකෙන් error යවනවා
    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > balance) {
            throw new InsufficientBalanceException("Balance එකට වඩා වැඩියි!");
        }
        balance -= amount;
        System.out.println("Withdrawn: " + amount);
    }
    
    public double getBalance() {
        return balance;
    }
}

public class Main {
    public static void main(String[] args) {
        BankAccount acc = new BankAccount(10000);
        
        try {
            acc.withdraw(5000);   // ✅ OK
            acc.withdraw(8000);   // ❌ Error!
        } catch (InsufficientBalanceException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Balance: " + acc.getBalance());
        }
    }
}
