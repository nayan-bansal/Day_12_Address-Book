package day.address.book;

import static org.junit.Assert.*;

import org.junit.Test;

import java.io.IOException;
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
}