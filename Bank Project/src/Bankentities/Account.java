package Bankentities;

import java.io.File;

public class Account {
	
	private Double balance = null;
	private String accountNumber= null;
	private static final File checkingtransactions = new File("C:\\Users\\CGada\\eclipse-workspace\\Bank Project\\src\\Bankentities\\checkingtransactions.txt");
	private static final File savingstransactions = new File("C:\\Users\\CGada\\eclipse-workspace\\Bank Project\\src\\Bankentities\\savingstransactions.txt");
	private boolean checkings = true;
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}
	
	public void addToAccount(Double amountToAdd) {
		this.balance += amountToAdd;
		if( checkings== true) {
			//write to checkingtransaction txt file
		} else {
			//write to savingstransaction txt file 
		}
			
		//write to txt file
	}
	
	
	public void removeFromAccount(Double amountToRemove) {
		this.balance -= amountToRemove;
		if( checkings== true) {
			//write to checkingtransaction txt file
		} else {
			//write to savingstransaction txt file 
		}
			
		//write to txt file
	}

	public void eftPayTo(String accNum, String roNum, String Name, Double amountToTransfer) {
		this.balance -= amountToTransfer;
		if(checkings== true) {
			// write to checkingtransaction txt file 
		}
		else {
			// write to savingtransaction txt file
		}
	}
	public boolean isCheckings() {
		return checkings;
	}

	public void setCheckings(boolean checkings) {
		this.checkings = checkings;
	}
	
	
	

}
