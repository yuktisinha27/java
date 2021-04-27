package com.java.mphasis.bankproj;

public class Account {

	private int account_no;
	private String first_name;
	private String last_name;
	private String city;
	private String state;
	private int amount;
	private String cheq_facil;
	private String account_type;
	private String status;
	
	public Account(int account_o, String first_name, String last_name, String city, String state, int amount,
			String cheq_facil, String account_type, String status) {
		this.account_no = account_o;
		this.first_name = first_name;
		this.last_name = last_name;
		this.city = city;
		this.state = state;
		this.amount = amount;
		this.cheq_facil = cheq_facil;
		this.account_type = account_type;
		this.status = status;
	}
	
	public Account() {
		
	}
	public int getAccount_no() {
		return account_no;
	}
	public void setAccount_no(int account_o) {
		this.account_no = account_o;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
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
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getCheq_facil() {
		return cheq_facil;
	}
	public void setCheq_facil(String cheq_facil) {
		this.cheq_facil = cheq_facil;
	}
	public String getAccount_type() {
		return account_type;
	}
	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Account [account_no=" + account_no + ", first_name=" + first_name + ", last_name=" + last_name
				+ ", city=" + city + ", state=" + state + ", amount=" + amount + ", cheq_facil=" + cheq_facil
				+ ", account_type=" + account_type + ", status=" + status + "]";
	}	
	
}
