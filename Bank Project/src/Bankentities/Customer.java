package Bankentities;

public class Customer {
	private String password = null;
	private CheckingAccount checkingAccount = new CheckingAccount();
	private SavingAccount savingAccount = new SavingAccount();
	private String firstName = null;
	private String lastName = null;
	private String email = null;
	private String phone = null;

	
	
	
	private String routingNumber= null;

	
	
	public Customer(String firstName, String lastName, String email, String phone, String password) {
		super();
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
	}
	
	public Customer(String firstName, String lastName, String email, String phone, String password, String cAN, String sAn) {
		super();
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.checkingAccount.setAccountNumber(cAN);
		this.savingAccount.setAccountNumber(sAn);
	}
	
	public Customer() {
		
	}
	
	
	public CheckingAccount getCheckingAccount() {
		return checkingAccount;
	}

	public void setCheckingAccount(CheckingAccount checkingAccount) {
		this.checkingAccount = checkingAccount;
	}

	public SavingAccount getSavingAccount() {
		return savingAccount;
	}

	public void setSavingAccount(SavingAccount savingAccount) {
		this.savingAccount = savingAccount;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRoutingNumber() {
		return routingNumber;
	}

	public void setRoutingNumber(String routingNumber) {
		this.routingNumber = routingNumber;
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	

}
