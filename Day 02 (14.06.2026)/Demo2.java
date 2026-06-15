class Account{
	int balance;
	Account(int balance){this.balance=balance;}
	public void displayBalance(){
		System.out.println("Balance : "+balance);
	}
}
class AccountController{
	public static void withdraw(int amount, Account c1){
		c1.balance-=amount;
	}
}
class Demo2{
	public static void main(String args[]){
		Account c1=new Account(100000);
		c1.displayBalance();
		
		AccountController.withdraw(5000, c1);
		c1.displayBalance();
	}
}
