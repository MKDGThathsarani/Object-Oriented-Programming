class BankAccount{
	private String accoutNumber;
	private String accoutHolder;
	private double balance;
	
	public BankAccount(String accoutNumber,String accoutHolder,double balance){
		this.accoutNumber = accoutNumber;
		this.accoutHolder = accoutHolder;
		this.balance = balance;
		}
		
		//Getters
		public String getAccountNumber(){
			return accoutNumber;
			}
		public String getAccoutHolder(){
			return accoutHolder;
			}
		public double getBalance(){
			return balance;
			}
			
		//Setters
		public void setAccountHolder(String accoutHolder){
			this.accoutHolder = accoutHolder;
			}
			
		//Deposit Method
		public void deposit(double amount){
			if (amount > 0){
				balance += amount;
				System.out.println("Deposited: " + amount);
				}
			}
		
		//Withdrow
		public void withdraw(double amount){
			if (amount > 0 && amount <= balance){
				balance -= amount;
				System.out.println("Withdrown: " + amount);
				}else{
					System.out.println("Insufficient balance!");
					}
			}
			
		public void display(){
			System.out.println("Account: " + accountNumber);
			System.out.println("Holder: " + accoutHolder);
			System.out.println("Balance: " + balance);
			}
	}
	
	public class Main{
		public static void main(String args[]){
			BankAccount acc = new BankAccount("ACC001","Kmal",100000);
			
			System.out.println();
			}
		} 
