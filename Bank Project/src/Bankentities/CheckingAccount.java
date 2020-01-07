package Bankentities;

public class CheckingAccount extends Account {

	private boolean optIn = true;

	public boolean isOptIn() {
		return optIn;
	}

	public void setOptIn(boolean optIn) {
		this.optIn = optIn;
	} 
	public CheckingAccount() {
		
	}
	
	public CheckingAccount(String accountNumber, double balance) {
		setAccountNumber(accountNumber);
		setBalance(balance);
	}
}
