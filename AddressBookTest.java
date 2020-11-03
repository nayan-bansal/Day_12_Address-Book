package day.address.book;

import static org.junit.Assert.*;

import org.junit.Test;

import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.junit.Test;
import day.address.book.AddressBookLog.IOService;
import junit.framework.Assert;

public class AddressBookTest {
	private static Logger log = Logger.getLogger(AddressBookTest.class.getName());

	@Test
	public void contactsWhenRetrievedFromDB_ShouldMatchCount() {
		AddressBookService addressBookService = new AddressBookService();
		List<ContactPerson> contactList = addressBookService.readContactData();
		Assert.assertEquals(1, contactList.size());
	}

	@Test
	public void givenNewAddressOfContact_WhenUpdatedUsingPreparedStatement_ShouldSyncWithDB() {
		AddressBookService addressBookService = new AddressBookService();
		List<ContactPerson> contactList = addressBookService.readContactData();
		addressBookService.updateContactDetails("sam", "sector");
		boolean result = addressBookService.checkConatctDetailsInSyncWithDB("sam");
		Assert.assertTrue(result);
	}

	@Test
	public void givenDateRange_WhenRetrieved_ShouldMatchEmployeeCount() {
		AddressBookService addressBookService = new AddressBookService();
		addressBookService.readContactData();
		LocalDate startDate = LocalDate.of(2018, 01, 01);
		LocalDate endDate = LocalDate.now();
		List<ContactPerson> contactList = addressBookService.readContactDataForDateRange(startDate, endDate);
		Assert.assertEquals(5, contactList.size());
	}

	@Test
	public void givenContacts_RetrieveNumberOfContacts_ByCityOrState() {
		AddressBookService addressBookService = new AddressBookService();
		addressBookService.readContactData();
		Map<String, Integer> contactByCityMap = addressBookService.readContactByCityOrState();
		Integer count = 3;
		Assert.assertEquals(count, contactByCityMap.get("delhi"));
	}

	@Test
	public void givenNewContact_WhenAdded_ShouldSyncWithDB() {
		AddressBookService addressBookService = new AddressBookService();
		addressBookService.readContactData();
		LocalDate date = LocalDate.now();
		addressBookService.addContactToAddressBook("nakul", "garg", "sector-5", "karnal", "karnal", "123345", "9965555552",
				"nakul@gmail", "officeContacts", "colleague", date);
		boolean result = addressBookService.checkConatctDetailsInSyncWithDB("nakul");
		Assert.assertTrue(result);
	}

	@Test
	public void givenNewContacts_WhenAdded_ShouldMatchEntries() {
		ContactPerson[] arrayOfContacts= {
				new ContactPerson("rishabh", "gupta", "sec", "begusarai", "patna", "123122", "9599692252",
				"rishabh@gmail", "contacts", "colleague", LocalDate.now()),
				new ContactPerson("mohit", "gupta", "delhi", "delhi", "delhi", "1125345", "9095592252",
						"mohit@gmail", "frndcontacts", "friend", LocalDate.now()),
				new ContactPerson("yash", "gupta", "gk", "delhi", "delhi", "1125845", "909069233",
						"yash@gmail", "offcontacts", "colleague", LocalDate.now())
		};
		AddressBookService addressBookService = new AddressBookService();
		addressBookService.readContactData();
		Instant start = Instant.now();
		addressBookService.addEmployeeToPayrollWithThreads(Arrays.asList(arrayOfContacts));
		Instant end = Instant.now();
		log.info("Duration with thread : " + Duration.between(start, end));
		List<ContactPerson> contactList = addressBookService.readContactData();
		Assert.assertEquals(5, contactList.size());
	}
}