package models;

/**
 * This class will be used to store the user's account information at a state.
 * The attributes of this class as follows:
 * <ul>
 *     <li>firstName: String</li>
 *     <li>lastName: String</li>
 *     <li>email: String</li>
 *     <li>uuid: String</li>
 * </ul>
 *
 * @author <a href="https://github.com/vianneynara">Nara</a>
 * */
public class Account {

	private String firstName;
	private String lastName;
	private String email;
	private String uuid;

	public Account(String firstName, String lastName, String email, String uuid) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.uuid = uuid;
	}

	/* Getters setters */

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
}
