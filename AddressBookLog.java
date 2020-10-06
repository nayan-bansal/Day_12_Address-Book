package com.bridgelabz;

import java.util.*;

public class AddressBookLog {

	ArrayList<ContactPerson> directory = new ArrayList<ContactPerson>();
	
	public void addContact(ContactPerson person) {
		
		
		
		directory.add(person);
		
	}

	public void editContact(String name) {
		
		Scanner scan = new Scanner(System.in);
		
		
	for(int i=0;i<directory.size();i++) {
		
		ContactPerson p = (ContactPerson)directory.get(i);
		
		if(name.equals(p.getFirst_name())) {
			System.out.println("Which details you want to Edit?\n1. First Name\n2. Last Name\n3. Address\n4. State\n5. City\n6. Phone Number\n7. Zip Code\n8. Email Id\n9. Exit");
			
			int edit_choice = scan.nextInt();
			
			switch(edit_choice) {
			case 1:
				System.out.println("Enter new First Name");
				directory.get(i).setFirst_name(scan.next());
				System.out.println("Data Updated");
				break;
			case 2:
				System.out.println("Enter new Last Name");
				directory.get(i).setLast_name(scan.next());
				System.out.println("Data Updated");
				break;
			case 3:
				System.out.println("Enter new Address");
				directory.get(i).setAddress(scan.next());
				System.out.println("Data Updated");
				break;
			case 4:
				System.out.println("Enter new State");
				directory.get(i).setState(scan.next());
				System.out.println("Data Updated");
				break;
			case 5:
				System.out.println("Enter new City");
				directory.get(i).setCity(scan.next());
				System.out.println("Data Updated");
				break;
			case 6:
				System.out.println("Enter new Phone Number");
				directory.get(i).setPhone_number(scan.nextDouble());
				System.out.println("Data Updated");
				break;
			case 7:
				System.out.println("Enter new Zip code");
				directory.get(i).setZip_code(scan.nextInt());
				System.out.println("Data Updated");
				break;
			case 8:
				System.out.println("Enter new Email Id");
				directory.get(i).setEmail_Id(scan.next());
				System.out.println("Data Updated");
				break;
			case 9:
				
			default:
				System.out.println("Invalid Entry");
				break;
			}
		}
	
		System.out.println("Do you want to update another entry?\nPress 1 for yes\nPress 2 for No");
		int ch = scan.nextInt();
		if(ch==1)
			continue;
		else
			break;
	}
		
}

	public void deleteContact(String delete) {
		
		for(int i=0; i<directory.size();i++) {
			
		if(delete.equals(directory.get(i).getFirst_name()))
			directory.remove(i);
		System.out.println("Details of "+delete+" removed");
		}
	}
	
}