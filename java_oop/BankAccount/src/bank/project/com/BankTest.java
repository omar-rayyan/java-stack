package bank.project.com;

public class BankTest {

	public static void main(String[] args) {
		BankAccount omarAcc = new BankAccount();
		
		omarAcc.deposit(200, "checking");
		omarAcc.deposit(500, "savings");
		omarAcc.getBalance();
		
		omarAcc.withdraw(1000, "savings");
		omarAcc.withdraw(100, "checking");
		omarAcc.getBalance();
	}

}
