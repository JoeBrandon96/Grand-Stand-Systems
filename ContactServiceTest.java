package ContactService;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ContactServiceTest {

	// Test add contact method
		@Test
		public void testAddContact() {
			ContactService service = new ContactService();
			Contact contact = new Contact("5167584", "Leroy", "Jenkins", "1234567890", "123 Sesame Street");
			service.addContact(contact);
			assertEquals(contact, service.getContact("5167584"));
		}
		
		// Test delete contact method
		@Test
		public void testDeleteContact() {
			ContactService service = new ContactService();
			Contact contact = new Contact("5167584", "Leroy", "Jenkins", "1234567890", "123 Sesame Street");
			service.addContact(contact);
			service.deleteContact("5167584");
			assertNull(service.getContact("5167584"));
		}
		
		// Test update contact method
		@Test
		public void testUpdateContact() {
			ContactService service = new ContactService();
			Contact contact = new Contact("5167584", "Leroy", "Jenkins", "1234567890", "123 Sesame Street");
			service.addContact(contact);
			
			// Update fields
			service.updateContact("5167584", "Michael", "Jackson", "0987654321", "833 Broadway Avenue");
			Contact updatedContact = service.getContact("5167584");
			
			// Assert updated fields
			assertAll("Updated Contact",
			() -> assertEquals("Michael", updatedContact.getFirstName()),
			() -> assertEquals("Jackson", updatedContact.getLastName()),
			() -> assertEquals("0987654321", updatedContact.getNumber()),
			() -> assertEquals("833 Broadway Avenue", updatedContact.getAddress())
			);
		}
		
		@Test
		public void testAddDuplicateContactId() {
			ContactService service = new ContactService();
			Contact contact1 = new Contact("5167584", "Leroy", "Jenkins", "1234567890", "123 Sesame Street");
			Contact contact2 = new Contact("5167584", "Leroy", "Jenkins", "1234567890", "123 Sesame Street");
			service.addContact(contact1);
			
			// Assert that contact with same ID will throw an exception
			assertThrows(IllegalArgumentException.class, () -> service.addContact(contact2));
		}
		@Test
		public void testDeleteNonexistentContact() {
			ContactService service = new ContactService();
			assertThrows(IllegalArgumentException.class, () -> service.deleteContact("5167584"));
		}
		
		@Test
		public void testUpdateNonexistentContact() throws Exception {
			ContactService service = new ContactService();
			assertThrows(IllegalArgumentException.class,
					() -> service.updateContact("5167584", "Michael", "Jackson", "0987654321", "833 Broadway Avenue"));
		}
		
		@Test
		void updateContactThrowsIfFirstNameIsNull() {
			ContactService service = new ContactService();
			Contact contact1 = new Contact("5167584", "Leroy", "Jenkins", "1234567890", "123 Sesame Street");
			service.addContact(contact1);
			assertThrows(IllegalArgumentException.class, () -> service.updateContact("5167584", null, "Jenkins", "1234567890", "123 Sesame Street"));	
		}
		
		@Test
		void updateContactThrowsIfLastNameIsNull() {
			ContactService service = new ContactService();
			Contact contact1 = new Contact("5167584", "Leroy", "Jenkins", "1234567890", "123 Sesame Street");
			service.addContact(contact1);
			assertThrows(IllegalArgumentException.class, () -> service.updateContact("5167584", "Leroy", null, "1234567890", "123 Sesame Street"));	
		}
		
		@Test
		void updateContactThrowsIfNumberIsNull() {
			ContactService service = new ContactService();
			Contact contact1 = new Contact("5167584", "Leroy", "Jenkins", "1234567890", "123 Sesame Street");
			service.addContact(contact1);
			assertThrows(IllegalArgumentException.class, () -> service.updateContact("5167584", "Leroy", "Jenkins", null, "123 Sesame Street"));	
		}
		
		@Test
		void updateContactThrowsIfAddressIsNull() {
			ContactService service = new ContactService();
			Contact contact1 = new Contact("5167584", "Leroy", "Jenkins", "1234567890", "123 Sesame Street");
			service.addContact(contact1);
			assertThrows(IllegalArgumentException.class, () -> service.updateContact("5167584", "Leroy", "Jenkins", "1234567890", null));	
		}

}
