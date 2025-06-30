package ContactService;

import java.util.HashMap;
import java.util.Map;

public class ContactService {
private final Map<String, Contact> contacts = new HashMap<>();
	
	public void addContact(Contact contact) {
		if (contacts.containsKey(contact.getContactId())) {
			throw new IllegalArgumentException("Contact ID Already Exists. Please try again.");
		}
		contacts.put(contact.getContactId(), contact);
	}
	
	public void deleteContact(String contactId) {
		if (!contacts.containsKey(contactId)) {
			throw new IllegalArgumentException("Contact ID Not Found. Please try again.");
		}
		contacts.remove(contactId);
	}
	
	// Improved to validate everything upfront before execution stops midway through
	public void updateContact(String contactId, String firstName, String lastName, String number, String address) {
		Contact contact = contacts.get(contactId);
		if (contact == null) throw new IllegalArgumentException("Contact ID Not Found.");
		if (firstName != null) {
			contact.setFirstName(firstName);
		} else {
			throw new IllegalArgumentException("Contact ID Not Found.");
		}
		if (lastName != null) {
			contact.setLastName(lastName);
		} else { 
			throw new IllegalArgumentException("Contact ID Not Found.");
		}
		if (number != null) {
			contact.setNumber(number);
		} else {
			throw new IllegalArgumentException("Contact ID Not Found.");
		}
		if (address != null) {
			contact.setAddress(address);
		} else {
			throw new IllegalArgumentException("Contact ID Not Found.");
		}
	}


	public Contact getContact(String contactId) {
		return contacts.get(contactId);
	}
}
