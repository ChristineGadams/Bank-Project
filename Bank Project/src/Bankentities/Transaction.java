package Bankentities;

public class Transaction {
	String nameCompany = "";
	Double amountTrans = 0.0;
	String transType = "";
	String date = "";
	String aN = "";
	
	
	
	public Transaction( String aN, String nameCompany, Double amountTrans, String transType, String date) {
		super();
		this.aN = aN;
		this.nameCompany = nameCompany;
		this.amountTrans = amountTrans;
		this.transType = transType;
		this.date = date;
	}
	
	public String getaN() {
		return aN;
	}
	public void setaN(String aN) {
		this.aN = aN;
	}
	public String getNameCompany() {
		return nameCompany;
	}
	public void setNameCompany(String nameCompany) {
		this.nameCompany = nameCompany;
	}
	public Double getAmountTrans() {
		return amountTrans;
	}
	public void setAmountTrans(Double amountTrans) {
		this.amountTrans = amountTrans;
	}
	public String getTransType() {
		return transType;
	}
	public void setTransType(String transType) {
		this.transType = transType;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
	
}
