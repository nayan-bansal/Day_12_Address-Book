package day.address.book;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.bean.*;
import com.opencsv.exceptions.*;

public class AddressBookCSV {

	private static String ADDRESS_BOOK = "address-book.csv";
	
	public static void main(String[] args) throws Exception {
		System.out.println("Welcome to the Address Book-CSV-JSON Program.");
		AddressBookCSV addressBookCSV = new AddressBookCSV();
		try {
			addressBookCSV.writeCSVData();
			addressBookCSV.readCSVData();
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	
	public void writeCSVData() throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
		Writer csvWriter = Files.newBufferedWriter(Paths.get(ADDRESS_BOOK));
		StatefulBeanToCsvBuilder<ContactPerson> builder = new StatefulBeanToCsvBuilder<>(csvWriter);
		StatefulBeanToCsv<ContactPerson> beanWriter = builder.build();
		List<ContactPerson> contacts = new ArrayList<>();
		contacts.add(new ContactPerson("Jeff", "Bezos", "Beverly Hills", "Los Angeles", "California", 90035, 987654321, "jeffbezos@gmail.com"));
		contacts.add(new ContactPerson("Bill", "Gates", "Manhattan", "NYC", "New York", 10036, 912345678, "billgates@gmail.com"));
		ColumnPositionMappingStrategy<Object> mappingStrategy = new ColumnPositionMappingStrategy<Object>();
		mappingStrategy.setType(ContactPerson.class);
		String[] columns = new String[] { "First Name", "Last Name", "Address", "City", "State", "Zip", "Phone No", "E Mail" };
		mappingStrategy.setColumnMapping(columns);
		beanWriter.write(contacts);
		csvWriter.close();
	}

	public void readCSVData() throws Exception {
		Reader reader = Files.newBufferedReader(Paths.get(ADDRESS_BOOK));
		CSVReader csvReader = new CSVReader(reader);
		String[] nextRecord;
		while ((nextRecord = csvReader.readNext()) != null) {
			System.out.println("Address: " + nextRecord[0]);
			System.out.println("City: " + nextRecord[1]);
			System.out.println("Email: " + nextRecord[2]);
			System.out.println("First Name: " + nextRecord[3]);
			System.out.println("Last Name: " + nextRecord[4]);
			System.out.println("Phone: " + nextRecord[5]);
			System.out.println("State: " + nextRecord[6]);
			System.out.println("Zip: " + nextRecord[7]);
		}
		csvReader.close();
	}
	
}
