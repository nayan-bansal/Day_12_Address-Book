package com.bridgelabz;

import java.util.*;

public class AddressBookMain {


	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		AddressBookLog address = new AddressBookLog();
		ContactPerson person = new ContactPerson();
		
		System.out.println("Welcome to Address Book Developement Program");	
		
		while(true) {
		System.out.println("Do you want to create an Address Book\n- Press 1 for yes\n- Press 2 for No");	
		int start  = scan.nextInt();
		
		if(start == 2)
			System.exit(0);
			
		String name = scan.next();
		
			System.out.println("- Press 1 to Add Contact\n- Press 2 to Edit the contact\n- Press 3 to Delete contact\n- Press 0 to Exit");
			int choice = scan.nextInt();
			
			switch(choice) {
			case 0:
				System.out.println("Thank You for Visting the Address Book");
				System.exit(0);
				break;
			case 1:
				System.out.println("Enter the First Name:");
				person.setFirst_name(scan.next());
				address.addContact(person,name);
				System.out.println("Enter the Last Name:");
				person.setLast_name(scan.next());
				address.addContact(person,name);
				System.out.println("Enter the Address:");
				person.setAddress(scan.next());
				address.addContact(person,name);
				System.out.println("Enter the City:");
				person.setCity(scan.next());
				address.addContact(person,name);
				System.out.println("Enter the State");
				person.setState(scan.next());
				address.addContact(person,name);
				System.out.println("Enter the Phone Number");
				person.setPhone_number(scan.nextDouble());
				address.addContact(person,name);
				System.out.println("Enter the Zip Code");
				person.setZip_code(scan.nextInt());
				address.addContact(person,name);
				System.out.println("Enter the Email Id");
				person.setEmail_Id(scan.next());
				address.addContact(person, name);
				break;
			
			case 2:
				System.out.println("Enter the First Name of Person whoose contact you want to change");
				String edit  = scan.next();
				address.editContact(edit);
				break;
			case 3: 
				System.out.println("Enter the First Name of Person whoose contact you want to change");
				String delete = scan.next();
				address.deleteContact(delete);
				break;
			default:
				System.out.println("Wrong Entry");
				break;
			}
			
		
		}

	}	
}