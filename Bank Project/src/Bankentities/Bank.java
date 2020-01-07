package Bankentities;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.time.LocalDate;

public class Bank {
	private ArrayList <Customer> customerList= new ArrayList <Customer>();
	private Customer loggedInCustomer = new Customer();
	private static final File cFile = new File("C:\\Users\\CGada\\eclipse-workspace\\Bank Project\\src\\Bankentities\\cFile.txt");
	private static final File checkingtransactions = new File("C:\\Users\\CGada\\eclipse-workspace\\Bank Project\\src\\Bankentities\\checkingtransactions.txt");
	private static final File savingstransactions = new File("C:\\Users\\CGada\\eclipse-workspace\\Bank Project\\src\\Bankentities\\savingstransactions.txt");
	private static final File accountsFile = new File("C:\\Users\\CGada\\eclipse-workspace\\Bank Project\\src\\Bankentities\\accounts.txt");
	private ArrayList <String> accountNumbers = new ArrayList <String>();
	private ArrayList <Transaction> transactionList = new ArrayList <Transaction>();
	
	
//	public static void main(String[] args) throws IOException {
//		//writeToTxtFiles("Best Buy", "300.00", "Purchase", "12/31/2019", true);
//	}
	public void createAccount (Customer customer) {
		// save to file Customer customer
		// 
	}
	
	public void deposit (String deposit, boolean checkings) throws IOException {
		Double depositAmount = Double.parseDouble(deposit);
		String date = LocalDate.now().toString();
		if(checkings == true) {
			loggedInCustomer.getCheckingAccount().addToAccount(depositAmount);
			writeToTxtFiles(loggedInCustomer.getCheckingAccount().getAccountNumber(), "Work Place", deposit, "deposit", date, checkings);
			writeToaccountsTxtFile(loggedInCustomer.getCheckingAccount().getAccountNumber(), loggedInCustomer.getCheckingAccount().getBalance().toString());
		}
		else {
			loggedInCustomer.getSavingAccount().addToAccount(depositAmount);
			writeToTxtFiles(loggedInCustomer.getSavingAccount().getAccountNumber(), "Work Place", deposit, "deposit", date, checkings);
			writeToaccountsTxtFile(loggedInCustomer.getSavingAccount().getAccountNumber(), loggedInCustomer.getSavingAccount().getBalance().toString());
		}
	}
	
	public Customer getLoggedInCustomer() {
		return loggedInCustomer;
	}

	public void setLoggedInCustomer(Customer loggedInCustomer) {
		this.loggedInCustomer = loggedInCustomer;
	}

	public void withdraw (String withdraw, boolean checkings) throws IOException {
		Double withdrawAmount = Double.parseDouble(withdraw);
		String date = LocalDate.now().toString();
		if(checkings == true) {
			if(loggedInCustomer.getCheckingAccount().isOptIn()==false)
			{
				loggedInCustomer.getCheckingAccount().removeFromAccount(withdrawAmount);
				writeToTxtFiles(loggedInCustomer.getCheckingAccount().getAccountNumber(), "Work Place", withdraw, "withdraw", date, checkings);
				writeToaccountsTxtFile(loggedInCustomer.getCheckingAccount().getAccountNumber(), loggedInCustomer.getCheckingAccount().getBalance().toString());
			}
			else {
				if(loggedInCustomer.getCheckingAccount().getBalance()>withdrawAmount) 
				{
					loggedInCustomer.getCheckingAccount().removeFromAccount(withdrawAmount);
					writeToTxtFiles(loggedInCustomer.getCheckingAccount().getAccountNumber(), "Work Place", withdraw, "withdraw", date, checkings);
					writeToaccountsTxtFile(loggedInCustomer.getCheckingAccount().getAccountNumber(), loggedInCustomer.getCheckingAccount().getBalance().toString());
				}
			}
		}
		else {
			loggedInCustomer.getSavingAccount().removeFromAccount(withdrawAmount);
			writeToTxtFiles(loggedInCustomer.getSavingAccount().getAccountNumber(), "Work Place", withdraw, "withdraw", date, checkings);
			writeToaccountsTxtFile(loggedInCustomer.getSavingAccount().getAccountNumber(), loggedInCustomer.getSavingAccount().getBalance().toString());
		}
		
	}
	

	
	public void writeTransactions (int n, boolean checking) throws IOException {
		if (checking == true) {
			readingFromTxtFile(checkingtransactions, n, checking);
		}
		else {
			//read from savingstransaction txt file n amount of lines
			readingFromTxtFile(savingstransactions, n, checking);
		}
	}
	
	public void transferFunds(double amountToTransfer, boolean checking) {
		if(checking == true) {
			loggedInCustomer.getCheckingAccount().removeFromAccount(amountToTransfer);
			loggedInCustomer.getSavingAccount().addToAccount(amountToTransfer);
			
		}
		else {
			loggedInCustomer.getSavingAccount().removeFromAccount(amountToTransfer);
			loggedInCustomer.getCheckingAccount().addToAccount(amountToTransfer);
		}
	}
	
	public void eftFundTransfer(double amountToTransfer, boolean checking, String accNum, String roNum, String Name) {
		if(checking == true) {
			loggedInCustomer.getCheckingAccount().eftPayTo(accNum, roNum, Name, amountToTransfer);
		}
		else {
			loggedInCustomer.getSavingAccount().eftPayTo(accNum, roNum, Name, amountToTransfer);
		}
	}
	
	public void readingFromTxtFile(File file, int n, boolean checking) throws IOException {
		//ArrayList <Transaction> transactionList = new ArrayList <Transaction>();
		//ArrayList <Transaction> transactionList = new ArrayList <Transaction>();
		BufferedReader txtFileToRead = new BufferedReader(new FileReader(file));
		transactionList.clear();
		//System.out.println(txtFileToRead.readLine());
		int counter = 0;
		String[] myTrans = null;
		String line = null;
		if(checking == true) {
			while((line = txtFileToRead.readLine()) != null && (n-1 >= counter || n == 0)){
				//(Integer.parseInt(String)
				myTrans = line.split(",");
				Double amount = Double.parseDouble(myTrans[2]);
				if(loggedInCustomer.getCheckingAccount().getAccountNumber().equals(myTrans[0])) {
				transactionList.add(new Transaction(loggedInCustomer.getCheckingAccount().getAccountNumber(), myTrans[1], amount, myTrans[3], myTrans[4]));
				}
				//System.out.println(transactionList.get(counter).getNameCompany());
				counter ++;
			}
		}
		else {
			while((line = txtFileToRead.readLine()) != null && (n >= counter || n == 0)){
				//(Integer.parseInt(String)
				myTrans = line.split(",");
				Double amount = Double.parseDouble(myTrans[2]);
				if(loggedInCustomer.getSavingAccount().getAccountNumber().equals(myTrans[0])) {
				transactionList.add(new Transaction(loggedInCustomer.getSavingAccount().getAccountNumber(), myTrans[1], amount, myTrans[3], myTrans[4]));
				}
				counter ++;
			}
		}
	}
	
	public static void writeToTxtFiles(String aN, String nameCompany, String amount, String transType, String date, boolean checking) throws IOException {
		String lineBf = aN + "," + nameCompany + "," + amount + "," + transType + "," + date;
		if(checking == true) {
				BufferedWriter txtFileToWrite = new BufferedWriter(new FileWriter(checkingtransactions, true));
				//String lineBf = nameCompany + "," + amount + "," + transType + "," + date;
				txtFileToWrite.write(lineBf + System.getProperty("line.separator"));
				txtFileToWrite.close();
				//readingFromTxtFile(checkingtransactions,0,true);
		}
			else {
				BufferedWriter txtFileToWrite = new BufferedWriter(new FileWriter(savingstransactions, true));
				//String lineBf = nameCompany + "," + amount + "," + transType + "," + date;
				txtFileToWrite.write(lineBf + System.getProperty("line.separator"));
				txtFileToWrite.close();
			}
		
	}
	public void writeToCustomerTxtFile(String firstName, String lastName, String email, 
			String telephoneNumber, String password) throws IOException {
			BufferedWriter accountTxtFileToWrite = new BufferedWriter(new FileWriter(accountsFile, true));
			Random accountNumber = new Random();
			int low = 1111;
			int high = 9999;
			int checkAN = accountNumber.nextInt(high-low)+low;
			int savingAN = accountNumber.nextInt(high-low)+low;
			for (int i =0; i < accountNumbers.size(); i++) {
				
				int accAN = Integer.parseInt(accountNumbers.get(i));
				if(accAN == checkAN) {
					checkAN = accountNumber.nextInt(high-low)+low;
					i = -1;
				}
			}
			for (int i =0; i < accountNumbers.size(); i++) {
				
				int accAN = Integer.parseInt(accountNumbers.get(i));
				if(accAN == savingAN) {
					savingAN = accountNumber.nextInt(high-low)+low;
					i = -1;
				}
			}
			accountTxtFileToWrite.write(checkAN + "," + "0.00" + "," + savingAN + "," + "0.00" + System.getProperty("line.separator"));
			accountTxtFileToWrite.close();
			
			String lineBF = firstName + "," + lastName + "," + email + "," + telephoneNumber + "," + password + "," + checkAN + "," + savingAN;
			BufferedWriter txtFileToWrite = new BufferedWriter(new FileWriter(cFile, true));
			txtFileToWrite.write(lineBF + System.getProperty("line.separator"));
			txtFileToWrite.close();
	}
	
	public void readFromCustomerTxtFile(String email, String password) throws IOException {
		BufferedReader txtFileToRead = new BufferedReader(new FileReader(cFile));
		String[] myInfo = null;
		String line = null;
		customerList.clear();
		while((line = txtFileToRead.readLine()) != null){
			//(Integer.parseInt(String)
			myInfo = line.split(",");
			if(myInfo[2].equals(email)) {
				if(myInfo[4].equals(password)) {
					loggedInCustomer = new Customer(myInfo[0], myInfo[1], myInfo[2], myInfo[3], myInfo[4]);
					readFromaccountsTxtFile(myInfo[5], myInfo[6]);
				}
			}
			customerList.add(new Customer(myInfo[0], myInfo[1], myInfo[2], myInfo[3], myInfo[4], myInfo[5], myInfo[6]));
		}
	}
	
	public void CloseAccount() throws IOException {
		BufferedWriter accountTxtFileToWrite = new BufferedWriter(new FileWriter(cFile));
		accountTxtFileToWrite.close();
		BufferedWriter accountTxtFileToReWrite = new BufferedWriter(new FileWriter(cFile, true));
		
		for (Customer customer : customerList) {
			if(customer.getEmail().equals(loggedInCustomer.getEmail())) {
			}
			else {
				String lineBF = customer.getFirstName() + "," + customer.getLastName() + "," + customer.getEmail() + "," + customer.getPhone() + "," + customer.getPassword() + "," + customer.getCheckingAccount().getAccountNumber() + "," + customer.getSavingAccount().getAccountNumber();
				accountTxtFileToReWrite.write(lineBF + System.getProperty("line.separator"));
			}
		}
		
		
		accountTxtFileToReWrite.close();
		//String lineBF = firstName + "," + lastName + "," + email + "," + telephoneNumber + "," + password + "," + checkAN + "," + savingAN;
	}
	
	public void readFromaccountsTxtFile(String cAN, String sAN) throws IOException {
		BufferedReader txtFileToRead = new BufferedReader(new FileReader(accountsFile));
		//System.out.println(txtFileToRead.readLine());
		String[] myInfo = null;
		String line = null;
		while((line = txtFileToRead.readLine()) != null){
			//(Integer.parseInt(String)
			myInfo = line.split(",");
			if(cAN.equals(myInfo[0])) {
				Double cBalance = Double.parseDouble(myInfo[1]);
				loggedInCustomer.setCheckingAccount(new CheckingAccount(myInfo[0], cBalance));
			}
			if(sAN.equals(myInfo[2])) {
				Double sBalance = Double.parseDouble(myInfo[3]);
				loggedInCustomer.setSavingAccount(new SavingAccount(myInfo[2], sBalance));
			}
			
		}
	}
	
	public void writeToaccountsTxtFile(String aN, String amount) throws IOException {
		BufferedReader txtFileToRead = new BufferedReader(new FileReader(accountsFile));
		String[] myInfo = null;
		String line = null;
		ArrayList <String> accountInfo = new ArrayList<String>();
		while((line = txtFileToRead.readLine()) != null){
			//(Integer.parseInt(String)
			myInfo = line.split(",");
//			Double cBalance = Double.parseDouble(myInfo[1]);
//			loggedInCustomer.setCheckingAccount(new CheckingAccount(myInfo[0], cBalance));
			if(myInfo[0].equals(aN)) {
				myInfo[1] = amount; 
			}
			else if (myInfo[2].equals(aN)) {
				myInfo[3] = amount; 
			}
			String infoCombine = "";
			for (int i = 0; i < myInfo.length; i++) {
				if(i == myInfo.length-1) {
					infoCombine += myInfo[i];
				}
				else {
				infoCombine += myInfo[i] + ",";
				}
			}
			accountInfo.add(infoCombine);
		}
		BufferedWriter accountTxtFileToClear = new BufferedWriter(new FileWriter(accountsFile));
		accountTxtFileToClear.close();
		BufferedWriter accountTxtFileToWrite = new BufferedWriter(new FileWriter(accountsFile, true));
		for (String string : accountInfo) {
			accountTxtFileToWrite.write(string + System.getProperty("line.separator"));
		}
		accountTxtFileToWrite.close();
	}

	public ArrayList<Transaction> getTransactionList() {
		return transactionList;
	}

	public void setTransactionList(ArrayList<Transaction> transactionList) {
		this.transactionList = transactionList;
	}

	
	public void bankMonthlyStatement() throws NumberFormatException, IOException {
		BufferedReader txtFileToRead = new BufferedReader(new FileReader(checkingtransactions));
		//System.out.println(txtFileToRead.readLine());
		transactionList.clear();
		String date = LocalDate.now().toString();
		String[]myCurDate = date.split("-");
		String[] myTrans = null;
		String line = null;
		while((line = txtFileToRead.readLine()) != null){
				//(Integer.parseInt(String)
			myTrans = line.split(",");
			String[] myDate = myTrans[4].split("-");
			if(myDate[1].equals(myCurDate[1])) {
				Double amount = Double.parseDouble(myTrans[2]);
				if(loggedInCustomer.getCheckingAccount().getAccountNumber().equals(myTrans[0])) {
				transactionList.add(new Transaction(loggedInCustomer.getCheckingAccount().getAccountNumber(), myTrans[1], amount, myTrans[3], myTrans[4]));
				}
			}

		}
	}
	
}

