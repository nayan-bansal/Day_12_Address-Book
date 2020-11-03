package day.address.book;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class AddressBookDBService {
	private static Logger log = Logger.getLogger(AddressBookDBService.class.getName());
	private PreparedStatement ContactDataStatement;
	private static AddressBookDBService addressBookDBService;

	private AddressBookDBService() {
	}

	static AddressBookDBService getInstance() {
		if (addressBookDBService == null) {
			addressBookDBService = new AddressBookDBService();
		}
		return addressBookDBService;
	}

	public static Connection getConnection() throws SQLException {
		String jdbcURL = "jdbc:mysql://localhost:3307/address_book_service?useSSL=false";
		String userName = "root";
		String password = "nayan@1965";
		Connection connection;
		log.info("connecting to database: " + jdbcURL);
		connection = DriverManager.getConnection(jdbcURL, userName, password);
		log.info("connection successful !!!! " + connection);
		return connection;
	}

	public List<ContactPerson> readData() {
		String sql = "SELECT c.first_name, c.last_name,c.address_book_name,c.address,c.city,"
				+ "c.state,c.zip,c.phone_number,c.email,abd.address_book_type "
				+ "from contact_details c inner join address_book_dict abd "
				+ "on c.address_book_name=abd.address_book_name; ";
		return this.getContactDetailsUsingSqlQuery(sql);
	}

	private List<ContactPerson> getContactDetailsUsingSqlQuery(String sql) {
		List<ContactPerson> ContactList = null;
		try (Connection connection = AddressBookDBService.getConnection();) {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet result = preparedStatement.executeQuery(sql);
			ContactList = this.getAddressBookData(result);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ContactList;
	}

	private List<ContactPerson> getAddressBookData(ResultSet result) {
		List<ContactPerson> contactList = new ArrayList<>();
		try {
			while (result.next()) {
				String firstName = result.getString("first_name");
				String lastName = result.getString("last_name");
				String addressBookName = result.getString("address_book_name");
				String address = result.getString("address");
				String city = result.getString("city");
				String state = result.getString("state");
				String zip = result.getString("zip");
				String phoneNumber = result.getString("phone_number");
				String email = result.getString("email");
				String addressBookType = result.getString("address_book_type");
				contactList.add(new ContactPerson(firstName, lastName, address, city, state, zip, phoneNumber, email,
						addressBookName, addressBookType));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return contactList;
	}

	public int updateEmployeeData(String name, String address) {
		return this.updateContactDataUsingPreparedStatement(name, address);
	}

	private int updateContactDataUsingPreparedStatement(String first_name, String address) {
		try (Connection connection = AddressBookDBService.getConnection();) {
			String sql = "update contact_details set address=? where first_name=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, address);
			preparedStatement.setString(2, first_name);
			int status = preparedStatement.executeUpdate();
			return status;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public List<ContactPerson> getcontactData(String name) {
		List<ContactPerson> contactList = null;
		if (this.ContactDataStatement == null)
			this.prepareStatementForContactData();
		try {
			ContactDataStatement.setString(1, name);
			ResultSet resultSet = ContactDataStatement.executeQuery();
			contactList = this.getAddressBookData(resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return contactList;
	}

	private void prepareStatementForContactData() {
		try {
			Connection connection = AddressBookDBService.getConnection();
			String sql = "SELECT c.first_name, c.last_name,c.address_book_name,c.address,c.city,"
					+ "c.state,c.zip,c.phone_number,c.email,abd.address_book_type "
					+ " from contact_details c inner join address_book_dict abd "
					+ " on c.address_book_name=abd.address_book_name WHERE first_name=?; ";
			ContactDataStatement = connection.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<ContactPerson> getContactForDateRange(LocalDate startDate, LocalDate endDate) {
		String sql = String.format(
				"SELECT c.first_name, c.last_name,c.address_book_name,c.address,c.city,"
						+ "c.state,c.zip,c.phone_number,c.email,abd.address_book_type "
						+ "from contact_details c inner join address_book_dict abd "
						+ "on c.address_book_name=abd.address_book_name where date_added between '%s' AND '%s'; ",
				Date.valueOf(startDate), Date.valueOf(endDate));
		return this.getContactDetailsUsingSqlQuery(sql);
	}

	public Map<String, Integer> getContactByCity() {
		String sql = "SELECT city, count(first_name) as count from contact_details group by city; ";
		Map<String, Integer> contactByCityMap = new HashMap<>();
		try (Connection connection = AddressBookDBService.getConnection()) {
			java.sql.Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(sql);
			while (result.next()) {
				String city = result.getString("city");
				Integer count = result.getInt("count");
				contactByCityMap.put(city,count);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return contactByCityMap;
	}
}