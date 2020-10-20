package day.address.book;

import static org.junit.Assert.*;

import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import day.address.book.AddressBookLog.IOService;

public class AddressBookTest {

	@Test
	public void givenAddressBookWhenWrittenToFileShouldMatchEnteries() throws IOException {
		ArrayList<ContactPerson> directory = new ArrayList<>();
		ContactPerson p = new ContactPerson();
		
		p.setFirst_name("nayan");
		p.setLast_name("bansal");
		p.setAddress("karnal");
		p.setCity("Karnal");
		p.setState("Haryana");
		p.setPhone_number(941022222);
		p.setEmail_Id("nayan.7991@gmail.com");
		p.setZip_code(132001);
		directory.add(p);
		
		p.setFirst_name("aayush");
		p.setLast_name("bansal");
		p.setAddress("noida");
		p.setCity("Noida");
		p.setState("Haryana");
		p.setPhone_number(941044422);
		p.setEmail_Id("aayush8@gmail.com");
		p.setZip_code(132233);
		directory.add(p);
		
		AddressBookLog q = new AddressBookLog();
		q.writeAddressBookData(IOService.FILE_IO);
	}

	@Test
	public void readingAddressBook() {
		AddressBookLog contactPerson = new AddressBookLog();
		List<ContactPerson> entries = AddressBookLog.readPersonData(IOService.FILE_IO);
	}
}