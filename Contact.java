package ContactService;

public class Contact {
	private final String contactId;
	private String firstName;
	private String lastName;
	private String number;
	private String address;
	
	public Contact(String contactId, String firstName, String lastName, String number, String address) {
		if (contactId == null || contactId.length() > 10) {
			throw new IllegalArgumentException("Invalid Contact ID.");
		}
		if (firstName == null || firstName.length() > 10) {
			throw new IllegalArgumentException("Invalid First name.");
		}
		if (lastName == null || lastName.length() > 10) {
			throw new IllegalArgumentException("Invalid Last Name.");
		}
		if (number == null || !number.matches("\\d{10}")) {
			throw new IllegalArgumentException("Invalid Phone Number.");
		}
		if (address == null || address.length() > 30) {
			throw new IllegalArgumentException("Invalid Address.");
		}
		this.contactId = contactId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.number = number;
		this.address = address;
	}
	
	public String getContactId() {
		return contactId;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		if (firstName == null || firstName.length() > 10) {
			throw new IllegalArgumentException("Invalid First Name.");
		}
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		if (lastName == null || lastName.length() > 10) {
			throw new IllegalArgumentException("Invalid Last Name.");
		}
		this.lastName = lastName;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		if (number == null || !number.matches("\\d{10}")) {
			throw new IllegalArgumentException("Invalid Number.");
		}
		this.number = number;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		if (address == null || address.length() > 30) {
			throw new IllegalArgumentException("Invalid Address.");
		}
		this.address = address;
	}
}
