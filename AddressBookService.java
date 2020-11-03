package day.address.book;

import java.time.LocalDate;
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

	public void updateContactDetails(String name, String address) {
		int result = addressBookDBService.updateEmployeeData(name, address);
		if (result == 0)
			return;
		ContactPerson personInfo = this.getContactData(name);
		if (personInfo != null)
			personInfo.address = address;
	}

	private ContactPerson getContactData(String name) {
		return this.contactList.stream().filter(contact -> contact.firstName.equals(name)).findFirst().orElse(null);
	}

	public boolean checkConatctDetailsInSyncWithDB(String name) {
		List<ContactPerson> contactList = addressBookDBService.getcontactData(name);
		return contactList.get(0).equals(getContactData(name));
	}

	public List<ContactPerson> readContactDataForDateRange(LocalDate startDate, LocalDate endDate) {
		this.contactList = addressBookDBService.getContactForDateRange(startDate, endDate);
		return contactList;
	}
}