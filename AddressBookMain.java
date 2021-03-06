package day.address.book;

import java.util.Scanner;

import day.address.book.AddressBookDic;
import day.address.book.AddressBookLog;
import day.address.book.ContactPerson;

public class AddressBookMain {


	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		AddressBookLog address = new AddressBookLog();
		ContactPerson person = new ContactPerson();
		
		System.out.println("Welcome to Address Book Developement Program");	
		System.out.println("Do you want to create an address book or add contact to an existing Address Book\n- Press 1 for yes\n- Press 2 for No");	
		int start  = scan.nextInt();
		if(start == 2)
			System.exit(0);
		
		int count =0;
		outer:
		while(true) {
		System.out.println("Enter the name of new Address Book or existing address book");
		String name = scan.next();
			
			AddressBookDic file = new AddressBookDic();
			
			System.out.println("- Press 1 to Add Contact\n- Press 2 to Edit the contact\n- Press 3 to Delete contact\n- Press 4 to Search Contact\n- Press 5 to Search person by City\n- Press 6 to Search person by State\n- Press 7 to count persons by City\n- Press 8 to count persons by state\n- Press 9 to Sort by Name\n- Press 0 to Exit");
			int choice = scan.nextInt();
			
			switch(choice) {
			case 0:
				System.out.println("Thank You for Visting the Address Book");
				//System.exit(0);
				break outer;
			case 1:
				
				System.out.println("Enter the First Name:");
				//
				//address.addContact(person);
				String fname = scan.next();
				//String fname = person.getFirst_name();
				System.out.println("Enter the Last Name:");
				//person.setLast_name(scan.next());
				//address.addContact(person);
				String lname = scan.next();
				//String lname = person.getLast_name();
				
				if(address.checkName(fname, lname) == true && count!=0)
				{
					System.out.println("Duplicate Entry Found!! Please Try Agian");
					address.deleteDuplicate(fname, lname);
					break;
				}
				else {
					person.setFirst_name(fname);
					person.setLast_name(lname);
				}
				
				System.out.println("Enter the Address:");
				person.setAddress(scan.next());
				address.addContact(person);
				System.out.println("Enter the City:");
				person.setCity(scan.next());
				address.addContact(person);
				System.out.println("Enter the State");
				person.setState(scan.next());
				address.addContact(person);
				System.out.println("Enter the Phone Number");
				person.setPhone_number(scan.next());
				address.addContact(person);
				System.out.println("Enter the Zip Code");
				person.setZip_code(scan.next());
				address.addContact(person);
				System.out.println("Enter the Email Id");
				person.setEmail_Id(scan.next());
				address.addContact(person);
				
				file.addDic(name,person);
				count++;
				System.out.println(count);
				break;
			
			case 2:
				System.out.println("Enter the First Name of Person whoose contact you want to change");
				String edit  = scan.next();
				address.editContact(edit,name);
				break;
			case 3: 
				System.out.println("Enter the First Name of Person whoose contact you want to change");
				String delete = scan.next();
				address.deleteContact(delete);
				break;
			case 4:
				System.out.println("Enter the First Name to be searched");
				String f_name = scan.next();
				System.out.println("Enter the Last Name to be searched");
				String l_name = scan.next();
				address.search(f_name,l_name);
				break;
			case 5:
				System.out.println("Enter the City to be searched");
				String city = scan.next();
				address.searchPerson(city);
				break;
			case 6:
				System.out.println("Enter the State to be searched");
				String state = scan.next();
				address.searchPersonState(state);
				break;
			case 7:
				System.out.println("Enter the City in which contacts are to be found");
				String count_city = scan.next();
				address.countbycity(count_city);
				break;
			case 8:
				System.out.println("Enter the State in which contacts are to be found");
				String count_state = scan.next();
				address.countbycity(count_state);
				break;
			case 9:
				System.out.println("Press 1 to sort by first name\nPress 2 to sort by City\nPress 3 to sort by Zip Code");
				int ch = scan.nextInt();
				switch(ch) {
				case 1:
					address.Sort_name();
					break;
				case 2:
					address.Sort_City();
					break;
				case 3:
					address.Sort_Zip();
					break;
				}
				
				break;
			default:
				System.out.println("Wrong Entry");
				break;
			 }

		   }
		}
	}	


