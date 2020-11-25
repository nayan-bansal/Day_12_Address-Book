package day.address.book;

import java.time.LocalDate;
import java.util.Objects;

public class ContactPerson {
	public String firstName;
	public String lastName;
	public String address;
	public String city;
	public String state;
	public String zip;
	public String phoneNo;
	public String email;
	public String addressBookName;
	public String addressBookType;
	public LocalDate date;

	public ContactPerson(String firstName, String lastName, String address, String city, String state, String zip2,
			String phoneNo2, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip2;
		this.phoneNo = phoneNo2;
		this.email = email;
	}

	public String getFirst_name () {
		return firstName;
	}

	
	public void setFirst_name(String first_name) {
		this.firstName  = first_name;
	}
	
	public String getLast_name () {
		return lastName;
	}
	
	public void setLast_name(String last_name) {
		this.lastName  = last_name;
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
	public String getZip_code () {
		return zip;
	}
	
	public void setZip_code(String zip_code) {
		this.zip  = zip_code;
	}
	public String getEmail_Id () {
		return email;
	}
	
	public void setPhone_number(String phone_number) {
		this.phoneNo  = phone_number;
	}
	public String getPhone_number () {
		return phoneNo;
	}
	
	public void setEmail_Id(String emai_Id) {
		this.email = email;
	}
	public ContactPerson(String firstName, String lastName, String address, String city, String state, String zip,
			String phoneNo, String email, String addressBookName, String addressBookType) {
		this(firstName, lastName, address, city, state, zip, phoneNo, email);
		this.addressBookName = addressBookName;
		this.addressBookType = addressBookType;
	}

	public ContactPerson(String firstName, String lastName, String address, String city, String state, String zip,
			String phoneNo, String email, String addressBookName, String addressBookType, LocalDate date) {
		this(firstName, lastName, address, city, state, zip, phoneNo, email, addressBookName, addressBookType);
		this.date = date;
	}

	public ContactPerson() {
	}

	@Override
	public String toString() {
		return "First Name: " + this.firstName + " Last Name: " + this.lastName + " Address: " + this.address
				+ " City: " + this.city + " State: " + this.state + " Zip: " + this.zip + " Phone Number: "
				+ this.phoneNo + " Email: " + this.email + " Address book name" + this.addressBookName + " type"
				+ addressBookType;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(firstName, lastName, address, city, state, zip, phoneNo, email, addressBookName,
				date);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		ContactPerson that = (ContactPerson) o;
		return firstName.equals(that.firstName) && address.equals(that.address);
	}
}
