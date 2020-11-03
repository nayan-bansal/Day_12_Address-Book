package day.address.book;

import static org.junit.Assert.*;

import org.junit.Test;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import day.address.book.AddressBookLog.IOService;
import junit.framework.Assert;

public class AddressBookTest {

	@Test
	public void contactsWhenRetrievedFromDB_ShouldMatchCount() {
		AddressBookService addressBookService = new AddressBookService();
		List<ContactPerson> contactList = addressBookService.readContactData();
		Assert.assertEquals(2, contactList.size());
	}

	@Test
	public void givenNewAddressOfContact_WhenUpdatedUsingPreparedStatement_ShouldSyncWithDB() {
		AddressBookService addressBookService = new AddressBookService();
		List<ContactPerson> contactList = addressBookService.readContactData();
		addressBookService.updateContactDetails("nayan", "sector-6");
		boolean result = addressBookService.checkConatctDetailsInSyncWithDB("nayan");
		Assert.assertTrue(result);
	}

	@Test
	public void givenDateRange_WhenRetrieved_ShouldMatchEmployeeCount() {
		AddressBookService addressBookService = new AddressBookService();
		addressBookService.readContactData();
		LocalDate startDate = LocalDate.of(2018, 01, 01);
		LocalDate endDate = LocalDate.now();
		List<ContactPerson> contactList = addressBookService.readContactDataForDateRange(startDate, endDate);
		Assert.assertEquals(3, contactList.size());
	}

	@Test
	public void givenContacts_RetrieveNumberOfContacts_ByCityOrState() {
		AddressBookService addressBookService = new AddressBookService();
		addressBookService.readContactData();
		Map<String, Integer> contactByCityMap = addressBookService.readContactByCityOrState();
		Integer count = 2;
		Assert.assertEquals(count, contactByCityMap.get("delhi"));
	}

	@Test
	public void givenNewContact_WhenAdded_ShouldSyncWithDB() {
		AddressBookService addressBookService = new AddressBookService();
		addressBookService.readContactData();
		LocalDate date = LocalDate.now();
		addressBookService.addContactToAddressBook("mark", "goel", "begusarai", "patna", "bihar", "125677", "9834592552",
				"mark@gmail", "officeContacts", "colleague", date);
		boolean result = addressBookService.checkConatctDetailsInSyncWithDB("mark");
		Assert.assertTrue(result);
	}
}