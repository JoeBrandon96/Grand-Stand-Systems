package ContactService;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ContactTest {

	// Test for valid Contact creation
		@Test
		void testValidContact() {
			Contact contact = new Contact("5167584", "Leroy", "Jenkins", "1234567890", "123 Sesame Street");
			
			assertAll("Valid Contact Fields",
			() -> assertEquals("5167584", contact.getContactId()),
			() -> assertEquals("Leroy", contact.getFirstName()),
			() -> assertEquals("Jenkins", contact.getLastName()),
			() -> assertEquals("1234567890", contact.getNumber()),
			() -> assertEquals("123 Sesame Street", contact.getAddress())
			);
		}
		
		// Testing the setters because I missed it completely somehow
		@Test
		void testValidSetters() {
			Contact contact = new Contact("5167584", "Leroy", "Jenkins", "1234567890", "123 Sesame Street");
			
			contact.setFirstName("Bob");
			contact.setLastName("Hope");
			contact.setNumber("8675309324");
			contact.setAddress("456 Elm Street");
			
			assertAll("Valid Setter Updates",
					() -> assertEquals("Bob", contact.getFirstName()),
					() -> assertEquals("Hope", contact.getLastName()),
					() -> assertEquals("8675309324", contact.getNumber()),
					() -> assertEquals("456 Elm Street", contact.getAddress())
					);
		}
		
		// Test for throws for coverage
		@Test
		void setFirstNameThrowsIfTooLong() {
			Contact contact = new Contact("5167584", "Leroy", "Jenkins", "1234567890", "123 Sesame Street");
			assertThrows(IllegalArgumentException.class, () -> contact.setFirstName("Lerooooooooooy"));
		}
		
		@Test
		void setFirstNameNull() throws Exception {
			Contact contact = new Contact("5167584", "Leroy", "Jenkins", "1234567890", "123 Sesame Street");
			assertThrows(IllegalArgumentException.class, () -> contact.setFirstName(null));
		}
		
		@Test
		void setLastNameThrowsIfTooLong() throws Exception{
			Contact contact = new Contact("5167584", "Leroy", "Jenkins", "1234567890", "123 Sesame Street");
			assertThrows(IllegalArgumentException.class, () -> contact.setLastName("Jenkiiiiiiiiiiiins"));
		}
		
		@Test
		void setLastNameThrowsIfNull() throws Exception {
			Contact contact = new Contact("5167584", "Leroy", "Jenkins", "1234567890", "123 Sesame Street");
			assertThrows(IllegalArgumentException.class, () -> contact.setLastName(null));
		}
		
		@Test
		void setNumberThrowsIfNot10Characters() {
			Contact contact = new Contact("5167584", "Leroy", "Jenkins", "1234567890", "123 Sesame Street");
			assertAll("Not 10 Characters Tests",
			() ->assertThrows(IllegalArgumentException.class, () -> contact.setNumber("4513849")),
			() -> assertThrows(IllegalArgumentException.class, () -> contact.setNumber("43184164351468")),
			() -> assertThrows(IllegalArgumentException.class, () -> contact.setNumber("44sd1f513sf4634e"))
			);
		}
		
		@Test
		void setNumberThrowsIfNull() {
			Contact contact = new Contact("5167584", "Leroy", "Jenkins", "1234567890", "123 Sesame Street");
			assertThrows(IllegalArgumentException.class, () -> contact.setNumber(null));
		}
		
		@Test
		void setAddressThrowsIfGreaterThan30() {
			Contact contact = new Contact("5167584", "Leroy", "Jenkins", "1234567890", "123 Sesame Street");
			assertThrows(IllegalArgumentException.class, () -> contact.setAddress("I am Beyonce, always. - Michael Scott"));
		}
		
		@Test
		void setAddressThrowsIfNull() {
			Contact contact = new Contact("5167584", "Leroy", "Jenkins", "1234567890", "123 Sesame Street");
			assertThrows(IllegalArgumentException.class, () -> contact.setAddress(null));
		}
		// Test for invalid Contact ID
		@Test
		public void testInvalidContactId() throws Exception {
			
			assertAll("Invalid Contact ID Tests",
					() -> assertThrows(IllegalArgumentException.class,() ->  new Contact(null, "Leroy", "Jenkins", "1234567890", "123 Sesame Street")),
					() -> assertThrows(IllegalArgumentException.class, () -> new Contact("12345678901", "Leroy", "Jenkins", "1234567890", "123 Sesame Street"))
					);
		}
		
		@Test
		public void testInvalidFirstName() throws Exception {
			
			assertAll("Invalid First Name Tests",
			() -> assertThrows(IllegalArgumentException.class, () -> new Contact("5167584", null, "Jenkins", "1234567890", "123 Sesame Street")),
			() -> assertThrows(IllegalArgumentException.class, () -> new Contact("5167584", "Leroooooooooy", "Jenkins", "1234567890", "123 Sesame Street"))
			);
		}
		
		
		@Test
		public void testNullFirstName() {
			assertThrows(IllegalArgumentException.class, () -> new Contact("5167584", null, "Jenkins", "1234567890", "123 Sesame Street"));
		}
		
		//@Test
//		public void testFirstNameTooLong() {
//			assertThrows(IllegalArgumentException.class, () -> new Contact("5167584", "Lerooooooooy", "Jenkins", "1234567890", "123 Sesame Street"));
//		}
		//Test for invalid last name
		@Test
		public void testInvalidLastName() throws Exception {
			assertAll("Invalid Last Name Tests",
			() -> assertThrows(IllegalArgumentException.class, () -> new Contact("5167584", "Leroy", null, "1234567890", "123 Sesame Street")),
			() -> assertThrows(IllegalArgumentException.class, () -> new Contact("5167584", "Leroy", "Jenkiiiiiiiins", "1234567890", "123 Sesame Street"))
			);
		}
		
		//Test for invalid phone number
		@Test
		public void testInvalidNumber() throws Exception {
			
			assertAll("Invalid Number Tests",
			() -> assertThrows(IllegalArgumentException.class, () -> new Contact("5167584", "Leroy", "Jenkins", null, "123 Sesame Street")),
			() -> assertThrows(IllegalArgumentException.class, () -> new Contact("5167584", "Leroy", "Jenkins", "12345", "123 Sesame Street")),
			() -> assertThrows(IllegalArgumentException.class, () -> new Contact("5167584", "Leroy", "Jenkins", "12345678901", "123 Sesame Street")),
			() -> assertThrows(IllegalArgumentException.class, () -> new Contact("5167584", "Leroy", "Jenkins", "123456abcd", "123 Sesame Street"))
			);
		}
		
		//Test for invalid address
		@Test
		public void testInvalidAddress() throws Exception {
			
			assertAll("Invalid Address Tests",
			() -> assertThrows(IllegalArgumentException.class, () -> new Contact("5167584", "Leroy", "Jenkins", "1234567890", null)),
			() -> assertThrows(IllegalArgumentException.class, () -> new Contact("5167584", "Leroy", "Jenkins", "1234567890", "there's no way that this address is valid at all!"))
			);
		}
		
//		@Test
//		public void testImmutableContactId() {
//			Contact contact = new Contact("5167584", "Leroy", "Jenkins", "1234567890", "123 Sesame Street");
		//	assertThrows(IllegalAccessException.class, () -> contact.getClass().getDeclaredField("contactId").set(contact, "67890"));
//		}

}
