package day.address.book;

import static org.junit.Assert.*;

import org.junit.Test;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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
	public void givenNewSalaryForEmployee_WhenUpdatedUsingPreparedStatement_ShouldSyncWithDB() {
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
		Assert.assertEquals(2, contactList.size());
	}
}