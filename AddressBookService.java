package day.address.book;

import java.util.List;

public class AddressBookService {

	private List<ContactPerson> contactList;
	private AddressBookDBService addressBookDBService;

	public AddressBookService(List<ContactPerson> contactList) {
		this();
		this.contactList = contactList;
	}

	public AddressBookService() {
		addressBookDBService = AddressBookDBService.getInstance();
	}

	public List<ContactPerson> readContactData() {
		this.contactList = addressBookDBService.readData();
		return contactList;
	}
	
}
