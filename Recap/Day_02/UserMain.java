import java.util.Scanner;

class BankAccount{
	private String accoutNumber;
	private String accoutHolder;
	private double accountBalance;
	
	public BankAccount(String accoutNumber,String accoutHolder,double accountBalance){
		this.accoutNumber = accoutNumber;
		this.accoutHolder = accoutHolder;
		this.accountBalance = accountBalance;
		}
		
		//Getters
		public String getAccountNumber(){
			return accoutNumber;
			}
		public String getAccoutHolder(){
			return accoutHolder;
			}
		public double getBalance(){
			return accountBalance;
			}
			
		//Setters
		public void setAccountHolder(String accoutHolder){
			this.accoutHolder = accoutHolder;
			}
			
		//Deposit Method
		public void deposit(double amount){
			if (amount > 0){
				accountBalance += amount;
				System.out.println("Deposited: " + amount);
				}
			}
		
		//Withdrow
		public void withdraw(double amount){
			if (amount > 0 && amount <= accountBalance){
				accountBalance -= amount;
				System.out.println("Withdrown: " + amount);
				}else{
					System.out.println("Insufficient balance!");
					}
			}
			
		public void display(){
			System.out.println("Account: " + accoutNumber);
			System.out.println("Holder: " + accoutHolder);
			System.out.println("Balance: " + accountBalance);
			}
	}
	
	public class Main{
		public static void main(String args[]){
			Scanner str = new Scanner(System.in);
			
			//Enter account number
			System.out.println("Enter Account Number: ");
			String accoutNumber = str.next();
			
			//Account holder
			System.out.println("Enter Account Holder: ");
			str.nextLine();
			String accoutHolder = str.nextLine();
			
			//Enter Balances
			System.out.println("Enter Invalid Balance: ");
			double bal = str.nextLine();
			
			BankAccount acc = new BankAccount(accNo,hol,bal);
			
			System.out.print("Enter Widthdrow amount: ");
			double
			
			acc.deposit(5000);
			acc.withdraw(3000);
			
			acc.display();
			}
		} 
