package bank;

public class BankAccount {
    private String accountNumber;
    private double balance;
    
    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    
    public void display() {
        System.out.println("Account: " + accountNumber + ", Balance: " + balance);
    }
}
