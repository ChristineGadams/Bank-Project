package Bankentities;

public class Address {

	
	private String streetAddress = null;
	private String city = null;
	private String state = null;
	private String zipCode = null;
	
	
	
	
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Address(String streetAddress, String city, String state, String zipCode) {
		super();
		this.streetAddress = streetAddress;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		
		
	}
	public String getStreetAddress() {
		return streetAddress;
	}
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	} 
	
}