package com.bridgelabz;

import java.util.*;

public class AddressBookLog {

	ArrayList<ContactPerson> directory = new ArrayList<ContactPerson>();
	
	
	
	public void addContact(ContactPerson person) {
		
		directory.add(person);

	}

	public void editContact(String name, String edit) {
		
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
		else
			System.out.println("No Entry Found");
	
		System.out.println("Do you want to update another entry?\nPress 1 for yes\nPress 2 for No");
		int ch = scan.nextInt();
		if(ch==1)
			continue;
		else
			break;
	}
		
}

	
	public void deleteDuplicate(String firstname, String lastname) {
		for(int i=0; i<directory.size();i++) {
		if(firstname.equals(directory.get(i).getFirst_name()) && directory.get(i).getAddress() == null && lastname.equals(directory.get(i).getLast_name()))
			directory.remove(i);
		} 
	}

	public void deleteContact(String delete) {
		
		for(int i=0; i<directory.size();i++) {
			
		if(delete.equals(directory.get(i).getFirst_name()))
			{directory.remove(i);
		System.out.println("Details of "+delete+" removed");}
		}
	}



	public boolean checkName(String first_name, String last_name) {
boolean duplicate = false;
		
		for(int i=0;i<directory.size();i++) {
			if(directory.get(i).getFirst_name().equals(first_name) && directory.get(i).getLast_name().equals(last_name) )
				duplicate = true;
		}
		
		return duplicate;
	}

	public void search( String f_name, String l_name) {
	
		for(ContactPerson person : directory) {
			
			if(person.getFirst_name().equals(f_name) || person.getLast_name().equals(l_name))
			{
				System.out.println("First Name"+person.getFirst_name()+"\nLast Name:"+person.getLast_name()+"\nState:"+person.getState()+"\nAddress:"+person.getAddress()+"\nCity:"+person.getCity()+"\nPhone Number:"+person.getPhone_number()+"\nZip Code:"+person.getZip_code()+"\nEmail Id:"+person.getEmail_Id());
				break;
			}
			else
				System.out.println("No Entry Found");
			
		}
	}

	public void searchPerson(String city) {
		
		ArrayList<ContactPerson> city_list= new ArrayList<>();
		for(ContactPerson person: directory) {
			if(person.getCity().equals(city)) {
				city_list.add(person);
			}
		}
		
		for(ContactPerson person : city_list) {
			
		System.out.println("The Details of the Contact of city : " + person.getCity() + "are given Below:");
		System.out.println("First Name"+person.getFirst_name()+"\nLast Name:"+person.getLast_name()+"\nState:"+person.getState()+"\nAddress:"+person.getAddress()+"\nCity:"+person.getCity()+"\nPhone Number:"+person.getPhone_number()+"\nZip Code:"+person.getZip_code()+"\nEmail Id:"+person.getEmail_Id());
				
			
		}
	}


	public void searchPersonState(String state) {
		
		ArrayList<ContactPerson> state_list= new ArrayList<>();
		for(ContactPerson person: directory) {
			if(person.getState().equals(state)) {
				state_list.add(person);
			}
		}
		
		for(ContactPerson person : state_list) {
			
		System.out.println("The Details of the Contact of city : " + person.getState() + "are given Below:");
		System.out.println("First Name"+person.getFirst_name()+"\nLast Name:"+person.getLast_name()+"\nState:"+person.getState()+"\nAddress:"+person.getAddress()+"\nCity:"+person.getCity()+"\nPhone Number:"+person.getPhone_number()+"\nZip Code:"+person.getZip_code()+"\nEmail Id:"+person.getEmail_Id());
				
			
		}
	}
}
