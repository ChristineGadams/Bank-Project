package Bankentities;

public class SavingAccount extends Account{

	public SavingAccount() {
		super();
		// TODO Auto-generated constructor stub
		setCheckings(false);
	
	}
	public SavingAccount(String accountNumber, double balance) {
		setAccountNumber(accountNumber);
		setBalance(balance);
	}
}
