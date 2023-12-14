package models.objects;

/**
 * This class will be used to store the user's account information at a state.
 * The attributes of this class as follows:
 * <ul>
 *     <li> {@link #firstName} - User's first name </li>
 *     <li> {@link #lastName} - User's last name </li>
 *     <li> {@link #emailAddress} - User's email </li>
 *     <li> {@link #password} - User's password </li>
 *     <li> {@link #uuid} - Unique User ID </li>
 * </ul>
 *
 * @author <a href="https://github.com/vianneynara">Nara</a>
 * */

public class Account {
	// Attribute declarations
	private String firstName;
	private String lastName;
	private String emailAddress;
	private String password;
	private String uuid;

	public Account(String firstName, String lastName, String emailAddress, String password, String uuid) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
		this.password = password;
		this.uuid = uuid;
	}

	/* Getters setters */

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public String getPassword() {
		return password;
	}

	public String getUuid() {
		return uuid;
	}

}
