package day.address.book;

import java.io.*;
import java.nio.file.*;
import java.util.*;

import com.google.gson.Gson;


public class AddressBookJson {

	private static String ADDRESSBOOK_JSON_FILE = "address-book-JSON.json";

	public static void main(String[] args) throws Exception {
		System.out.println("Welcome to the Address Book-CSV-JSON Program.");
		AddressBookJson addressBookJSON = new AddressBookJson();
		try {
			addressBookJSON.writeJSONData();
			addressBookJSON.readJSONData();
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	public void readJSONData() throws IOException {
		List<ContactPerson> contacts = new ArrayList<ContactPerson>();
		try {
			Reader reader = Files.newBufferedReader(Paths.get(ADDRESSBOOK_JSON_FILE));
			System.out.println(contacts.addAll(Arrays.asList(new Gson().fromJson(reader, ContactPerson[].class))));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void writeJSONData() throws IOException {
		Writer writer = Files.newBufferedWriter(Paths.get(ADDRESSBOOK_JSON_FILE));
		List<ContactPerson> contacts = new ArrayList<>();
		contacts.add(new ContactPerson("Nayan", "Bansal", "Sector-13", "Karnal", "Haryana", 90035, 987654321, "nayan@gmail.com"));
		contacts.add(new ContactPerson("Aayush", "Bansal", "Sector-13", "Karnal", "Haryana", 10036, 912345678, "aayush@gmail.com"));
		new Gson().toJson(contacts, writer);
		writer.close();
	}
}
