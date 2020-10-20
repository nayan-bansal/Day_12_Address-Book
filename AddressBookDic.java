package day.address.book;

import java.util.HashMap;

public class AddressBookDic {
	private HashMap<String, ContactPerson> dictionary =new HashMap<>();
	
	
	public void setDictionary(HashMap<String, ContactPerson> dictionary) {
		this.dictionary = dictionary;
	}
	
	public HashMap<String, ContactPerson> getDictionary(){
		return dictionary;
	}

	
	public void addDic(String name, ContactPerson person) {
		dictionary.put(name, person);
	}

	public int lenDictionary() {
		return dictionary.size();
	}

}