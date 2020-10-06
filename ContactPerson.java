package com.bridgelabz;

public class ContactPerson {

	private String first_name;
	private String last_name;
	private String address;
	private String city;
	private String state;
	private int zip_code; 
	private double phone_number;
	private String email_Id;
	
	
	public String getFirst_name () {
		return first_name;
	}

	
	public void setFirst_name(String first_name) {
		this.first_name  = first_name;
	}
	
	public String getLast_name () {
		return last_name;
	}
	
	public void setLast_name(String last_name) {
		this.last_name  = last_name;
	}
	public String getAddress () {
		return address;
	}
	
	public void setAddress(String address) {
		this.address  = address;
	}
	public String getState () {
		return state;
	}
	
	public void setState (String state) {
		this.state  = state;
	}
	
	public String getCity () {
		return city;
	}
	public void setCity(String city) {
		this.city  = city;
	}
	public int getZip_code () {
		return zip_code;
	}
	
	public void setZip_code(int zip_code) {
		this.zip_code  = zip_code;
	}
	public String getEmail_Id () {
		return email_Id;
	}
	
	public void setPhone_number(double phone_number) {
		this.phone_number  = phone_number;
	}
	public double getPhone_number () {
		return phone_number;
	}
	
	public void setEmail_Id(String emai_Id) {
		this.email_Id  = email_Id;
	}


	
}
