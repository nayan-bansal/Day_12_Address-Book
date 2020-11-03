package day.address.book;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;


public class AddressBookService {

	private List<ContactPerson> contactList;
	private AddressBookDBService addressBookDBService;
	private AddressBookDBServiceNew addressBookDBServiceNew;
	private Map<String, Integer> contactByCity;

	public AddressBookService(List<ContactPerson> contactList) {
		this();
		this.contactList = contactList;
	}

	public AddressBookService() {
		addressBookDBService = AddressBookDBService.getInstance();
		addressBookDBServiceNew=AddressBookDBServiceNew.getInstance();
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

	public Map<String, Integer> readContactByCityOrState() {
		this.contactByCity = addressBookDBService.getContactByCity();
		return contactByCity;
	}

	public void addContactToAddressBook(String firstName, String lastName, String address, String city, String state,
			String zip, String phoneNumber, String email, String addressBookName, String addressBookType,
			LocalDate date) {
		contactList.add(addressBookDBServiceNew.addContact(firstName, lastName, address, city, state, zip, phoneNumber,
				email, addressBookName, addressBookType, date));
	}
}